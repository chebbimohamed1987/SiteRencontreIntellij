package com.formation.siterencontre.controllers;

import com.formation.siterencontre.entities.*;
import com.formation.siterencontre.enums.Alcool;
import com.formation.siterencontre.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.ModelAttribute;


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
    private String formulaire(@Valid @ModelAttribute(value="utilisateur") Utilisateur utilisateur, BindingResult resultUtilisateur,
                               @Valid @ModelAttribute(value="adresse") Adresse adresse, BindingResult resultAdresse,
                               @Valid @ModelAttribute(value="apparence") Apparence apparence, BindingResult resultApparence,
                               @Valid @ModelAttribute(value="centreInterets") CentreInteret centreInterets, BindingResult resultCentreInterets,
                               @Valid @ModelAttribute(value="situation")  Situation situation, BindingResult resultSituation,
                              @Valid @ModelAttribute(value="photo")  Photo photo, BindingResult resultPhoto,
                              ModelMap model
                               ) {

        if (resultUtilisateur.hasErrors() || resultAdresse.hasErrors() ||
                resultApparence.hasErrors() || resultCentreInterets.hasErrors() ||
                resultSituation.hasErrors()||resultPhoto.hasErrors() ) {

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
ModelMap model2= new ModelMap();
        model2.addAttribute("adresse", adresse);
        model2.addAttribute("utilisateur", utilisateur);
        model2.addAttribute("apparence", apparence);
        model2.addAttribute("centreInterets", centreInterets);
        model2.addAttribute("situation", situation);


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

    @RequestMapping(value = "/getprofil", method = RequestMethod.GET)
    public String getProfil (ModelMap model2){

        Adresse adresse= as.findById(1L);
        Apparence apparence = aps.findById(1L);
        CentreInteret centreInterets = cs.findById(1L);
        Situation situation=ss.findById(1L);
        Utilisateur utilisateur = us.findById("chebbimohamed@live.fr");
        
        model2.addAttribute("adresse", adresse);
        model2.addAttribute("utilisateur", utilisateur);
        model2.addAttribute("apparence", apparence);
        model2.addAttribute("centreInterets", centreInterets);
        model2.addAttribute("situation", situation);
        return "profil";
    }


}
