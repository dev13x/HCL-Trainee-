package day05.lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * Day 05 - Lambda expressions: syntax variations, collection helpers, and variable capture
 */
public class LambdaExpressionExample {

    public static void main(String[] args) {
        demonstrateSyntax();
        System.out.println();
        demonstrateCollectionLambdas();
        System.out.println();
        demonstrateVariableCapture();
    }

    private static void demonstrateSyntax() {
        // Zero parameters
        Runnable task = () -> System.out.println("Running a zero-argument lambda");
        task.run();

        // Single parameter (parentheses optional)
        Function<Integer, Integer> cube = n -> n * n * n;
        System.out.println("cube(4)   = " + cube.apply(4));

        // Two parameters with explicit types
        BiFunction<Integer, Integer, Integer> sum = (Integer a, Integer b) -> a + b;
        System.out.println("sum(7, 8) = " + sum.apply(7, 8));

        // Multi-statement block body with return
        BiFunction<Integer, Integer, Integer> min = (a, b) -> {
            if (a < b) {
                return a;
            }
            return b;
        };
        System.out.println("min(7, 8) = " + min.apply(7, 8));
    }

    private static void demonstrateCollectionLambdas() {
        List<String> names = new ArrayList<>();
        names.add("Sara");
        names.add("Neha");
        names.add("Arjun");
        names.add("Dev");

        names.forEach(name -> System.out.println("Student: " + name));
        names.forEach(System.out::println);                             // method reference

        names.removeIf(name -> name.startsWith("D"));                   // Predicate
        System.out.println("After removeIf   : " + names);

        names.replaceAll(name -> name.toUpperCase());                   // UnaryOperator
        System.out.println("After replaceAll : " + names);

        names.sort((a, b) -> a.compareTo(b));                           // Comparator
        System.out.println("After sort       : " + names);

        Map<Integer, String> directory = new HashMap<>();
        directory.put(1, "Neha");
        directory.put(2, "Arjun");
        directory.forEach((roll, student) -> System.out.println("Roll " + roll + " -> " + student));
    }

    // Local variables referenced inside a lambda must be final or effectively final
    private static void demonstrateVariableCapture() {
        int graceMarks = 5;
        Function<Integer, Integer> applyGrace = score -> score + graceMarks;
        System.out.println("Score with grace : " + applyGrace.apply(78));
    }
}
