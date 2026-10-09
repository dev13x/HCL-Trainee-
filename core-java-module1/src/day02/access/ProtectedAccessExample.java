package day02.access;

import day02.encapsulation.Employee;

/*
 * Day 02 - protected access across packages
 */
public class ProtectedAccessExample {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setName("Karan");
        manager.setSalary(90000);
        manager.showManager();

        Employee employee = new Employee();
        employee.setName("Isha");
        // employee.printSummary();     // compile error: protected, and this class is not a subclass of Employee
        System.out.println("Plain employee: " + employee.getName());
    }
}
