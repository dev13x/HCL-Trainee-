package day04.sorting;

/*
 * Day 04 - Comparable and toString()
 * Implementing Comparable<Student> defines the natural order used by Collections.sort():
 * younger students first, and when the ages are equal, the lower marks first.
 */
public class Student implements Comparable<Student> {

    private final int rollNumber;
    private final String name;
    private final int age;
    private final int marks;

    public Student(int rollNumber, String name, int age, int marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        int byAge = Integer.compare(this.age, other.age);
        if (byAge != 0) {
            return byAge;                                   // different ages: decided by age
        }
        return Integer.compare(this.marks, other.marks);    // same age: decided by marks
    }

    // readable output instead of the default Student@1b6d3586
    @Override
    public String toString() {
        return "Roll " + rollNumber + " | " + name + " | age " + age + " | marks " + marks;
    }
}
