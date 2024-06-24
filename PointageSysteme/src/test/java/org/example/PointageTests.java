package org.example;

import org.example.model.employe.Employe;
import org.example.model.employe.calendrier.Calendrier;
import org.example.model.employe.salaire.Salaire;

import java.time.LocalDate;
import java.util.List;

public class PointageTests {

    public static void main(String[] args) {
        Calendrier calendrier = new Calendrier();
        List<LocalDate> joursTravailles = calendrier.getJoursTravailles();

        Employe rakoto = new Employe("Rakoto", 1, "1990-01-01", "2020-01-01", null, new Salaire(100000), "Gardien");
        Employe rabe = new Employe("Rabe", 2, "1990-01-01", "2020-01-01", null, new Salaire(100000), "Gardien");

        int heuresTravailRakoto = rakoto.calculerHeuresTravail(joursTravailles, calendrier);
        double salaireBrutRakoto = rakoto.calculerSalaireBrut(heuresTravailRakoto, 600000.0);
        double salaireNetRakoto = rakoto.calculerSalaireNet(salaireBrutRakoto);

        int heuresTravailRabe = rabe.calculerHeuresTravail(joursTravailles, calendrier);
        double salaireBrutRabe = rabe.calculerSalaireBrut(heuresTravailRabe, 600000.0 * 1.3);
        double salaireNetRabe = rabe.calculerSalaireNet(salaireBrutRabe);

        System.out.println("Rakoto: Heures de travail: " + heuresTravailRakoto + ", Salaire brut: " + salaireBrutRakoto + ", Salaire net: " + salaireNetRakoto);
        System.out.println("Rabe: Heures de travail: " + heuresTravailRabe + ", Salaire brut: " + salaireBrutRabe + ", Salaire net: " + salaireNetRabe);
    }
}
