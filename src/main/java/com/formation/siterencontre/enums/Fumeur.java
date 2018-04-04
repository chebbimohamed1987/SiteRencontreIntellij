package com.formation.siterencontre.enums;

public enum Fumeur {


    jamais("Jamais"),
    occasionnellement("Occasionnellement"),
    regulierement("Régulièrement");

        private String nom;

        private Fumeur(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
