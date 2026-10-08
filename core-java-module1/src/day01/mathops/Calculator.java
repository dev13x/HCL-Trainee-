package day01.mathops;

/*
 * Day 01 - Packages
 * A small utility class kept in its own package. Other packages can use it only
 * because the class and its methods are declared public.
 */
public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int difference(int a, int b) {
        return a - b;
    }

    public int product(int a, int b) {
        return a * b;
    }

    public double quotient(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor must not be zero");
        }
        return (double) a / b;
    }

    // static helper: can be imported on its own with "import static"
    public static int cube(int n) {
        return n * n * n;
    }
}
