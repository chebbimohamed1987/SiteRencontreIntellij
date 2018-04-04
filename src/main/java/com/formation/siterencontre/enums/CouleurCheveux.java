package com.formation.siterencontre.enums;

public enum CouleurCheveux {

    noir("Noirs"),
    brun("Bruns"),
    roux("Roux"),
    chatain("Chatains"),
    blond("Blonds"),
    blanc("Blanc");

        private String nom;

        private CouleurCheveux(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
