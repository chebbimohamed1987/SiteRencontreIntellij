package com.formation.siterencontre.controllers;

import com.formation.siterencontre.entities.*;
import com.formation.siterencontre.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Controller
public class UtilisateurController {

    private final UtilisateurServices us;
    private final AdresseServices as;
    private final ApparenceServices aps;
    private final SituationServices ss;
    private final CentreInteretServices cs;
    private final PhotoServices ps;

    @Autowired
    public UtilisateurController(UtilisateurServices us, AdresseServices as, ApparenceServices aps, SituationServices ss, CentreInteretServices cs, PhotoServices ps) {
        this.us = us;
        this.as = as;
        this.aps = aps;
        this.ss = ss;
        this.cs = cs;
        this.ps = ps;
    }

    @PostMapping("/formulaire")
    private String formulaire(@Valid @ModelAttribute(value = "utilisateur") Utilisateur utilisateur, BindingResult resultUtilisateur,
                              @Valid @ModelAttribute(value = "adresse") Adresse adresse, BindingResult resultAdresse,
                              @Valid @ModelAttribute(value = "apparence") Apparence apparence, BindingResult resultApparence,
                              @Valid @ModelAttribute(value = "centreInterets") CentreInteret centreInterets, BindingResult resultCentreInterets,
                              @Valid @ModelAttribute(value = "situation") Situation situation, BindingResult resultSituation,
                              @Valid @ModelAttribute(value = "photo") Photo photo, BindingResult resultPhoto,
                              ModelMap model
    ) {

        if (resultUtilisateur.hasErrors() || resultAdresse.hasErrors() ||
                resultApparence.hasErrors() || resultCentreInterets.hasErrors() ||
                resultSituation.hasErrors() || resultPhoto.hasErrors()) {

            return "inscription";
        }

        utilisateur.setAdresse(adresse);
        utilisateur.setApparence(apparence);
        utilisateur.getCentreInterets().add(centreInterets);
        utilisateur.setSituation(situation);
        /*utilisateur.getPhotos().add(photo);*/
        as.create(adresse);
        aps.create(apparence);
        cs.create(centreInterets);
        ss.create(situation);
        us.create(utilisateur);
        /*ps.create(photo);*/

        return "profil";

    }


    @RequestMapping(value = "/getformulaire", method = RequestMethod.GET)
    public String getFormulaire(ModelMap model) {

        model.addAttribute("adresse", new Adresse());
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("apparence", new Apparence());
        model.addAttribute("centreInterets", new CentreInteret());
        model.addAttribute("situation", new Situation());
        /*   model.addAttribute("photo", new Photo());*/
        return "inscription";
    }

    @RequestMapping(value = "/getprofil/{Email}", method = RequestMethod.GET)
    public ModelAndView getProfil(@PathVariable String Email) {
        Utilisateur utilisateur = us.findUtilisateurByEmail(Email);
        ModelAndView model = new ModelAndView("profil");
        model.addObject("utilisateur", utilisateur);
        model.addObject("adresse", utilisateur.getAdresse());
        model.addObject("apparence", utilisateur.getApparence());
        model.addObject("centreInterets", (utilisateur.getCentreInterets().get(0)));
        model.addObject("situation", utilisateur.getSituation());

        return model;
    }



    @RequestMapping(value = "/getprofils", method = RequestMethod.GET)
    public ModelAndView getProfils() {
        ArrayList<Utilisateur> utilisateurs = us.getAllUtilisateur();
        ModelAndView model = new ModelAndView("profils");
        model.addObject("utilisateurs", utilisateurs);
  /*      model.addObject("adresse", utilisateur.getAdresse());
        model.addObject("apparence", utilisateur.getApparence());
        model.addObject("centreInterets", (utilisateur.getCentreInterets().get(0)));
        model.addObject("situation", utilisateur.getSituation());*/

        return model;
    }


    @GetMapping("/getconnexion")
    public String getConexion() {
        return "connexion";
    }


    @RequestMapping(value = "/connexion", method = RequestMethod.POST)
    private String connexion(@RequestParam("email") String email, @RequestParam("motDePasse") String motDePasse, ModelMap model, HttpSession httpSession) {

        Utilisateur utilisateur = us.findUtilisateurByEmailUtilisateurEtMotDePasse(email, motDePasse);
        if (utilisateur == null) {
            String message = "identifiant ou mot de passe incorrect";
            model.addAttribute("message", message);

            return "connexion";

        }

        this.session(httpSession, utilisateur);
        String message = "Bienvenue sur votre session";
        model.addAttribute("message", message);
        model.addAttribute("utilisateur", utilisateur);
        return "login";
    }



    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    private String deconnexion(ModelMap model, HttpSession httpSession) {

        String message = "Vous êtes deconnecté";
        model.addAttribute("message", message);
        httpSession.invalidate();
        return "logout";
    }




    public void session(HttpSession httpsession, Utilisateur utilisateur) {

        String sessionKey = "dating";
        Object time = httpsession.getAttribute(sessionKey);

        if (time == null) {
            time = LocalDateTime.now();
            httpsession.setAttribute(sessionKey, time);
        }
        httpsession.setAttribute("EmailUtilisateur", utilisateur.getEmailUtilisateur());
        httpsession.setAttribute("pseudo", utilisateur.getPseudo());
        httpsession.setMaxInactiveInterval(30);

    }


}
