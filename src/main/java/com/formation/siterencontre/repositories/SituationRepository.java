package com.formation.siterencontre.repositories;

import com.formation.siterencontre.entities.Situation;
import com.formation.siterencontre.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituationRepository extends JpaRepository <Situation, Long> {
}
