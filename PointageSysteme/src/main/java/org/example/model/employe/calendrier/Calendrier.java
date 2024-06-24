package org.example.model.employe.calendrier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendrier {
    private List<LocalDate> mois = new ArrayList<>();
    private List<LocalDate> jour_feries = new ArrayList<>();
    private List<LocalDate> week_end = new ArrayList<>();

    public Calendrier(List<LocalDate> mois, List<LocalDate> jour_feries , List<LocalDate> week_end) {
        this.mois = mois;
        this.jour_feries = jour_feries;
        this.jour_feries.add(LocalDate.of(2024, 6, 17));
        this.jour_feries.add(LocalDate.of(2024, 6, 25));
        this.jour_feries.add(LocalDate.of(2024, 6, 26));

    }

    public void mois() {
        LocalDate debut_du_mois = LocalDate.of(2024, 6, 1);
        LocalDate fin_du_mois = debut_du_mois.withDayOfMonth(debut_du_mois.lengthOfMonth());
        for (LocalDate date = debut_du_mois; !date.isAfter(fin_du_mois); date = date.plusDays(1)) {
            mois.add(date);
        }
    }

    public boolean est_week_end(LocalDate jour) {
        DayOfWeek dayOfWeek = jour.getDayOfWeek();
        DayOfWeek saturday = DayOfWeek.SATURDAY;
        DayOfWeek sunday = DayOfWeek.SUNDAY;
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;

        if (dayOfWeek.equals(dayOfWeek.saturday) || dayOfWeek.equals(dayOfWeek.sunday)) {
            return true;
        }
        return false;
    }

    public boolean est_jour_ferie(LocalDate jour) {
        return jour_feries.contains(jour);
    }
}
