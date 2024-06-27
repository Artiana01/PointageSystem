package org.example;

import org.example.model.employe.Employee;
import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.category.Category;
import org.example.model.employe.category.Guardian;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rakotoSalary = new Salary(100000);
        IncreasedHour rabeincreasedHour = new IncreasedHour(true,true,false);
        Employee rabe = new Employee("Rabe",2,"2003-08-07","2024-05-05","2027-05-05",rakotoSalary,rabeincreasedHour);
        Guardian guardianRabe = new Guardian("Guardian",rabe,rabeincreasedHour,rakotoSalary);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(sixMonths,holiday,normalEmployeeWorkMonth);
        calendarWork.calculateHourOfWorkSixWeek(rabe,rabeincreasedHour);
        /*Employee rakoto = new Employee("Rakoto",1,"2003-08-07","2024-05-05","2027-05-05",rakotoSalary,rakotoIncreasedHour);*/
        /*Guardian guardianRakoto = new Guardian("Guardian",rakoto);*/
        /*rakoto.setCategory(guardianRakoto);*/
        /*calendarWork.showMonth();*/
        /*calendarWork.gaurdianSalaryAmount(rabe,rabeincreasedHour,rakotoSalary);*/
    }
}

