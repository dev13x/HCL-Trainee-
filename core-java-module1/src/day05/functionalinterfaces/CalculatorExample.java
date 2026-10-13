package day05.functionalinterfaces;

/*
 * Day 05 - Implementing a functional interface in three ways:
 * 1. Named class
 * 2. Anonymous inner class
 * 3. Lambda expression (and method reference)
 */
public class CalculatorExample {

    static class Adder implements Calculator {
        @Override
        public int compute(int x, int y) {
            return x + y;
        }
    }

    static int runOperation(int x, int y, Calculator op) {
        return op.compute(x, y);
    }

    public static void main(String[] args) {
        // 1. Named class
        Calculator add = new Adder();
        add.printResult(12, 4);                                         // 16

        // 2. Anonymous inner class
        Calculator subtract = new Calculator() {
            @Override
            public int compute(int x, int y) {
                return x - y;
            }
        };
        subtract.printResult(12, 4);                                    // 8

        // 3. Lambda with single expression
        Calculator multiply = (x, y) -> x * y;
        multiply.printResult(12, 4);                                    // 48

        // Lambda with block body and return statement
        Calculator safeDivide = (x, y) -> {
            if (y == 0) {
                System.out.println("Division by zero is not allowed");
                return 0;
            }
            return x / y;
        };
        safeDivide.printResult(12, 4);                                  // 3
        safeDivide.printResult(12, 0);                                  // 0

        // Passing a lambda or method reference directly as a method argument
        System.out.println("Remainder (15 % 4) : " + runOperation(15, 4, (x, y) -> x % y));
        System.out.println("Maximum (15, 4)    : " + runOperation(15, 4, Math::max));
    }
}
