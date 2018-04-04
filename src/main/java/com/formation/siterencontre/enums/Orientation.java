package com.formation.siterencontre.enums;

public enum Orientation {


    hetero("Heterosexuel(le)"),
    homo("Homosexuel(le)"),
    bisexuel("Bisexuel(le)");

        private String nom;

        private Orientation(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
