package day05.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Day 05 - Built-in functional interfaces in java.util.function:
 * Predicate<T>, Function<T, R>, Consumer<T>, Supplier<T>, and BiFunction<T, U, R>
 */
public class BuiltInFunctionalInterfacesExample {

    public static void main(String[] args) {
        // Predicate<T>: T -> boolean (test)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThanTen = n -> n > 10;
        System.out.println("isEven(14)                : " + isEven.test(14));
        System.out.println("isEven(9)                 : " + isEven.test(9));
        System.out.println("even AND > 10 (for 14)    : " + isEven.and(isGreaterThanTen).test(14));
        System.out.println("not even (for 9)          : " + isEven.negate().test(9));

        // Function<T, R>: T -> R (apply)
        Function<String, Integer> wordLength = word -> word.length();
        Function<Integer, Integer> doubleValue = n -> n * 2;
        System.out.println("wordLength('Training')    : " + wordLength.apply("Training"));
        System.out.println("length then double        : " + wordLength.andThen(doubleValue).apply("Training"));

        // Consumer<T>: T -> void (accept)
        Consumer<String> notifyUser = user -> System.out.println("Welcome, " + user + "!");
        notifyUser.accept("Neha");

        // Supplier<T>: () -> T (get)
        Supplier<String> defaultModule = () -> "Module 1 - Core Java";
        System.out.println("Supplier output           : " + defaultModule.get());

        // BiFunction<T, U, R>: (T, U) -> R (apply)
        BiFunction<String, Integer, String> formatScore = (name, score) -> name + " scored " + score;
        System.out.println("BiFunction output         : " + formatScore.apply("Arjun", 88));
    }
}
