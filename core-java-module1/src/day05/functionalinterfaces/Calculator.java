package day05.functionalinterfaces;

/*
 * Day 05 - Custom functional interface
 * Has exactly one abstract method (compute), so it can be implemented with a lambda expression.
 * Default and static methods have bodies, so they do not count toward the single abstract method limit.
 */
@FunctionalInterface
public interface Calculator {

    int compute(int x, int y);

    default void printResult(int x, int y) {
        System.out.println("Output for (" + x + ", " + y + ") = " + compute(x, y));
    }
}
