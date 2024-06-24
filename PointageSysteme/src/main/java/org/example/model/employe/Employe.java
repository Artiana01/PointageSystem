package org.example.model.employe;

import org.example.model.employe.salaire.Salaire;
import org.example.model.employe.calendrier.Calendrier;

import java.time.LocalDate;
import java.util.List;

public class Employe {
    private final String nom_complet;
    private final int numero_matricule;
    private final String date_de_naissance;
    private final String date_embauche;
    private String date_fin_de_contrat;
    private Salaire montant_salaire;
    private String categorie;

    public Employe(String nom_complet, int numero_matricule, String date_de_naissance, String date_embauche, String date_fin_de_contrat, Salaire montant_salaire, String categorie) {
        this.nom_complet = nom_complet;
        this.numero_matricule = numero_matricule;
        this.date_de_naissance = date_de_naissance;
        this.date_embauche = date_embauche;
        this.date_fin_de_contrat = date_fin_de_contrat;
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

    public String getDate_fin_de_contrat() {
        return date_fin_de_contrat;
    }

    public void setDate_fin_de_contrat(String date_fin_de_contrat) {
        this.date_fin_de_contrat = date_fin_de_contrat;
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

    public int calculer_heures_travail(List<LocalDate> jours_travailles, Calendrier calendrier) {
        int total_heures = 0;
        for (LocalDate jour : jours_travailles) {
            if (!calendrier.est_jour_ferie(jour) && !calendrier.est_week_end(jour)) {
                total_heures += 10; 
            } else {
                total_heures += 14;
            }
        }
        return total_heures;
    }

    public double calculer_heures_majorees(List<LocalDate> jours_travailles, Calendrier calendrier) {
        double total_heures_majorees = 0;
        for (LocalDate jour : jours_travailles) {
            if (calendrier.est_jour_ferie(jour) || calendrier.est_week_end(jour)) {
                total_heures_majorees += 14;
            }
        }
        return total_heures_majorees * 1.3;
    }

    public double calculer_heures_supplementaires(int heures_normales, int heures_travail) {
        int heures_supplementaires = heures_travail - heures_normales;
        if (heures_supplementaires > 20) {
            heures_supplementaires = 20;
        }
        return heures_supplementaires > 0 ? heures_supplementaires * 1.3 : 0;
    }

    public double calculer_salaire_brut(int heures_travail, double salaire_par_semaine) {
        return (heures_travail / 40.0) * salaire_par_semaine;
    }

    public double calculer_salaire_net(double salaire_brut) {
        return salaire_brut * 0.8;
    }
}
