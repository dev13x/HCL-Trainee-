package assignment.assessment1.app;

import assignment.assessment1.model.Accountant;
import assignment.assessment1.model.Admin;
import assignment.assessment1.model.Employee;
import assignment.assessment1.model.Engineer;
import assignment.assessment1.model.Manager;
import assignment.assessment1.model.SalaryStructure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * Assessment 1 - Sample employee records for the bonus calculation system.
 * Uses salary components: basic, HRA, travel allowance, and special allowance.
 */
public final class SampleEmployees {

    private SampleEmployees() {
    }

    public static List<Employee> create() {
        List<Employee> list = new ArrayList<>();
        list.add(new Manager(101, "Dev", salary("42000", "16800", "3000", "5000")));
        list.add(new Engineer(102, "Neha", salary("36000", "14400", "2500", "4500")));
        list.add(new Admin(103, "Arjun", salary("29000", "11600", "2000", "3000")));
        list.add(new Accountant(104, "Sara", salary("33000", "13200", "2000", "3500")));
        list.add(new Engineer(105, "Isha", salary("38000", "15200", "2500", "6000")));
        list.add(new Manager(106, "Rohan", salary("54000", "21600", "3500", "7500")));
        list.add(new Accountant(107, "Kavita", salary("46000.50", "18400.20", "2500", "4500")));
        list.add(new Admin(108, "Manish", salary("31000", "12400", "1800", "2800")));
        return list;
    }

    private static SalaryStructure salary(String basic, String hra, String ta, String sa) {
        return new SalaryStructure(
                new BigDecimal(basic),
                new BigDecimal(hra),
                new BigDecimal(ta),
                new BigDecimal(sa));
    }
}
