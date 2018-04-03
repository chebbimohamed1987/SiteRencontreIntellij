package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Adresse;
import com.formation.siterencontre.entities.Utilisateur;
import com.formation.siterencontre.repositories.AdresseRepository;
import com.formation.siterencontre.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdresseServices {

    private AdresseRepository ar;
    @Autowired
    public AdresseServices(AdresseRepository ar) {
        this.ar = ar;
    }






    public ArrayList<Adresse> getAllAdresse(){

        return  (ArrayList<Adresse>) ar.findAll();
    }
    public void create(Adresse adresse){
        ar.save(adresse);
    }
}
