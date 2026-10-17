package assignment.assessment2.exception;

/*
 * Assessment 2 - Base runtime exception for all shopping cart operations.
 */
public class CartException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CartException(String message) {
        super(message);
    }
}
