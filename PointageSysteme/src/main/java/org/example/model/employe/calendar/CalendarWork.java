package org.example.model.employe.calendar;

import org.example.model.employe.Employee;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarWork {
    private List<LocalDate> month;
    private List<LocalDate> normalEmployeeWorkMonth;
    private List<LocalDate> publicHoliday;
    private Employee employee;
    private List<LocalDate> week;

    public CalendarWork(List<LocalDate> month, List<LocalDate> publicHoliday, List<LocalDate> normalEmployeeWorkMonth) {
        this.month = month;
        this.normalEmployeeWorkMonth = normalEmployeeWorkMonth;
        this.publicHoliday = publicHoliday;
        this.week = new ArrayList<>();
    }

    public List<LocalDate> completMonthOfJune() {
        LocalDate beginningOfTheMonth = LocalDate.of(2024, 6, 1);
        LocalDate endOfTheMonth = beginningOfTheMonth.withDayOfMonth(beginningOfTheMonth.lengthOfMonth());
        for (LocalDate date = beginningOfTheMonth; !date.isAfter(endOfTheMonth); date = date.plusDays(1)) {
            if (!isWeekEnd(date)) {
                normalEmployeeWorkMonth.add(date);
                month.add(date);
            } else if (isWeekEnd(date)) {
                week.add(date);
                month.add(date);
            }
            if (isHoliday(date)) {
                publicHoliday.add(date);
            }
        }
        return month;
    }

    public void showMonth() {
        completMonthOfJune();
        System.out.println("all month : " + month);
        System.out.println("holiday in this month : " + publicHoliday);
        System.out.println("week in this month : " + week);
    }

    public int calculateHourOfWorkOfGuardian(Employee employee, IncreasedHour increasedHour) {
        int totalHourMonth = 0;
        int normalWorkHourPerDay = employee.getCategory().getNormalWorkingHour(increasedHour);
        completMonthOfJune();
        for (LocalDate date : month) {
            totalHourMonth += normalWorkHourPerDay;
        }

        return totalHourMonth;
    }

    public double gaurdianSalaryAmount(Employee employee, IncreasedHour increasedHour) {
        int totalHour = calculateHourOfWorkOfGuardian(employee, increasedHour);
        Salary s = new Salary(100000);
        double normalSalary = s.getGrossSalary();
        double bonus = employee.salaryIfIncreasedHour(increasedHour, s);
        if (totalHour == 300) {
            System.out.println(normalSalary);
            return normalSalary;
        } else if (totalHour > 300) {
            System.out.println(bonus);
            return bonus;
        }
        System.out.println(bonus);
        return bonus;
    }

    public boolean isWeekEnd(LocalDate day) {
        DayOfWeek dayOfWeek = day.getDayOfWeek();
        DayOfWeek saturday = DayOfWeek.SATURDAY;
        DayOfWeek sunday = DayOfWeek.SUNDAY;
        if (dayOfWeek.equals(saturday) || dayOfWeek.equals(sunday)) {
            return true;
        }
        return false;
    }

    public boolean isHoliday(LocalDate date) {
        if (
                date.equals(LocalDate.of(2024, 6, 17)) ||
                        date.equals(LocalDate.of(2024, 6, 25)) ||
                        date.equals(LocalDate.of(2024, 6, 26)
                        )) {
            return true;
        }
        return false;
    }
}
