package day02.constructors;

import day02.access.Logger;

/*
 * Day 02 - Constructors: the default constructor
 *  - a constructor has the same name as the class and no return type
 *  - if a class declares no constructor, the compiler generates a no-argument one
 */
public class DefaultConstructorExample {

    private final String model;

    // a no-argument constructor written by us
    public DefaultConstructorExample() {
        model = "Generic laptop";
        System.out.println("Laptop created: " + model);
    }

    // no constructor declared here, so the compiler adds a default one
    static class Charger {
        int watts;      // gets the default value 0
    }

    public static void main(String[] args) {
        new DefaultConstructorExample();

        Charger charger = new Charger();
        System.out.println("Charger watts (default value): " + charger.watts);

        // Logger is in another package and has a public constructor, so this is allowed
        new Logger();
    }
}
