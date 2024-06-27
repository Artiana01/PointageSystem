package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

public sealed abstract class Category permits
        Senior,
        Driver,
        Guardian,
        Normal {
    private final String name;
    public int normalWorkingHour;
    public double salaryPerWeek;
    private double compensation;
    private IncreasedHour increasedHour;
    private Salary salary;

    public Category(String name, double salaryPerWeek, double compensation,IncreasedHour increasedHour,Salary salary) {
        this.name = name;
        this.normalWorkingHour = 0;
        this.salaryPerWeek = salaryPerWeek;
        this.compensation = compensation;
        this.increasedHour = increasedHour;
    }

    public abstract String additionalHour(int hour);

    public String getName() {
        return name;
    }

    public int getNormalWorkingHour() {
        return normalWorkingHour;
    }

    public double getSalaryPerWeek() {
        return salaryPerWeek;
    }

    public double getCompensation() {
        return compensation;
    }

    public abstract int getNormalWorkingHour( IncreasedHour increasedHour);
}
