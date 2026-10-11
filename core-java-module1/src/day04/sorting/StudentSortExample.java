package day04.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Day 04 - Sorting Student objects: by age first, then by marks for equal ages
 */
public class StudentSortExample {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Neha", 21, 82));
        list.add(new Student(2, "Arjun", 19, 74));
        list.add(new Student(3, "Sara", 21, 67));
        list.add(new Student(4, "Dev", 20, 90));
        list.add(new Student(5, "Isha", 19, 58));

        System.out.println("Unsorted:");
        for (Student s : list) {
            System.out.println(s);
        }

        Collections.sort(list);     // uses Student.compareTo()

        System.out.println();
        System.out.println("Sorted by age, then marks:");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
