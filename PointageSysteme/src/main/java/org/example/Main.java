package org.example;

import org.example.model.employe.Employe;
import org.example.model.employe.calendrier.Calendrier;
import org.example.model.employe.salaire.Salaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> mois = new ArrayList<>();
        List<LocalDate> joursFeries = new ArrayList<>();
        List<LocalDate> weekend = new ArrayList<>();
        Calendrier calendrier = new Calendrier(mois, joursFeries , weekend);
        calendrier.mois();

        System.out.println("Calendrier :"+mois);
        System.out.println("jours feriés :"+joursFeries);
        System.out.println("week_end:"+ weekend);
    }
}
