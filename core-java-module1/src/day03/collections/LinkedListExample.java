package day03.collections;

import java.util.LinkedList;

/*
 * Day 03 - Collections: LinkedList
 * Find an element with indexOf() and insert a new one right after it with add(index, element).
 */
public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Kolkata");
        System.out.println("Original     : " + cities);

        int position = cities.indexOf("Mumbai");
        cities.add(position + 1, "Pune");           // insert right after Mumbai
        System.out.println("After add    : " + cities);

        cities.remove("Kolkata");                   // remove by value
        System.out.println("After remove : " + cities);
    }
}
