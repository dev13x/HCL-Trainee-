package assignment.assessment2.exception;

/*
 * Assessment 2 - Exception thrown when attempting to add a product ID already in the cart.
 */
public class DuplicateProductException extends CartException {

    private static final long serialVersionUID = 1L;

    public DuplicateProductException(String message) {
        super(message);
    }
}
