package com.formation.siterencontre.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Photo {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String lien;

    private Integer note;




    @ManyToOne
    @JoinColumn(name = "utilisateur")
    @JsonIgnore
    private Utilisateur utilisateur;

    public Photo() {
    }

    public Photo(String lien, Integer note) {
        this.lien = lien;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
