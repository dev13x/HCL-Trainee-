package day05.practice;

/*
 * Day 05 - Product model used in PracticeExample
 */
public class Product {

    private final int id;
    private final String name;
    private final double price;
    private final int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "#" + id + " | " + name + " | Rs." + price + " | qty " + quantity;
    }
}
