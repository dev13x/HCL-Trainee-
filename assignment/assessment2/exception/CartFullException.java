package assignment.assessment2.exception;

/*
 * Assessment 2 - Exception thrown when a user's cart exceeds the maximum product capacity.
 */
public class CartFullException extends CartException {

    private static final long serialVersionUID = 1L;

    public CartFullException(String message) {
        super(message);
    }
}
