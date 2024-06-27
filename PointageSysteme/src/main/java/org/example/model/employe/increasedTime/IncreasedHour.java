package org.example.model.employe.increasedTime;

public class IncreasedHour {
    private boolean night;
    private boolean sunday;
    private boolean holiday;

    public IncreasedHour(boolean night, boolean sunday, boolean holiday) {
        this.night = night;
        this.sunday = sunday;
        this.holiday = holiday;
    }

    public boolean isNight() {
        return night;
    }

    public boolean isSunday() {
        return sunday;
    }

    public boolean isHoliday() {
        return holiday;
    }
}
