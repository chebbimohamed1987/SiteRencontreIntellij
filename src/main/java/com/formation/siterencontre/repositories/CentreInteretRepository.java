package com.formation.siterencontre.repositories;

import com.formation.siterencontre.entities.CentreInteret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreInteretRepository extends JpaRepository <CentreInteret, Long> {
}
