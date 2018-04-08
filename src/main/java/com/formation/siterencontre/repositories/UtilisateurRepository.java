package com.formation.siterencontre.repositories;

import com.formation.siterencontre.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, String>{


    Utilisateur findUtilisateurByEmailUtilisateurAndMotDePasse(String EmailUtilisateur, String motDePasse)  ;
    Utilisateur findUtilisateurByEmailUtilisateur(String EmailUtilisateur);

}
