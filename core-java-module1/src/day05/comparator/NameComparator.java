package day05.comparator;

import java.util.Comparator;

/*
 * Day 05 - Separate Comparator class
 * Orders Student objects alphabetically by name without modifying the Student class.
 */
public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
