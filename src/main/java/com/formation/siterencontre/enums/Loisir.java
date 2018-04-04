package com.formation.siterencontre.enums;

public enum Loisir {


    Bis ("Bis"), Ter ("Ter");

        private String nom;

        private Loisir(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
