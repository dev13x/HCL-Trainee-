package day05.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Day 05 - Writing Comparators with lambda expressions and Comparator helper methods
 */
public class ComparatorLambdaExample {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Neha", 21, 82));
        list.add(new Student(2, "Arjun", 19, 74));
        list.add(new Student(3, "Sara", 21, 67));
        list.add(new Student(4, "Dev", 20, 90));
        list.add(new Student(5, "Isha", 19, 58));

        // 1. Lambda expression directly implementing compare(s1, s2)
        Collections.sort(list, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printList("Lambda - sorted by name (A-Z):", list);

        // 2. Comparator.comparing() with method reference + reversed() for Z-A
        list.sort(Comparator.comparing(Student::getName).reversed());
        printList("Comparator.comparing().reversed() - name (Z-A):", list);

        // 3. Comparator.comparingInt() avoids boxing int primitives
        list.sort(Comparator.comparingInt(Student::getMarks));
        printList("Comparator.comparingInt() - marks (low to high):", list);

        // 4. Chaining with thenComparing() for tie-breaking
        list.sort(Comparator.comparingInt(Student::getAge).thenComparing(Student::getName));
        printList("thenComparing() - age, then name:", list);
    }

    private static void printList(String heading, List<Student> list) {
        System.out.println(heading);
        for (Student s : list) {
            System.out.println("  " + s);
        }
        System.out.println();
    }
}
