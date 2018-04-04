package com.formation.siterencontre.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Apparence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull

    private Integer taille;
    @NotNull

    private String couleurYeux;
    @NotNull
    @NotBlank
    private String origine;
    @NotNull

    private String couleurCheveux;
    @NotNull

    private String typeCheveux;
    @NotNull
    private float masse;

    @OneToMany(mappedBy = "apparence")
    private List<Utilisateur> utilisateurs;

    public Apparence() {
    }

    public Apparence(@NotNull @NotBlank Integer taille, @NotNull @NotBlank String couleurYeux, @NotNull @NotBlank String origine, @NotNull @NotBlank String couleurCheveux, @NotNull @NotBlank String typeCheveux, @NotNull @NotBlank float masse) {
        this.taille = taille;
        this.couleurYeux = couleurYeux;
        this.origine = origine;
        this.couleurCheveux = couleurCheveux;
        this.typeCheveux = typeCheveux;
        this.masse = masse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public String getCouleurYeux() {
        return couleurYeux;
    }

    public void setCouleurYeux(String couleurYeux) {
        this.couleurYeux = couleurYeux;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getCouleurCheveux() {
        return couleurCheveux;
    }

    public void setCouleurCheveux(String couleurCheveux) {
        this.couleurCheveux = couleurCheveux;
    }

    public String getTypeCheveux() {
        return typeCheveux;
    }

    public void setTypeCheveux(String typeCheveux) {
        this.typeCheveux = typeCheveux;
    }

    public float getMasse() {
        return masse;
    }

    public void setMasse(float masse) {
        this.masse = masse;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
