package day02.inheritance;

/*
 * Day 02 - Hierarchical inheritance: more than one child shares a parent
 *
 *            Vehicle
 *           /       \
 *         Car       Bike
 *        /   \
 *    Sedan   Suv
 */
public class HierarchicalInheritanceExample {

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

    static class Bike extends Vehicle {
        void kickStart() {
            System.out.println("Bike is kick-started");
        }
    }

    static class Sedan extends Car {
        void foldRearSeat() {
            System.out.println("Sedan folds its rear seat");
        }
    }

    static class Suv extends Car {
        void engageFourWheelDrive() {
            System.out.println("Suv engages four-wheel drive");
        }
    }

    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.start();
        bike.kickStart();

        Sedan sedan = new Sedan();
        sedan.start();          // from Vehicle
        sedan.openBoot();       // from Car
        sedan.foldRearSeat();

        Suv suv = new Suv();
        suv.openBoot();         // from Car
        suv.engageFourWheelDrive();
    }
}
