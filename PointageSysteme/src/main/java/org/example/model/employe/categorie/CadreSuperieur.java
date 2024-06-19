package org.example.model.employe.categorie;

import org.example.model.employe.NotImplemented;

public final class CadreSuperieur extends Categorie{
    public CadreSuperieur(String nom, int heure_normale_travail, double salaire_par_semaine,double indemnite) {
        super(nom, heure_normale_travail, salaire_par_semaine,indemnite);
    }

    @Override
    public String heure_supp(int heure) {
        throw new NotImplemented();
    }
}
