package com.formation.siterencontre.enums;

public enum Sport {


    Bis ("Bis"), Ter ("Ter");

        private String nom;

        private Sport(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
