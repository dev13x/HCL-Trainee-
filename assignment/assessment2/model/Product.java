package assignment.assessment2.model;

import assignment.assessment2.exception.InvalidInputException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.regex.Pattern;

/*
 * Assessment 2 - Abstract immutable Product base class implementing Comparable<Product>.
 * Natural ordering sorts alphabetically by name, breaking ties with product ID.
 */
public abstract class Product implements Comparable<Product> {

    public static final int MAX_ID_LENGTH = 10;
    public static final int MAX_NAME_LENGTH = 25;
    public static final int MAX_QUANTITY = 100;
    public static final BigDecimal MAX_PRICE = new BigDecimal("1000000");

    private static final int PRICE_DECIMAL_PLACES = 2;
    private static final Pattern VALID_ID = Pattern.compile("[A-Z0-9-]+");

    private final String id;
    private final String name;
    private final BigDecimal price;
    private final int quantity;

    protected Product(String id, String name, BigDecimal price, int quantity) {
        this.id = validateId(id);
        this.name = validateName(name);
        this.price = validatePrice(price);
        this.quantity = validateQuantity(quantity);
    }

    public abstract ProductCategory getCategory();

    public abstract String getSpecificDetails();

    public abstract Product withChanges(String newName, BigDecimal newPrice, Integer newQuantity);

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public static String normalizeId(String id) {
        if (id == null) {
            return "";
        }
        return id.trim().toUpperCase(Locale.ROOT);
    }

    @Override
    public int compareTo(Product other) {
        int byName = name.compareToIgnoreCase(other.name);
        if (byName != 0) {
            return byName;
        }
        return id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " x" + quantity;
    }

    protected static <T> T valueOrCurrent(T newValue, T currentValue) {
        return (newValue != null) ? newValue : currentValue;
    }

    private static String validateId(String id) {
        String cleanId = normalizeId(id);
        if (cleanId.isEmpty()) {
            throw new InvalidInputException("Product ID must not be empty.");
        }
        if (cleanId.length() > MAX_ID_LENGTH) {
            throw new InvalidInputException("Product ID must not exceed " + MAX_ID_LENGTH + " characters.");
        }
        if (!VALID_ID.matcher(cleanId).matches()) {
            throw new InvalidInputException("Product ID may only contain uppercase letters, digits, and hyphens.");
        }
        return cleanId;
    }

    private static String validateName(String name) {
        String cleanName = (name == null) ? "" : name.trim();
        if (cleanName.isEmpty()) {
            throw new InvalidInputException("Product name must not be blank.");
        }
        if (cleanName.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException("Product name must not exceed " + MAX_NAME_LENGTH + " characters.");
        }
        return cleanName;
    }

    private static BigDecimal validatePrice(BigDecimal price) {
        if (price == null) {
            throw new InvalidInputException("Product price must be specified.");
        }
        if (price.signum() <= 0) {
            throw new InvalidInputException("Product price must be greater than zero.");
        }
        if (price.compareTo(MAX_PRICE) > 0) {
            throw new InvalidInputException("Product price cannot exceed " + MAX_PRICE.toPlainString() + ".");
        }
        if (price.stripTrailingZeros().scale() > PRICE_DECIMAL_PLACES) {
            throw new InvalidInputException("Product price can have at most " + PRICE_DECIMAL_PLACES + " decimal places.");
        }
        return price.setScale(PRICE_DECIMAL_PLACES, RoundingMode.UNNECESSARY);
    }

    private static int validateQuantity(int quantity) {
        if (quantity < 1 || quantity > MAX_QUANTITY) {
            throw new InvalidInputException("Quantity must be between 1 and " + MAX_QUANTITY + ".");
        }
        return quantity;
    }
}
