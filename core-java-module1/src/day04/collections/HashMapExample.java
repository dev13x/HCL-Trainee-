package day04.collections;

import java.util.HashMap;
import java.util.Map;

/*
 * Day 04 - HashMap: key-value pairs with unique keys and no guaranteed order
 */
public class HashMapExample {

    public static void main(String[] args) {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("pen", 10);
        prices.put("notebook", 45);
        prices.put("bag", 600);
        prices.put("pen", 12);                  // same key: the old value is replaced
        System.out.println("Prices: " + prices);

        System.out.println("price of bag: " + prices.get("bag"));
        System.out.println("has 'eraser'? " + prices.containsKey("eraser"));
        System.out.println("eraser or default: " + prices.getOrDefault("eraser", -1));

        prices.remove("notebook");
        for (Map.Entry<String, Integer> entry : prices.entrySet()) {
            System.out.println(entry.getKey() + " costs " + entry.getValue());
        }
    }
}
