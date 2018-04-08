package com.formation.siterencontre.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class CentreInteret {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Verifier ce champs")
    private String sport;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Verifier ce champs")
    private String loisir;



    @ManyToMany(mappedBy = "centreInterets")
    private List<Utilisateur> utilisateurs;

    @ManyToMany (mappedBy = "centreInterets")
    private List<Multimedia> multimedia;


    public CentreInteret() {
    }

    public CentreInteret(@NotNull @NotBlank String sport, @NotNull @NotBlank String loisir) {
        this.sport = sport;
        this.loisir = loisir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getLoisir() {
        return loisir;
    }

    public void setLoisir(String loisir) {
        this.loisir = loisir;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }
}
