package day01.launcher;

import day01.mathops.Calculator;
import static day01.mathops.Calculator.cube;

/*
 * Day 01 - Using a class from another package
 *   import         -> brings in the Calculator class
 *   import static  -> brings in one static method, callable without the class name
 */
public class CalculatorMain {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int x = 12;
        int y = 4;

        System.out.println(x + " + " + y + " = " + calc.sum(x, y));
        System.out.println(x + " - " + y + " = " + calc.difference(x, y));
        System.out.println(x + " x " + y + " = " + calc.product(x, y));
        System.out.println(x + " / " + y + " = " + calc.quotient(x, y));
        System.out.println("cube(3) = " + cube(3));
    }
}
