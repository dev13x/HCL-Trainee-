package day05.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/*
 * Day 05 - Combined practice exercise covering Comparator, Generics, Predicate, Wrappers, and Lambdas:
 *   1. Sort products by price ascending using a lambda Comparator
 *   2. Sort products by quantity descending, then by name ascending
 *   3. Filter products costing above 1000 using a generic method + Predicate
 *   4. Sum product prices in a List<Double> demonstrating autoboxing/unboxing
 *   5. Print product names in uppercase using forEach + lambda
 */
public class PracticeExample {

    private static <T> List<T> filterList(List<T> source, Predicate<T> rule) {
        List<T> matched = new ArrayList<>();
        for (T element : source) {
            if (rule.test(element)) {
                matched.add(element);
            }
        }
        return matched;
    }

    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(1, "Laptop", 52000.0, 8));
        catalog.add(new Product(2, "Mouse", 550.0, 35));
        catalog.add(new Product(3, "Keyboard", 1450.0, 20));
        catalog.add(new Product(4, "Monitor", 13500.0, 12));
        catalog.add(new Product(5, "USB Drive", 400.0, 35));

        // 1. Sort by price (lowest first)
        catalog.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        display("1. Sorted by price (low to high):", catalog);

        // 2. Sort by quantity (highest first), then by name (A-Z)
        catalog.sort(Comparator.comparingInt(Product::getQuantity).reversed().thenComparing(Product::getName));
        display("2. Sorted by quantity (high to low), then name:", catalog);

        // 3. Filter products with price > 1000
        List<Product> premium = filterList(catalog, p -> p.getPrice() > 1000);
        display("3. Products priced above 1000:", premium);

        // 4. Autoboxing and unboxing with List<Double>
        List<Double> priceList = new ArrayList<>();
        for (Product p : catalog) {
            priceList.add(p.getPrice());            // autoboxing: double -> Double
        }
        double totalCost = 0;
        for (double amount : priceList) {           // unboxing: Double -> double
            totalCost += amount;
        }
        System.out.println("4. Total price of catalog: Rs." + totalCost);
        System.out.println();

        // 5. Print uppercase names with forEach
        System.out.println("5. Product names in uppercase:");
        catalog.forEach(p -> System.out.println("  " + p.getName().toUpperCase()));
    }

    private static void display(String title, List<Product> items) {
        System.out.println(title);
        for (Product p : items) {
            System.out.println("  " + p);
        }
        System.out.println();
    }
}
