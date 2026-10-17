package assignment.assessment2.model;

import assignment.assessment2.exception.CartFullException;
import assignment.assessment2.exception.DuplicateProductException;
import assignment.assessment2.exception.InvalidInputException;
import assignment.assessment2.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Assessment 2 - Thread-safe Cart model managing products for an individual user.
 */
public class Cart {

    public static final int MAX_PRODUCTS = 20;

    private final String ownerName;
    private final Map<String, Product> productsById = new HashMap<>();

    public Cart(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public synchronized void addProduct(Product product) {
        if (product == null) {
            throw new InvalidInputException("Cannot add a null product.");
        }
        if (productsById.containsKey(product.getId())) {
            throw new DuplicateProductException("Product '" + product.getId()
                    + "' already exists in cart. Use 'Update product' to change details.");
        }
        if (productsById.size() >= MAX_PRODUCTS) {
            throw new CartFullException("Cart capacity reached: max " + MAX_PRODUCTS + " distinct products.");
        }
        productsById.put(product.getId(), product);
    }

    public synchronized Product removeProduct(String productId) {
        Product removed = productsById.remove(Product.normalizeId(productId));
        if (removed == null) {
            throw notFound(productId);
        }
        return removed;
    }

    public synchronized Product updateProduct(String productId, String newName, BigDecimal newPrice, Integer newQuantity) {
        Product current = getProduct(productId);
        Product updated = current.withChanges(newName, newPrice, newQuantity);
        productsById.put(updated.getId(), updated);
        return updated;
    }

    public synchronized Product getProduct(String productId) {
        Product product = productsById.get(Product.normalizeId(productId));
        if (product == null) {
            throw notFound(productId);
        }
        return product;
    }

    public synchronized List<Product> getProducts(ProductSortOption sortOption) {
        Objects.requireNonNull(sortOption, "Sort option must not be null.");
        List<Product> products = new ArrayList<>(productsById.values());
        products.sort(sortOption.getComparator());
        return products;
    }

    public synchronized int getProductCount() {
        return productsById.size();
    }

    public synchronized boolean isEmpty() {
        return productsById.isEmpty();
    }

    public synchronized BigDecimal getTotalAmount() {
        return calculateTotal(productsById.values());
    }

    public static BigDecimal calculateTotal(Collection<Product> products) {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getTotalPrice());
        }
        return total;
    }

    private static ProductNotFoundException notFound(String productId) {
        String clean = (productId == null) ? "" : productId.trim();
        return new ProductNotFoundException("Product '" + clean + "' was not found in the cart.");
    }
}
