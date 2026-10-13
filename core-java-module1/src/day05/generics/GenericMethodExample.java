package day05.generics;

import java.util.Arrays;
import java.util.List;

/*
 * Day 05 - Generic methods, bounded type parameters (<T extends Comparable<T>>), and upper-bounded wildcards
 */
public class GenericMethodExample {

    // Generic method: <T> is scoped to this method
    public static <T> void displayArray(T[] elements) {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Bounded type parameter: T must implement Comparable<T>
    public static <T extends Comparable<T>> T maxOf(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Upper-bounded wildcard: accepts List<Integer>, List<Double>, or any subclass of Number
    public static double totalOf(List<? extends Number> values) {
        double sum = 0;
        for (Number val : values) {
            sum += val.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] rollNumbers = {10, 20, 30};
        String[] students = {"Neha", "Arjun", "Sara"};
        displayArray(rollNumbers);
        displayArray(students);

        System.out.println("maxOf(18, 42)          : " + maxOf(18, 42));
        System.out.println("maxOf('cat', 'tiger')  : " + maxOf("cat", "tiger"));
        System.out.println("maxOf(4.8, 2.3)        : " + maxOf(4.8, 2.3));

        System.out.println("totalOf integers       : " + totalOf(Arrays.asList(10, 20, 30)));
        System.out.println("totalOf doubles        : " + totalOf(Arrays.asList(2.5, 4.5, 3.0)));
    }
}
