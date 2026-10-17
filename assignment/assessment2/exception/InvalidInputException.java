package assignment.assessment2.exception;

/*
 * Assessment 2 - Exception thrown when user input fails validation constraints.
 */
public class InvalidInputException extends CartException {

    private static final long serialVersionUID = 1L;

    public InvalidInputException(String message) {
        super(message);
    }
}
