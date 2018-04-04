package com.formation.siterencontre.enums;

public enum Alcool {


    jamais("Jamais"),
    occasionnellement("Occasionnellement"),
    regulierement("Régulièrement");

        private String nom;

        private Alcool(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
