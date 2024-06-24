package org.example.model.employe;

import org.example.model.employe.calendrier.Calendrier;
import org.example.model.employe.salaire.Salaire;

import java.time.LocalDate;
import java.util.List;

public class Employe {
    private final String nomComplet;
    private final int numeroMatricule;
    private final String dateDeNaissance;
    private final String dateEmbauche;
    private String dateFinDeContrat;
    private Salaire montantSalaire;
    private String categorie;

    public Employe(String nomComplet, int numeroMatricule, String dateDeNaissance, String dateEmbauche, String dateFinDeContrat, Salaire montantSalaire, String categorie) {
        this.nomComplet = nomComplet;
        this.numeroMatricule = numeroMatricule;
        this.dateDeNaissance = dateDeNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateFinDeContrat = dateFinDeContrat;
        this.montantSalaire = montantSalaire;
        this.categorie = categorie;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public int getNumeroMatricule() {
        return numeroMatricule;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public String getDateFinDeContrat() {
        return dateFinDeContrat;
    }

    public void setDateFinDeContrat(String dateFinDeContrat) {
        this.dateFinDeContrat = dateFinDeContrat;
    }

    public Salaire getMontantSalaire() {
        return montantSalaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int calculerHeuresTravail(List<LocalDate> joursTravailles, Calendrier calendrier) {
        int totalHeures = 0;
        for (LocalDate jour : joursTravailles) {
            if (!calendrier.estJourFerie(jour) && !calendrier.estWeekEnd(jour)) {
                if (this.categorie.equals("Gardien")) {
                    totalHeures += 10; // 10 heures pour le travail de jour
                } else {
                    totalHeures += 14; // 14 heures pour le travail de nuit
                }
            }
        }
        return totalHeures;
    }

    public double calculerHeuresMajorees(List<LocalDate> joursTravailles, Calendrier calendrier) {
        double totalHeuresMajorees = 0;
        for (LocalDate jour : joursTravailles) {
            if (calendrier.estJourFerie(jour)) {
                if (this.categorie.equals("Gardien")) {
                    totalHeuresMajorees += 10; // 10 heures majorées pour le travail de jour
                } else {
                    totalHeuresMajorees += 14; // 14 heures majorées pour le travail de nuit
                }
            } else if (!calendrier.estWeekEnd(jour)) {
                if (this.categorie.equals("Gardien")) {
                    totalHeuresMajorees += 10 * 1.3; // 10 heures majorées pour le travail de jour + 30%
                } else {
                    totalHeuresMajorees += 14 * 1.5; // 14 heures majorées pour le travail de nuit + 50%
                }
            }
        }
        return totalHeuresMajorees;
    }

    public double calculerSalaireBrut(int heuresTravail, double salaireParSemaine) {
        return (heuresTravail / 40.0) * salaireParSemaine; // Salaire brut pour 40 heures par semaine
    }

    public double calculerSalaireNet(double salaireBrut) {
        return salaireBrut * 0.8; // Salaire net après déduction des taxes
    }
}
