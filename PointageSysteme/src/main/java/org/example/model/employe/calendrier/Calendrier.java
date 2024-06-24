package org.example.model.employe.calendrier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendrier {
    private List<LocalDate> mois = new ArrayList<>();
    private List<LocalDate> jour_feries = new ArrayList<>();
    private List<LocalDate> week_end = new ArrayList<>();

    public Calendrier() {
        this.mois = new ArrayList<>();
        this.jour_feries = new ArrayList<>();
        this.week_end = new ArrayList<>();
        this.jour_feries.add(LocalDate.of(2024, 6, 17));
        this.jour_feries.add(LocalDate.of(2024, 6, 25));
        this.jour_feries.add(LocalDate.of(2024, 6, 26));
    }

    public void mois() {
        LocalDate debut_du_mois = LocalDate.of(2024, 6, 1);
        LocalDate fin_du_mois = debut_du_mois.withDayOfMonth(debut_du_mois.lengthOfMonth());
        for (LocalDate date = debut_du_mois; !date.isAfter(fin_du_mois); date = date.plusDays(1)) {
            mois.add(date);
            if (est_week_end(date)) {
                week_end.add(date);
            }
        }
    }

    public boolean est_week_end(LocalDate jour) {
        DayOfWeek dayOfWeek = jour.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public boolean est_jour_ferie(LocalDate jour) {
        return jour_feries.contains(jour);
    }

    public List<LocalDate> getMois() {
        return mois;
    }

    public List<LocalDate> getJourFeries() {
        return jour_feries;
    }

    public List<LocalDate> getWeekEnd() {
        return week_end;
    }

    public void ajouterJourFerie(LocalDate jourFerie) {
        jour_feries.add(jourFerie);
    }
}
