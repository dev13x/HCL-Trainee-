package day03.abstraction;

/*
 * Day 03 - Abstraction: working with different shapes through the abstract type
 */
public class AbstractionExample {

    public static void main(String[] args) {
        // Shape shape = new Shape();      // compile error: Shape is abstract

        Shape[] shapes = { new Rectangle(5, 3), new Circle(2) };
        for (Shape shape : shapes) {
            shape.describe();
        }
    }
}
