package day02.inheritance;

/*
 * Day 02 - Multilevel inheritance:  Vehicle -> Car -> ElectricCar
 */
public class MultilevelInheritanceExample {

    static class Vehicle {
        void start() {
            System.out.println("Vehicle starts");
        }
    }

    static class Car extends Vehicle {
        void openBoot() {
            System.out.println("Car opens its boot");
        }
    }

    static class ElectricCar extends Car {
        void charge() {
            System.out.println("ElectricCar charges its battery");
        }
    }

    public static void main(String[] args) {
        ElectricCar ev = new ElectricCar();
        ev.start();         // from Vehicle
        ev.openBoot();      // from Car
        ev.charge();        // from ElectricCar
    }
}
