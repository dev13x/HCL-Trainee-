package assignment.assessment1.report;

import assignment.assessment1.model.Employee;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/*
 * Assessment 1 - Formatted console report printer for employee festival bonuses.
 */
public class BonusReportPrinter {

    private static final String BORDER = "---------------------------------------------";
    private static final String CURRENCY_LABEL = "Rs. ";
    private static final int DECIMAL_PLACES = 2;

    private final PrintStream out;

    public BonusReportPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(List<? extends Employee> employees) {
        for (Employee emp : employees) {
            out.println(BORDER);
            out.println("Emp_id: " + emp.getId());
            out.println("Name: " + emp.getName());
            out.println("Bonus: " + CURRENCY_LABEL + formatAmount(emp.calculateBonus()));
        }
    }

    private static String formatAmount(BigDecimal amount) {
        boolean isWholeNumber = amount.stripTrailingZeros().scale() <= 0;
        if (isWholeNumber) {
            return amount.setScale(0, RoundingMode.UNNECESSARY).toPlainString();
        }
        return amount.setScale(DECIMAL_PLACES, RoundingMode.HALF_UP).toPlainString();
    }
}
