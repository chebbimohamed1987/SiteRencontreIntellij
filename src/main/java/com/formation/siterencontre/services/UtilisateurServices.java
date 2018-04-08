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

    public void create(Utilisateur utilisateur){ ur.save(utilisateur);   }

    public ArrayList<Utilisateur> getAllUtilisateur(){  return  (ArrayList<Utilisateur>) ur.findAll(); }

    public Utilisateur findById (String id){return  ur.findById(id).get(); }

    public void update(Utilisateur utilisateur){ ur.save(utilisateur);  }

    public void delete (String id){   ur.deleteById(id); }

    public void deletAll (){ ur.deleteAll(); }

    public long taille(){
        return ur.count();
    }


   public  Utilisateur findUtilisateurByEmail(String EmailUtilisateur){

        return ur.findUtilisateurByEmailUtilisateur (EmailUtilisateur);
    }

    public  Utilisateur findUtilisateurByEmailUtilisateurEtMotDePasse(String EmailUtilisateur,String motDePasse ){
    return ur.findUtilisateurByEmailUtilisateurAndMotDePasse(EmailUtilisateur, motDePasse);

    }

}




