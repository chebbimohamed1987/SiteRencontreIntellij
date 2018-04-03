package com.formation.siterencontre.controllers;

import com.formation.siterencontre.entities.Adresse;
import com.formation.siterencontre.entities.TypeRue;
import com.formation.siterencontre.entities.Utilisateur;
import com.formation.siterencontre.services.AdresseServices;
import com.formation.siterencontre.services.UtilisateurServices;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilisateurController {

    private UtilisateurServices us;
    private AdresseServices as;
@Autowired
    public UtilisateurController(UtilisateurServices us) {
        this.us = us;
    }

    @RequestMapping(value = "/formulaire1", method = RequestMethod.POST)
    private String formulaire1(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        System.out.println(utilisateur.getNom());


     us.create(utilisateur);

        return "index";

    }

    @RequestMapping(value = "/formulaire2", method = RequestMethod.POST)
    private String formulaire2(@ModelAttribute("adresse") Adresse adresse ) {
        System.out.println(adresse.getCodePostal());


        as.create(adresse);

        return "index";

    }


    @RequestMapping(value = "/getformulaire", method = RequestMethod.GET)
    public String getFormulaire(Model model) {

        model.addAttribute("adresse", new Adresse());
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";

    }


}
