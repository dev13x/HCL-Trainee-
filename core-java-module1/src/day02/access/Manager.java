package day02.access;

import day02.encapsulation.Employee;

/*
 * Manager is in a different package from Employee. As a subclass it can call
 * Employee's protected method on itself.
 */
public class Manager extends Employee {

    public void showManager() {
        System.out.println("-- Manager profile --");
        printSummary();     // protected method inherited from Employee
    }
}
