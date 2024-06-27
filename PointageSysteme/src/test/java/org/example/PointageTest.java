package org.example;

import org.example.model.employe.Employee;
import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.category.Guardian;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PointageTest {
    @Test
    void workingHourRakoto() {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rakotoSalary = new Salary(100000);
        IncreasedHour rabeincreasedHour = new IncreasedHour(false, false, false);
        Employee rakoto = new Employee("Rakoto", 2, "2003-08-07", "2024-05-05", "2027-05-05", rakotoSalary, rabeincreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rakoto, rabeincreasedHour, rakotoSalary);
        rakoto.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(june, holiday, normalEmployeeWorkMonth);

        assertEquals(300, calendarWork.calculateHourOfWorkOfGuardian(rakoto, rabeincreasedHour));
    }

    @Test
    void workingHourRabe() {
        List<LocalDate> sixWeek = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeincreasedHour = new IncreasedHour(true, false, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeincreasedHour);
        Guardian guardianRabe = new Guardian("Guardian", rabe, rabeincreasedHour, rabeSalary);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(sixWeek, holiday, normalEmployeeWorkMonth);

        assertEquals(588, calendarWork.calculateHourOfWorkSixWeek(rabe, rabeincreasedHour));
    }

    @Test
    void SalaryOfRabe() {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeIncreasedHour = new IncreasedHour(true, false, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeIncreasedHour);
        Guardian guardianRabe = new Guardian("Guardian", rabe, rabeIncreasedHour, rabeSalary);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(june, holiday, normalEmployeeWorkMonth);

        assertEquals(130000.0, calendarWork.gaurdianSalaryAmount(rabe,rabeIncreasedHour,rabeSalary),0.01);
    }

    @Test
    void SalaryOfRakoto() {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rakotoSalary = new Salary(100000);
        IncreasedHour rakotoIncreasedHour = new IncreasedHour(false, false, false);
        Employee rakoto = new Employee("Rakoto", 2, "2003-08-07", "2024-05-05", "2027-05-05", rakotoSalary, rakotoIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rakoto, rakotoIncreasedHour, rakotoSalary);
        rakoto.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(june, holiday, normalEmployeeWorkMonth);

        assertEquals(100000,  calendarWork.gaurdianSalaryAmount(rakoto,rakotoIncreasedHour,rakotoSalary),0.01);
    }
}
