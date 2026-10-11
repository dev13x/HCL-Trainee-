package day04.collections;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Day 04 - Queue (first in, first out) backed by ArrayDeque
 * add() joins the line at the tail; remove()/poll() serve the customer at the head.
 */
public class QueueExample {

    public static void main(String[] args) {
        Queue<String> counter = new ArrayDeque<>();
        counter.add("Neha");
        counter.add("Arjun");
        counter.add("Sara");
        System.out.println("Waiting: " + counter);

        System.out.println("Next customer: " + counter.peek());        // look at the head, keep it
        System.out.println("Serving: " + counter.remove());            // remove the head
        System.out.println("Still waiting: " + counter);

        counter.poll();
        counter.poll();
        // empty queue: poll() returns null, remove() would throw NoSuchElementException
        System.out.println("poll() on an empty queue: " + counter.poll());
    }
}
