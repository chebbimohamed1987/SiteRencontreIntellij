package com.formation.siterencontre.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column (length = 5)
    private Integer codePostal;
    @Column (length = 100)

    private String ville;

    private Integer numero;
    @Column (length = 50)
    @NotNull
    @NotBlank
    private String typeRue;

    @Column (length = 100)
    @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Veuillez saisir le nom de la rue")
    private String nomRue;

    @Column (length = 100)
    @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Veuillez saisir correctement le complement d'adresse")
    private String complement;

    @Column (length = 10)
    private String prefixe;

@OneToMany(mappedBy = "adresse")
private List<Utilisateur> utilisateurs ;


    public Adresse() {
         utilisateurs= new ArrayList<>();
    }

    public Adresse(@NotNull Integer codePostal, String ville, Integer numero, @NotNull @NotBlank String typeRue, @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Veuillez saisir le nom de la rue") String nomRue, @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Veuillez saisir correctement le complement d'adresse") String complement, String prefixe) {
        this.codePostal = codePostal;
        this.ville = ville;
        this.numero = numero;
        this.typeRue = typeRue;
        this.nomRue = nomRue;
        this.complement = complement;
        this.prefixe = prefixe;
        utilisateurs= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTypeRue() {
        return typeRue;
    }

    public void setTypeRue(String typeRue) {
        this.typeRue = typeRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPrefixe() {
        return prefixe;
    }

    public void setPrefixe(String prefixe) {
        this.prefixe = prefixe;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
