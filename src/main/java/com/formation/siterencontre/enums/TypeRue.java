package com.formation.siterencontre.enums;

public enum TypeRue {
    allee("Allee"),
    avenue("Avenue"),
    boulevard("Boulevard"),
    chemin("Chemin"),
    cite("Cité"),
    esplanade("Esplanade"),
    impasse("Impasse"),
    passage("Passage"),
    place("Place"),
    plaine("Plaine"),
    plateau("Plateau"),
    quartier("Quartier"),
    quai("Quai"),
    residence("Résidence"),
    route("Route"),
    rue("Rue");

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
