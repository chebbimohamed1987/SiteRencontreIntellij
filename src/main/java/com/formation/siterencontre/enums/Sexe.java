package com.formation.siterencontre.enums;

public enum Sexe {


        H("Homme"), F("Femme");

        private String nom;

        private Sexe(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
