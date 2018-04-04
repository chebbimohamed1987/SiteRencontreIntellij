package com.formation.siterencontre.enums;

public enum Prefixe {


    Bis ("Bis"), Ter ("Ter");

        private String nom;

        private Prefixe(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
