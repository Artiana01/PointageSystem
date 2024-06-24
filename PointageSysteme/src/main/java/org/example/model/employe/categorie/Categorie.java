package org.example.model.employe.categorie;

import org.example.model.employe.salaire.Salaire_par_semaine;

public sealed abstract class  Categorie permits
        CadreSuperieur,
        Chauffeur,
        Gardien,
        Normal {
    private final String nom;
    private int heure_normale_travail;
    public double salaire_par_semaine;
    private double indemnite;

    public Categorie(String nom, int heure_normale_travail, double salaire_par_semaine, double indemnite) {
        this.nom = nom;
        this.heure_normale_travail = heure_normale_travail;
        this.salaire_par_semaine = salaire_par_semaine;
        this.indemnite = indemnite;
    }

    public abstract String heure_supp(int heure);

    public String getNom() {
        return nom;
    }

    public int getHeure_normale_travail() {
        return heure_normale_travail;
    }

    public double getSalaire_par_semaine() {
        return salaire_par_semaine;
    }

    public double getIndemnite() {
        return indemnite;
    }
}

