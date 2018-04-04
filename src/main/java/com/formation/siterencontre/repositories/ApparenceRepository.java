package com.formation.siterencontre.repositories;

import com.formation.siterencontre.entities.Apparence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApparenceRepository extends JpaRepository <Apparence, Long> {
}
