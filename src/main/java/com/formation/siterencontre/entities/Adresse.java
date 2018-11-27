package com.formation.siterencontre.entities;


import com.formation.siterencontre.enums.Prefixe;
import com.formation.siterencontre.enums.TypeRue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {
	//ceci est un deuxiem test de master rebase

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;


    @Column (length = 5)
    @Min(value=10000, message = "min 10000")
    @Max(value=99999, message = "max 99999")
    private Integer codePostal;

    @Column (length = 100)
    private String ville;

    private Integer numero;
    @Column (length = 50)
    @NotNull
    @Enumerated (EnumType.STRING)
    private TypeRue typeRue;

    @Column (length = 100)
    @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Veuillez saisir le nom de la rue")
    private String nomRue;

    @Column (length = 100)
    @Pattern(regexp = "(?i)[a-z ]{2,50}", message = "Veuillez saisir correctement le complement d'adresse")
    private String complement;

    @Column (length = 10)
    @Enumerated (EnumType.STRING)
    private Prefixe prefixe;

@OneToMany(mappedBy = "adresse", cascade = {CascadeType.ALL})
private List<Utilisateur> utilisateurs ;


    public Adresse() {
         utilisateurs= new ArrayList<>();
    }

    public Adresse( Integer codePostal, String ville, Integer numero,  TypeRue typeRue,  String nomRue, String complement, Prefixe prefixe) {
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

    public TypeRue getTypeRue() {
        return typeRue;
    }

    public void setTypeRue(TypeRue typeRue) {
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

    public Prefixe getPrefixe() {
        return prefixe;
    }

    public void setPrefixe(Prefixe prefixe) {
        this.prefixe = prefixe;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
