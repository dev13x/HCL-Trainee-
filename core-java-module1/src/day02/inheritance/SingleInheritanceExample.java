package day02.inheritance;

/*
 * Day 02 - Single inheritance:  Vehicle -> Car
 */
public class SingleInheritanceExample {

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

    public static void main(String[] args) {
        Car car = new Car();
        car.start();        // inherited from Vehicle
        car.openBoot();     // defined in Car
    }
}
