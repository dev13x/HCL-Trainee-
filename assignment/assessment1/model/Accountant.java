package assignment.assessment1.model;

import java.math.BigDecimal;

/*
 * Assessment 1 - Accountant role: festival bonus is 8% of (basic + HRA).
 */
public class Accountant extends Employee {

    private static final BigDecimal BONUS_PERCENT = BigDecimal.valueOf(8);

    public Accountant(int id, String name, SalaryStructure salary) {
        super(id, name, salary);
    }

    @Override
    protected BigDecimal getBonusPercentage() {
        return BONUS_PERCENT;
    }
}
