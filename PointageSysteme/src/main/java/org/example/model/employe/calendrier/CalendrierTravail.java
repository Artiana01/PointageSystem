package org.example.model.employe.calendrier;

import org.example.model.employe.NotImplemented;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendrierTravail {
    private List<LocalDate> mois = new ArrayList<>();
    private List<LocalDate> jour_feries = new ArrayList<>();

    public CalendrierTravail(List<LocalDate> mois, List<LocalDate> jour_feries) {
        this.mois = mois;
        jour_feries.add(LocalDate.of(2024, 6, 17));
        jour_feries.add(LocalDate.of(2024, 6, 25));
        jour_feries.add(LocalDate.of(2024, 6, 26));
    }

    public void remplir_mois_de_juin() {
        LocalDate debut_du_mois = LocalDate.of(2024, 6, 1);
        LocalDate fin_du_mois = debut_du_mois.withDayOfMonth(debut_du_mois.lengthOfMonth());
        for (LocalDate date = debut_du_mois; !date.isAfter(fin_du_mois); date = date.plusDays(1)) {
            mois.add(date);
        }
    }


    public boolean est_week_end(LocalDate jour) {
        DayOfWeek dayOfWeek = jour.getDayOfWeek();
        DayOfWeek samedi = DayOfWeek.SATURDAY;
        DayOfWeek dimanche = DayOfWeek.SUNDAY;
        if (dayOfWeek.equals(samedi) || dayOfWeek.equals(dimanche)) {
            return true;
        }
        return false;
    }

    public boolean est_jour_ferie(LocalDate jour) {
        for (LocalDate ferie : jour_feries) {
            if (
                    ferie.equals(LocalDate.of(2024, 6, 17)) ||
                            ferie.equals(LocalDate.of(2024, 6, 25)) ||
                            ferie.equals(LocalDate.of(2024, 6, 17)
                            )) {
                return true;
            }
        }
        return false;
    }
}
