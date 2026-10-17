package assignment.assessment2.service;

import assignment.assessment2.exception.InvalidInputException;
import assignment.assessment2.model.ClothesProduct;
import assignment.assessment2.model.ElectronicProduct;
import assignment.assessment2.model.Product;
import assignment.assessment2.model.ProductCategory;
import assignment.assessment2.model.ToysProduct;

import java.math.BigDecimal;

/*
 * Assessment 2 - ProductFactory creating concrete category instances.
 */
public final class ProductFactory {

    private ProductFactory() {
    }

    public static Product create(ProductCategory category, String id, String name, BigDecimal price,
                                 int quantity, String extraDetail) {
        if (category == null) {
            throw new InvalidInputException("Product category must not be null.");
        }
        switch (category) {
            case CLOTHES:
                return new ClothesProduct(id, name, price, quantity, extraDetail);
            case ELECTRONIC:
                return new ElectronicProduct(id, name, price, quantity, parseWholeNumber(extraDetail, "Warranty"));
            case TOYS:
                return new ToysProduct(id, name, price, quantity, parseWholeNumber(extraDetail, "Minimum age"));
            default:
                throw new InvalidInputException("Unknown product category: " + category);
        }
    }

    private static int parseWholeNumber(String text, String fieldName) {
        if (text == null) {
            throw new InvalidInputException(fieldName + " must be specified as an integer.");
        }
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(fieldName + " must be a valid whole number, received: '" + text.trim() + "'.");
        }
    }
}
