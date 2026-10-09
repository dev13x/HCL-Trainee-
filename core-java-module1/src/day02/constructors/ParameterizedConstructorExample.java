package day02.constructors;

/*
 * Day 02 - Constructor overloading
 * Several constructors with different parameter lists; the arguments decide which one runs.
 */
public class ParameterizedConstructorExample {

    static class Product {
        private final String name;
        private final double price;
        private final int quantity;

        Product(String name) {
            this.name = name;
            this.price = 0.0;
            this.quantity = 0;
        }

        Product(String name, double price) {
            this.name = name;
            this.price = price;
            this.quantity = 1;
        }

        Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        void print() {
            System.out.println(name + " | price " + price + " | qty " + quantity);
        }
    }

    public static void main(String[] args) {
        new Product("Pen").print();
        new Product("Notebook", 45.5).print();
        new Product("Marker", 20.0, 12).print();
    }
}
