package org.example.model.employe.salary;

import org.example.model.employe.Employee;

public class Salary {
    private final double grossSalary;
    private double netSalary;
    private double salaryPerWeek;
    public Salary(double grossSalary) {
        this.grossSalary = grossSalary;
        this.netSalary = netSalaryCalculation();
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    @Override
    public String toString() {
        return " salaire net = "+netSalary;
    }

    public double netSalaryCalculation(){
        double calcul = getGrossSalary() * 0.8;
        netSalary +=  calcul;
        return netSalary;
    }

}
