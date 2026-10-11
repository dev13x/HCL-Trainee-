package day04.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Day 04 - Deque (double-ended queue): insert and remove at both ends
 */
public class DequeExample {

    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        history.addFirst("home");
        history.addLast("profile");
        history.addFirst("login");
        history.addLast("settings");
        System.out.println("History: " + history);

        System.out.println("first = " + history.peekFirst() + ", last = " + history.peekLast());

        history.removeFirst();
        history.removeLast();
        System.out.println("After removing both ends: " + history);
    }
}
