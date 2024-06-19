package org.example.model.employe;

import org.example.model.employe.salaire.Salaire;

public class Employe {
    private final String nom_complet;
    private final int numero_matricule;
    private final String date_de_naissance;
    private final String date_embauche;
    private String date_find_de_contrat;
    private Salaire montant_salaire;
    private String categorie;

    public Employe(String nom_complet,
                   int numero_matricule,
                   String date_de_naissance,
                   String date_embauche,
                   String date_find_de_contrat,
                   Salaire montant_salaire,
                   String categorie) {
        this.nom_complet = nom_complet;
        this.numero_matricule = numero_matricule;
        this.date_de_naissance = date_de_naissance;
        this.date_embauche = date_embauche;
        this.date_find_de_contrat = date_find_de_contrat;
        this.montant_salaire = montant_salaire;
        this.categorie = categorie;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public int getNumero_matricule() {
        return numero_matricule;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getDate_embauche() {
        return date_embauche;
    }

    public String getDate_find_de_contrat() {
        return date_find_de_contrat;
    }

    public void setDate_find_de_contrat(String date_find_de_contrat) {
        this.date_find_de_contrat = date_find_de_contrat;
    }

    public Salaire getMontant_salaire() {
        return montant_salaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
