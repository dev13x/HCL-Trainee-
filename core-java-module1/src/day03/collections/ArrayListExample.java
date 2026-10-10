package day03.collections;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 03 - Collections: ArrayList
 * add, get, set, remove (by index and by value), contains and size.
 */
public class ArrayListExample {

    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        marks.add(56);
        marks.add(72);
        marks.add(88);
        marks.add(91);
        marks.add(45);
        System.out.println("Marks: " + marks);

        marks.set(0, 60);                           // replace the value at index 0
        System.out.println("marks.get(0) = " + marks.get(0));

        marks.remove(4);                            // remove(int): by INDEX
        marks.remove(Integer.valueOf(72));          // remove(Object): by VALUE
        System.out.println("After removing: " + marks);

        System.out.println("contains(88)? " + marks.contains(88));
        System.out.println("size = " + marks.size());
    }
}
