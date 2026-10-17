package assignment.assessment2.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

/*
 * Assessment 2 - Robust console input handler with validation and retry loops.
 */
public class ConsoleInput {

    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleInput(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public String readLine(String prompt) {
        out.print(prompt);
        out.flush();
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        return readParsed(prompt, Integer::parseInt, "a whole number", false);
    }

    public Integer readOptionalInt(String prompt) {
        return readParsed(prompt, Integer::parseInt, "a whole number", true);
    }

    public BigDecimal readAmount(String prompt) {
        return readParsed(prompt, BigDecimal::new, "a valid currency amount", false);
    }

    public BigDecimal readOptionalAmount(String prompt) {
        return readParsed(prompt, BigDecimal::new, "a valid currency amount", true);
    }

    private <T> T readParsed(String prompt, Function<String, T> parser, String expectedKind, boolean allowEmpty) {
        while (true) {
            String text = readLine(prompt);
            if (text.isEmpty() && allowEmpty) {
                return null;
            }
            try {
                return parser.apply(text);
            } catch (Exception ex) {
                out.println("'" + text + "' is not " + expectedKind + ". Please try again.");
            }
        }
    }
}
