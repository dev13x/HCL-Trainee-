package day05.wrappers;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 05 - Autoboxing (primitive -> wrapper) and Unboxing (wrapper -> primitive)
 * Includes common pitfalls: Integer caching with ==, unboxing null, and List.remove overload.
 */
public class AutoboxingExample {

    static int square(Integer n) {
        return n * n;                               // unboxed automatically before multiplication
    }

    public static void main(String[] args) {
        Integer boxed = 25;                         // autoboxing: Integer.valueOf(25)
        int primitive = boxed;                      // unboxing: boxed.intValue()
        System.out.println("boxed = " + boxed + ", primitive = " + primitive);

        // Arithmetic unboxes, computes, and re-boxes the result
        Integer updated = boxed + 10;
        updated++;
        System.out.println("updated = " + updated);

        // Autoboxing/unboxing across method parameters and return values
        System.out.println("square(12) = " + square(12));

        // Autoboxing and unboxing with collections
        List<Integer> scores = new ArrayList<>();
        scores.add(75);                             // int -> Integer
        scores.add(88);
        scores.add(91);

        int firstScore = scores.get(0);             // Integer -> int
        int total = 0;
        for (int s : scores) {
            total += s;
        }
        System.out.println("scores = " + scores + ", first = " + firstScore + ", total = " + total);

        showPitfalls();
    }

    private static void showPitfalls() {
        System.out.println();
        System.out.println("--- Wrapper Pitfalls ---");

        // 1. Integer caches values from -128 to 127; use .equals() instead of ==
        Integer p = 100;
        Integer q = 100;
        Integer x = 500;
        Integer y = 500;
        System.out.println("100 == 100     : " + (p == q));         // true (cached object)
        System.out.println("500 == 500     : " + (x == y));         // false (distinct objects)
        System.out.println("500.equals(500): " + x.equals(y));      // true (value comparison)

        // 2. Unboxing a null reference causes NullPointerException
        Integer empty = null;
        try {
            int val = empty;
            System.out.println(val);
        } catch (NullPointerException ex) {
            System.out.println("Unboxing null threw NullPointerException");
        }

        // 3. List<Integer>: remove(int index) vs remove(Object element)
        List<Integer> items = new ArrayList<>();
        items.add(10);
        items.add(20);
        items.add(30);
        items.remove(1);                            // removes element at index 1 (value 20)
        items.remove(Integer.valueOf(30));          // removes object with value 30
        System.out.println("Remaining items: " + items);
    }
}
