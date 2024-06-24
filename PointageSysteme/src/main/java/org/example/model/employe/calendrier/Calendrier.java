package org.example.model.employe.calendrier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendrier {
    private List<LocalDate> mois = new ArrayList<>();
    private List<LocalDate> jourFeries = new ArrayList<>();
    private List<LocalDate> weekEnd = new ArrayList<>();

    public Calendrier() {
        Mois();
        JourFeries();
    }

    public void Mois() {
        LocalDate debutMois = LocalDate.of(2024, 5, 26);
        LocalDate finMois = LocalDate.of(2024, 7, 6);

        LocalDate date = debutMois;
        while (!date.isAfter(finMois)) {
            mois.add(date);
            if (estWeekEnd(date)) {
                weekEnd.add(date);
            }
            date = date.plusDays(1);
        }
    }

    private void JourFeries() {
        jourFeries.add(LocalDate.of(2024, 6, 17));
        jourFeries.add(LocalDate.of(2024, 6, 25));
        jourFeries.add(LocalDate.of(2024, 6, 26));
    }

    public boolean estWeekEnd(LocalDate jour) {
        DayOfWeek dayOfWeek = jour.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public boolean estJourFerie(LocalDate jour) {
        return jourFeries.contains(jour);
    }

    public List<LocalDate> getMois() {
        return mois;
    }

    public List<LocalDate> getJourFeries() {
        return jourFeries;
    }

    public List<LocalDate> getWeekEnd() {
        return weekEnd;
    }

    public void ajouterJourFerie(LocalDate jourFerie) {
        jourFeries.add(jourFerie);
    }

    public List<LocalDate> getJoursTravailles() {
        List<LocalDate> joursTravailles = new ArrayList<>();
        for (LocalDate jour : mois) {
            if (!estWeekEnd(jour) && !estJourFerie(jour)) {
                joursTravailles.add(jour);
            }
        }
        return joursTravailles;
    }
}
