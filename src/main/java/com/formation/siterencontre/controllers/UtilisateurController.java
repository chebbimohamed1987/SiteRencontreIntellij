package com.formation.siterencontre.controllers;

import com.formation.siterencontre.entities.*;
import com.formation.siterencontre.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
public class UtilisateurController {

    private final UtilisateurServices us;
    private final AdresseServices as;
    private final ApparenceServices aps;
    private final SituationServices ss;
    private final CentreInteretServices cs;
    @Autowired
    public UtilisateurController(UtilisateurServices us, AdresseServices as, ApparenceServices aps, SituationServices ss, CentreInteretServices cs) {
        this.us = us;
        this.as = as;
        this.aps = aps;
        this.ss = ss;
        this.cs = cs;
    }

    @RequestMapping(value = "/formulaire", method = RequestMethod.POST)
    private String formulaire1(@Validated @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult resultUtilisateur,
                               @Validated @ModelAttribute("adresse") Adresse adresse, BindingResult resultAdresse,
                               @Validated @ModelAttribute("apparence") Apparence apparence, BindingResult resultApparence,
                               @Validated @ModelAttribute("centreInterets") CentreInteret centreInterets, BindingResult resultCentreInterets,
                               @Validated @ModelAttribute("situation")  Situation situation, BindingResult resultSituation
                               ) {


     us.create(utilisateur);
     as.create(adresse);
     aps.create(apparence);
     cs.create(centreInterets);
     ss.create(situation);


     utilisateur.setAdresse(adresse);
     utilisateur.setApparence(apparence);
     utilisateur.getCentreInterets().add(centreInterets);
     utilisateur.setSituation(situation);


        return "index";

    }



    @RequestMapping(value = "/getformulaire", method = RequestMethod.GET)
    public String getFormulaire(ModelMap model) {

        model.addAttribute("adresse", new Adresse());
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("apparence", new Apparence());
        model.addAttribute("centreInterets", new CentreInteret());
        model.addAttribute("situation", new Situation());

        return "inscription";

    }


}
