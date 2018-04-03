package com.formation.siterencontre.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class CentreInteret {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    private String sport;
    @NotNull
    @NotBlank
    private String loisir;



    @ManyToMany(mappedBy = "centreInterets")
    private List<Utilisateur> utilisateurs;

    @ManyToMany (mappedBy = "centreInterets")
    private List<Multimedia> multimedia;

}
