package day02.encapsulation;

/*
 * Day 02 - Encapsulation: private fields reached through getters and setters
 */
public class EncapsulationExample {

    public static void main(String[] args) {
        Employee emp = new Employee();

        // emp.salary = 50000;      // not allowed: salary is private
        emp.setName("Neha");
        emp.setSalary(52000);
        System.out.println(emp.getName() + " -> " + emp.getSalary());

        emp.setSalary(-100);        // blocked by the setter
        System.out.println("Salary is still " + emp.getSalary());

        emp.printSummary();         // protected, but we are in the same package
    }
}
