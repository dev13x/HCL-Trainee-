package day02.constructors;

/*
 * Day 02 - super() and the order of constructors
 * Creating a child object runs the parent constructor first, then the child constructor.
 */
public class SuperConstructorExample {

    static class Vehicle {
        Vehicle() {
            System.out.println("1. Vehicle constructor");
        }
    }

    static class Car extends Vehicle {
        Car() {
            super();    // optional here: the compiler inserts it automatically
            System.out.println("2. Car constructor");
        }
    }

    public static void main(String[] args) {
        new Car();
    }
}
