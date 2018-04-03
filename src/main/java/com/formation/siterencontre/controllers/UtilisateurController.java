package com.formation.siterencontre.controllers;

import com.formation.siterencontre.entities.Adresse;
import com.formation.siterencontre.entities.Utilisateur;
import com.formation.siterencontre.services.AdresseServices;
import com.formation.siterencontre.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UtilisateurController {

   private UtilisateurServices us;
    private AdresseServices as;
@Autowired
    public UtilisateurController(UtilisateurServices us) {
        this.us = us;
    }

    @RequestMapping(value = "/formulaire", method = RequestMethod.POST)
    private String formulaire() {

        return "index";

    }


    @RequestMapping(value = "/getformulaire", method = RequestMethod.GET)
    public String getFormulaire(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";
    }


}
