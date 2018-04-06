package com.formation.siterencontre.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeMultimedia;
    private String genre;

    private String titre;
    private String artiste;


    @ManyToMany
    private List<CentreInteret> centreInterets;

}
