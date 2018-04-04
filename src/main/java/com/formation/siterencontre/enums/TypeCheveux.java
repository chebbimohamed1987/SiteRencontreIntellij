package com.formation.siterencontre.enums;

public enum TypeCheveux {


    Chauve("Chauve"),
    Boucle("Bouclé"),
    Court("Court"),
    Milong("Milong"),
    Long("Long");

        private String nom;

        private TypeCheveux(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
