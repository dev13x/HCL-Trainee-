package day05.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Day 05 - Comparable vs Comparator
 * 1. Natural order via Comparable (Student.compareTo)
 * 2. Custom order via a separate Comparator class (NameComparator)
 * 3. Custom order via an anonymous Comparator class (marks descending)
 */
public class ComparatorExample {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Neha", 21, 82));
        list.add(new Student(2, "Arjun", 19, 74));
        list.add(new Student(3, "Sara", 21, 67));
        list.add(new Student(4, "Dev", 20, 90));
        list.add(new Student(5, "Isha", 19, 58));

        // 1. Natural order (Comparable): age ascending, then marks ascending
        Collections.sort(list);
        printList("1. Comparable (age, then marks):", list);

        // 2. Separate Comparator class: alphabetical by name
        Collections.sort(list, new NameComparator());
        printList("2. NameComparator (name A-Z):", list);

        // 3. Anonymous Comparator: highest marks first (descending)
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMarks(), s1.getMarks());
            }
        });
        printList("3. Anonymous Comparator (marks high to low):", list);
    }

    private static void printList(String heading, List<Student> list) {
        System.out.println(heading);
        for (Student s : list) {
            System.out.println("  " + s);
        }
        System.out.println();
    }
}
