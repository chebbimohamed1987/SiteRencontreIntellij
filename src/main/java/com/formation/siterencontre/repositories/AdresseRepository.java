package com.formation.siterencontre.repositories;

import com.formation.siterencontre.entities.Adresse;
import com.formation.siterencontre.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository <Adresse, Long> {
}
