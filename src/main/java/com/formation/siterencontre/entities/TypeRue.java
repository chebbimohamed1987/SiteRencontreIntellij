package com.formation.siterencontre.entities;

public enum TypeRue {


    Boulevard ("Boulevard"), Avenue ("Avenue"), Rue("Rue");

        private String nom;

        private TypeRue(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }



}
