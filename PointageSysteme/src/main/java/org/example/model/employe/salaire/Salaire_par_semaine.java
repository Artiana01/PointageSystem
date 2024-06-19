package org.example.model.employe.salaire;

public class Salaire_par_semaine {
    private double salaire_heure_normal;

    public Salaire_par_semaine(double salaire_heure_normal) {
        this.salaire_heure_normal = salaire_heure_normal;
    }

    public double getSalaire_heure_normal() {
        return salaire_heure_normal;
    }
}
