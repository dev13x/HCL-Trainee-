package day05.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Day 05 - Comparable: how compareTo() works and how Collections.sort(list) uses natural ordering
 */
public class ComparableExample {

    public static void main(String[] args) {
        Student neha = new Student(1, "Neha", 21, 82);
        Student arjun = new Student(2, "Arjun", 19, 74);
        Student sara = new Student(3, "Sara", 21, 67);

        // Direct compareTo() calls: negative = comes before, 0 = equal, positive = comes after
        System.out.println("arjun.compareTo(neha) : " + arjun.compareTo(neha));     // negative (19 < 21)
        System.out.println("neha.compareTo(arjun) : " + neha.compareTo(arjun));     // positive (21 > 19)
        System.out.println("neha.compareTo(neha)  : " + neha.compareTo(neha));      // 0 (same age & marks)
        System.out.println("sara.compareTo(neha)  : " + sara.compareTo(neha));      // negative (same age, 67 < 82)
        System.out.println();

        List<Student> list = new ArrayList<>();
        list.add(neha);
        list.add(arjun);
        list.add(sara);

        Collections.sort(list);     // uses Student.compareTo()
        System.out.println("Sorted by natural order (age, then marks):");
        for (Student s : list) {
            System.out.println("  " + s);
        }
        System.out.println();

        // Built-in classes like String and Integer already implement Comparable
        List<String> cities = new ArrayList<>(Arrays.asList("Pune", "Delhi", "Bengaluru"));
        Collections.sort(cities);
        System.out.println("Sorted strings : " + cities);

        List<Integer> scores = new ArrayList<>(Arrays.asList(82, 67, 90, 74));
        Collections.sort(scores);
        System.out.println("Sorted numbers : " + scores);
    }
}
