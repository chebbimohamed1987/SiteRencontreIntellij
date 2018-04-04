package com.formation.siterencontre.enums;

public enum CouleurYeux {

    brun("Bruns"),
    bleu("Bleus"),
    vert("Verts"),
    noir("Noirs");

        private String nom;

        private CouleurYeux(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
