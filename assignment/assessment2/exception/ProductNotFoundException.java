package assignment.assessment2.exception;

/*
 * Assessment 2 - Exception thrown when a specified product ID is not found in the cart.
 */
public class ProductNotFoundException extends CartException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
