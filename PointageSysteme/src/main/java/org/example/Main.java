package org.example;

import org.example.model.employe.calendrier.Calendrier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> mois = new ArrayList<>();
        List<LocalDate> joursFeries = new ArrayList<>();
        List<LocalDate> weekend = new ArrayList<>();
        Calendrier calendrier = new Calendrier();
        calendrier.mois();

        System.out.println("Calendrier : " + calendrier.getMois());
        System.out.println("Jours fériés : " + calendrier.getJourFeries());
        System.out.println("Week-end : " + calendrier.getWeekEnd());
    }
}
