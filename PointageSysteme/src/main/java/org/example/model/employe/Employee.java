package org.example.model.employe;

import org.example.model.employe.category.Category;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

public class Employee {
    private final String fullName;
    private final int serialNumber;
    private final String dateOfBirth;
    private final String hiringDate;
    private String endDateOfContract;
    private Salary salaryAmount;
    private Category category;
    private IncreasedHour increasedHour;


    public Employee(String fullName,
                    int serialNumber,
                    String dateOfBirth,
                    String hiringDate,
                    String endDateOfContract,
                    Salary salaryAmount,
                    IncreasedHour increasedHour) {
        this.fullName = fullName;
        this.serialNumber = serialNumber;
        this.dateOfBirth = dateOfBirth;
        this.hiringDate = hiringDate;
        this.endDateOfContract = endDateOfContract;
        this.salaryAmount = salaryAmount;
        this.category = null;
        this.increasedHour = increasedHour;
    }

    public double salaryIfIncreasedHour(IncreasedHour increasedHour,Salary salaryAmount){
        double bonus = 0;
        double salary = salaryAmount.getGrossSalary();
        if(increasedHour.isNight() && !increasedHour.isSunday() && !increasedHour.isHoliday()){
             bonus += 0.3;
             salary += (salary*bonus);
        }else if (increasedHour.isSunday() && !increasedHour.isNight() && !increasedHour.isHoliday()){
            bonus += 0.4;
            salary += (salary*bonus);
        }else if(increasedHour.isHoliday() && !increasedHour.isNight()&& !increasedHour.isSunday()){
            bonus += 0.5;
            salary += (salary*bonus);
        }else if (increasedHour.isNight() && increasedHour.isSunday() && increasedHour.isHoliday()){
            bonus += 1.2;
            salary += (salary*bonus);
        }else if (increasedHour.isNight() && increasedHour.isSunday() && !increasedHour.isHoliday()){
            bonus += 0.7;
            salary += (salary*bonus);
        }else if (increasedHour.isNight() && !increasedHour.isSunday() && increasedHour.isHoliday()){
            bonus += 0.8;
            salary += (salary*bonus);
        }else if (!increasedHour.isNight() && increasedHour.isSunday() && increasedHour.isHoliday()){
            bonus += 0.9;
            salary += (salary*bonus);
        }else{
            return salary;
        }
        return salary;
    }

    public Salary getSalaryAmount() {
        return salaryAmount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFullName() {
        return fullName;
    }
}
