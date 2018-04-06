package com.formation.siterencontre.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Situation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre situation professionnelle")
    private String statutPro;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez choisir votre situation personnelle")
    private String statutPerso;
    @NotNull

    private Integer nbrEnfant;
    private String orientation;
    private String fumeur;
    private String alcool;

    @OneToMany(mappedBy = "situation")
    private List<Utilisateur> utilisateurs;


    public Situation() {
        utilisateurs= new ArrayList<>();
    }

    public Situation(@NotNull @NotBlank @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre situation professionnelle") String statutPro, @NotNull @NotBlank @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez choisir votre situation personnelle") String statutPerso, @NotNull @NotBlank Integer nbrEnfant, String orientation, String fumeur, String alcool) {
        this.statutPro = statutPro;
        this.statutPerso = statutPerso;
        this.nbrEnfant = nbrEnfant;
        this.orientation = orientation;
        this.fumeur = fumeur;
        this.alcool = alcool;
        utilisateurs= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }



    public String getStatutPro() {
        return statutPro;
    }

    public void setStatutPro(String statutPro) {
        this.statutPro = statutPro;
    }

    public String getStatutPerso() {
        return statutPerso;
    }

    public void setStatutPerso(String statutPerso) {
        this.statutPerso = statutPerso;
    }

    public Integer getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(Integer nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getFumeur() {
        return fumeur;
    }

    public void setFumeur(String fumeur) {
        this.fumeur = fumeur;
    }

    public String getAlcool() {
        return alcool;
    }

    public void setAlcool(String alcool) {
        this.alcool = alcool;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
