package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Utilisateur;
import com.formation.siterencontre.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UtilisateurServices {

    private UtilisateurRepository ur;

    @Autowired
    public UtilisateurServices(UtilisateurRepository ur) {
        this.ur = ur;
    }



    public ArrayList<Utilisateur> getAllUtilisateur(){

        return  (ArrayList<Utilisateur>) ur.findAll();
    }
}
