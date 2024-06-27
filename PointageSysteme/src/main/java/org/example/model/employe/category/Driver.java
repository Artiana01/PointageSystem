package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.NotImplemented;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

public final class Driver extends Category {
    public Driver(String name, double salaryPerWeek, double compensation,IncreasedHour increasedHour,Salary salary) {
        super(name, salaryPerWeek,compensation,increasedHour,salary);
        this.normalWorkingHour = getNormalWorkingHour();
    }

    @Override
    public String additionalHour(int hour) {
        throw new NotImplemented();
    }

    @Override
    public int getNormalWorkingHour( IncreasedHour increasedHour) {
        throw new NotImplemented();
    }
}
