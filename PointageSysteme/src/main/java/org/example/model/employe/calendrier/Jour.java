package org.example.model.employe.calendrier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class Jour {
    private LocalDate jour;

    public Jour(LocalDate jour) {
        this.jour = jour;
    }

    public LocalDate getJour() {
        return jour;
    }
}
