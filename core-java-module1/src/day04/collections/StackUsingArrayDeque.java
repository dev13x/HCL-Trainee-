package day04.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Day 04 - A stack (last in, first out) built on ArrayDeque
 * push() and pop() work at the head of the deque.
 */
public class StackUsingArrayDeque {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack (top first): " + stack);

        System.out.println("peek: " + stack.peek());        // 30
        System.out.println("pop: " + stack.pop());          // 30
        System.out.println("size: " + stack.size());        // 2
        System.out.println("empty? " + stack.isEmpty());    // false

        // a stack hands items back in reverse order, so it can reverse a word
        String word = "java";
        Deque<Character> letters = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            letters.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!letters.isEmpty()) {
            reversed.append(letters.pop());
        }
        System.out.println(word + " reversed = " + reversed);
    }
}
