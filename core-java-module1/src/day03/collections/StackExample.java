package day03.collections;

import java.util.Stack;

/*
 * Day 03 - Collections: the Stack class (last in, first out)
 * search() gives the 1-based distance from the top, or -1 when the element is absent.
 */
public class StackExample {

    public static void main(String[] args) {
        Stack<String> books = new Stack<>();
        books.push("Java");
        books.push("DSA");
        books.push("DBMS");
        System.out.println("Stack: " + books);

        System.out.println("peek: " + books.peek());                    // DBMS
        System.out.println("pop: " + books.pop());                      // DBMS
        System.out.println("search(\"Java\"): " + books.search("Java"));   // 2
        System.out.println("search(\"OS\"): " + books.search("OS"));       // -1
        System.out.println("empty? " + books.empty());                  // false
    }
}
