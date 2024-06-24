package org.example;

import org.example.model.employe.calendrier.Calendrier;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Calendrier calendrier = new Calendrier();

        calendrier.Mois();

        System.out.println("Mois : " + calendrier.getMois());
        System.out.println("Jours fériés : " + calendrier.getJourFeries());
        System.out.println("Week-end : " + calendrier.getWeekEnd());
    }
}
