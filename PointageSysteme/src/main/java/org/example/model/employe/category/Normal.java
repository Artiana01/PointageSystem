package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.NotImplemented;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

public final class Normal extends Category {
    public Normal(String name, double salaryPerWeek, double compensation,IncreasedHour increasedHour,Salary salary) {
        super(name, salaryPerWeek,compensation,increasedHour,salary);
        this.normalWorkingHour = getNormalWorkingHour();
    }


    @Override
    public String additionalHour(int hour) {
        double compensationAdditionnalHour = getCompensation();
        double normalSalaryPerWeek = getSalaryPerWeek();
        if(hour<20){
              if(hour <= 8){
                  compensationAdditionnalHour = getSalaryPerWeek() * 0.3;
                  normalSalaryPerWeek += compensationAdditionnalHour;
                  return "additional hour = "+hour+", indemnite = "+ compensationAdditionnalHour+", salaire par semaine = "+normalSalaryPerWeek;
              }else if(hour >= 12){
                  compensationAdditionnalHour = getSalaryPerWeek() * 0.5;
                  normalSalaryPerWeek += compensationAdditionnalHour;
                  return "additional hour = "+hour+", indemnite = "+ compensationAdditionnalHour+", salaire par semaine = "+normalSalaryPerWeek;
              }
        }
        return ("0 compensation because you have exceed the normal hour");
    }

    @Override
    public int getNormalWorkingHour( IncreasedHour increasedHour) {
        throw new NotImplemented();
    }
}
