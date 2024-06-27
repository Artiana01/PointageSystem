package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.NotImplemented;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

public final class Guardian extends Category {
    public Guardian(String name,Employee employee,IncreasedHour increasedHour,Salary salary){
        super(name, 110000, 0,increasedHour,salary);
        this.normalWorkingHour = getNormalWorkingHour(increasedHour);
    }
    @Override
    public String additionalHour(int heure) {
        throw new NotImplemented();
    }

    @Override
    public int getNormalWorkingHour(IncreasedHour increasedHour) {
        int workHour = 0;
        if(increasedHour.isNight()){
            workHour += 14;
        }else if(!increasedHour.isNight()){
            workHour += 10;
        }
        return workHour;
    }
}
