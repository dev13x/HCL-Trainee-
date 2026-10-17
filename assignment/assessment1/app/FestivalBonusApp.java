package assignment.assessment1.app;

import assignment.assessment1.model.Employee;
import assignment.assessment1.report.BonusReportPrinter;
import assignment.assessment1.service.BonusService;

import java.util.List;

/*
 * Assessment 1 - FestivalBonusApp: Main entry point for the bonus calculation and reporting application.
 */
public class FestivalBonusApp {

    public static void main(String[] args) {
        try {
            List<Employee> employees = SampleEmployees.create();
            List<Employee> sortedByBonus = new BonusService().sortByBonusDescending(employees);
            new BonusReportPrinter(System.out).print(sortedByBonus);
        } catch (IllegalArgumentException ex) {
            System.err.println("Error generating festival bonus report: " + ex.getMessage());
        }
    }
}
