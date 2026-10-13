package day05.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 05 - Using generic classes (Box<T> and Pair<K, V>) for compile-time type safety
 */
public class GenericClassExample {

    public static void main(String[] args) {
        Box<Integer> codeBox = new Box<>(101);          // T = Integer
        Box<String> titleBox = new Box<>("Core Java");  // T = String

        int code = codeBox.getValue();                  // no explicit cast required
        String title = titleBox.getValue();
        System.out.println(codeBox + " | " + titleBox);
        System.out.println("Next code : " + (code + 1));
        System.out.println("Upper     : " + title.toUpperCase());

        // Generic class with two type parameters
        Pair<String, Integer> scorePair = new Pair<>("Neha", 82);
        Pair<Integer, String> idPair = new Pair<>(1, "Arjun");
        System.out.println("Pairs     : " + scorePair + ", " + idPair);
        System.out.println(scorePair.getKey() + " -> " + scorePair.getValue());

        // Standard collections use generics too
        List<String> branches = new ArrayList<>();
        branches.add("CSE");
        branches.add("ECE");
        System.out.println("First branch: " + branches.get(0));

        showRawTypeProblem();
    }

    // Without generics, raw collections store Object and fail at runtime with ClassCastException
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void showRawTypeProblem() {
        List rawList = new ArrayList();
        rawList.add("Neha");
        rawList.add(42);                                // allowed at compile time in a raw list
        try {
            String secondItem = (String) rawList.get(1);
            System.out.println(secondItem);
        } catch (ClassCastException ex) {
            System.out.println("Raw list failed at runtime: ClassCastException");
        }
    }
}
