package day03.abstraction;

/*
 * Day 03 - Abstraction with an abstract class
 * Shape says WHAT every shape must offer (area, perimeter); each subclass decides HOW.
 * An abstract class cannot be instantiated, but it can still contain normal methods.
 */
public abstract class Shape {

    public abstract double area();

    public abstract double perimeter();

    // normal method shared by all shapes
    public void describe() {
        System.out.printf("%s -> area = %.2f, perimeter = %.2f%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}
