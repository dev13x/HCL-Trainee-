package assignment.assessment2.model;

import assignment.assessment2.exception.InvalidInputException;

import java.math.BigDecimal;

/*
 * Assessment 2 - Electronic product with warranty duration in months (0-60).
 */
public class ElectronicProduct extends Product {

    public static final int MAX_WARRANTY_MONTHS = 60;

    private final int warrantyMonths;

    public ElectronicProduct(String id, String name, BigDecimal price, int quantity, int warrantyMonths) {
        super(id, name, price, quantity);
        this.warrantyMonths = validateWarranty(warrantyMonths);
    }

    @Override
    public ProductCategory getCategory() {
        return ProductCategory.ELECTRONIC;
    }

    @Override
    public String getSpecificDetails() {
        if (warrantyMonths == 0) {
            return "No warranty";
        }
        return "Warranty: " + warrantyMonths + (warrantyMonths == 1 ? " month" : " months");
    }

    @Override
    public Product withChanges(String newName, BigDecimal newPrice, Integer newQuantity) {
        return new ElectronicProduct(
                getId(),
                valueOrCurrent(newName, getName()),
                valueOrCurrent(newPrice, getPrice()),
                valueOrCurrent(newQuantity, getQuantity()),
                warrantyMonths);
    }

    private static int validateWarranty(int months) {
        if (months < 0 || months > MAX_WARRANTY_MONTHS) {
            throw new InvalidInputException("Warranty must be between 0 and " + MAX_WARRANTY_MONTHS + " months.");
        }
        return months;
    }
}
