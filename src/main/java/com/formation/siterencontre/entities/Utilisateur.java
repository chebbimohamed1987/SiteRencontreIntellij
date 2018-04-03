package com.formation.siterencontre.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "{com.example.demo.entities.Carnet.constraint.Email.message}")
    @Column(length = 100)
    @NotNull

    private String emailUtilisateur;

    @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre nom")
    @NotNull
    @NotBlank
    private String nom;

    @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre prenom")
    @NotNull
    @NotBlank
    private String prenom;

    @Column(name = "DateDeNaissance")
    @DateTimeFormat
    @NotNull
    private String DateDeNaissance;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Sexe sexe;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Le mot de passe doit contenir au minimum un chiffre, une lettre majuscule, une lettre miniscule et un symbol")
    @Column(name = "MotDePasse" ,length=50)
    private String motDePasse;

    @Column(length = 250)
    private String description;

    @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre prenom")
    private String pseudo;

    @Column(length = 100)
    @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "Veuillez saisir votre numero de telephone")
    private String numeroTel;

    @Column(name= "admin", length = 100)
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "adresse")
    @JsonIgnore
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "situation")
    @JsonIgnore
    private Situation situation;

    @ManyToOne
    @JoinColumn(name = "apparence")
    @JsonIgnore
    private Apparence apparence;

    @OneToMany(mappedBy = "utilisateur")
    private List<Photo> photos;

    @ManyToMany
private List<CentreInteret> centreInterets;


    @ManyToMany
    private List<Utilisateur> favoris;



    public Utilisateur() {

    }

    public Utilisateur(@Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre nom") @NotNull @NotBlank String nom, @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre prenom") @NotNull @NotBlank String prenom, @NotNull String dateDeNaissance, @NotNull Sexe sexe, @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Le mot de passe doit contenir au minimum un chiffre, une lettre majuscule, une lettre miniscule et un symbol") String motDePasse, String description, @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Veuillez saisir votre prenom") String pseudo, @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "Veuillez saisir votre numero de telephone") String numeroTel, Integer type) {
        this.nom = nom;
        this.prenom = prenom;
        DateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.motDePasse = motDePasse;
        this.description = description;
        this.pseudo = pseudo;
        this.numeroTel = numeroTel;
        this.type = type;

    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDeNaissance() {
        return DateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        DateDeNaissance = dateDeNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Apparence getApparence() {
        return apparence;
    }

    public void setApparence(Apparence apparence) {
        this.apparence = apparence;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<CentreInteret> getCentreInterets() {
        return centreInterets;
    }

    public void setCentreInterets(List<CentreInteret> centreInterets) {
        this.centreInterets = centreInterets;
    }

    public List<Utilisateur> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Utilisateur> favoris) {
        this.favoris = favoris;
    }
}
