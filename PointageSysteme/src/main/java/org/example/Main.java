package org.example;

import org.example.model.employe.Employe;
import org.example.model.employe.calendrier.CalendrierTravail;
import org.example.model.employe.salaire.Salaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> mois = new ArrayList<>();
        List<LocalDate> joursFeries = new ArrayList<>();
        CalendrierTravail calendrier = new CalendrierTravail(mois, joursFeries);
        calendrier.remplir_mois_de_juin();

        Salaire salaireRakoto = new Salaire(110000);
        Employe rakoto = new Employe("Rakoto", 1, "1980-01-01", "2020-01-01", "2025-01-01", salaireRakoto, "Gardien");

        Salaire salaireRabe = new Salaire(110000);
        Employe rabe = new Employe("Rabe", 2, "1985-01-01", "2020-01-01", "2025-01-01", salaireRabe, "Gardien");

        List<LocalDate> joursTravaillesRakoto = new ArrayList<>();
        List<LocalDate> joursTravaillesRabe = new ArrayList<>();

        for (LocalDate jour : mois) {
            if (!calendrier.est_jour_ferie(jour)) {
                joursTravaillesRakoto.add(jour);
                joursTravaillesRabe.add(jour);
            }
        }

        int heuresTravailRakoto = rakoto.calculer_heures_travail(joursTravaillesRakoto, calendrier);
        int heuresTravailRabe = rabe.calculer_heures_travail(joursTravaillesRabe, calendrier);

        double salaireBrutRakoto = rakoto.calculer_salaire_brut(heuresTravailRakoto, rakoto.getMontant_salaire().getSalaire_brut());
        double salaireNetRakoto = rakoto.calculer_salaire_net(salaireBrutRakoto);

        double salaireBrutRabe = rabe.calculer_salaire_brut(heuresTravailRabe, rabe.getMontant_salaire().getSalaire_brut());
        double salaireNetRabe = rabe.calculer_salaire_net(salaireBrutRabe);

        System.out.println("Rakoto:");
        System.out.println("Heures de travail: " + heuresTravailRakoto);
        System.out.println("Salaire brut: " + salaireBrutRakoto);
        System.out.println("Salaire net: " + salaireNetRakoto);

        System.out.println("Rabe:");
        System.out.println("Heures de travail: " + heuresTravailRabe);
        System.out.println("Salaire brut: " + salaireBrutRabe);
        System.out.println("Salaire net: " + salaireNetRabe);
    }
}
