package org.example.model.employe.categorie;

import org.example.model.employe.NotImplemented;
import org.example.model.employe.salaire.Salaire_par_semaine;

public final class Normal extends Categorie {
    public Normal(String nom, int heure_normale_travail, double salaire_par_semaine, double indemnite) {
        super(nom, heure_normale_travail, salaire_par_semaine,indemnite);
    }
    public Normal(String nom) {
        this(nom, 40, 100000, 0);
    }


    @Override
    public String heure_supp(int heure) {
        double indemnite_h_supp = getIndemnite();
        double salaire_semaine_normal = getSalaire_par_semaine();
        if(heure<20){
              if(heure <= 8){
                  indemnite_h_supp = getSalaire_par_semaine() * 0.3;
                  salaire_semaine_normal += indemnite_h_supp;
                  return "heure supplementaire = "+heure+", indemnite = "+ indemnite_h_supp+", salaire par semaine = "+salaire_semaine_normal;
              }else if(heure >= 12){
                  indemnite_h_supp = getSalaire_par_semaine() * 0.5;
                  salaire_semaine_normal += indemnite_h_supp;
                  return "heure supplementaire = "+heure+", indemnite = "+ indemnite_h_supp+", salaire par semaine = "+salaire_semaine_normal;
              }
        }
        return ("vous avez fait plus de 20h par semaine , -> 0 indemnite");
    }
}
