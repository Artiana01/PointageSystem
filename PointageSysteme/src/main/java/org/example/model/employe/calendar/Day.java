package org.example.model.employe.calendar;

import java.time.LocalDate;

public class Day {
    private LocalDate day;

    public Day(LocalDate day) {
        this.day = day;
    }

    public LocalDate getDay() {
        return day;
    }
}
