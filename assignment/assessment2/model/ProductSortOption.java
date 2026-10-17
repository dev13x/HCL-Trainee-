package assignment.assessment2.model;

import java.util.Comparator;

/*
 * Assessment 2 - Sorting strategies available for products in the cart.
 */
public enum ProductSortOption {

    NAME("Name (A-Z)",
            Comparator.<Product>naturalOrder()),

    PRICE_LOW_TO_HIGH("Price (low to high)",
            Comparator.comparing(Product::getPrice).thenComparing(Comparator.<Product>naturalOrder())),

    PRICE_HIGH_TO_LOW("Price (high to low)",
            Comparator.comparing(Product::getPrice).reversed().thenComparing(Comparator.<Product>naturalOrder())),

    CATEGORY("Category, then name",
            Comparator.comparing(Product::getCategory).thenComparing(Comparator.<Product>naturalOrder()));

    private final String label;
    private final Comparator<Product> comparator;

    ProductSortOption(String label, Comparator<Product> comparator) {
        this.label = label;
        this.comparator = comparator;
    }

    public String getLabel() {
        return label;
    }

    public Comparator<Product> getComparator() {
        return comparator;
    }
}
