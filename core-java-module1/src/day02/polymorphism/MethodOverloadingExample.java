package day02.polymorphism;

/*
 * Day 02 - Method overloading (compile-time polymorphism)
 * Same method name, different parameters. The compiler picks the version from the arguments.
 */
public class MethodOverloadingExample {

    static double area(int side) {                  // square
        return side * side;
    }

    static double area(int length, int width) {     // rectangle
        return length * width;
    }

    static double area(double radius) {             // circle
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println("Square (side 4): " + area(4));
        System.out.println("Rectangle (4 x 6): " + area(4, 6));
        System.out.printf("Circle (radius 2.5): %.2f%n", area(2.5));
    }
}
