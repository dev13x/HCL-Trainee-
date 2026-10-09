package day02.encapsulation;

/*
 * Day 02 - Encapsulation
 * The fields are private; the outside world uses getters and setters, so the class
 * can validate the data it stores.
 */
public class Employee {

    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Rejected negative salary: " + salary);
            return;
        }
        this.salary = salary;
    }

    // protected: visible in this package and to subclasses, even in other packages
    protected void printSummary() {
        System.out.println(name + " earns " + salary);
    }
}
