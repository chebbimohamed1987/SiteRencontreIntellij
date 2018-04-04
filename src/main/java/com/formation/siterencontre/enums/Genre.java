package com.formation.siterencontre.enums;

public enum Genre {


    Bis ("Bis"), Ter ("Ter");

        private String nom;

        private Genre(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
