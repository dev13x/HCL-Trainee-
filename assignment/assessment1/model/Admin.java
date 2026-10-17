package assignment.assessment1.model;

import java.math.BigDecimal;

/*
 * Assessment 1 - Admin role: festival bonus is 10% of (basic + HRA).
 */
public class Admin extends Employee {

    private static final BigDecimal BONUS_PERCENT = BigDecimal.valueOf(10);

    public Admin(int id, String name, SalaryStructure salary) {
        super(id, name, salary);
    }

    @Override
    protected BigDecimal getBonusPercentage() {
        return BONUS_PERCENT;
    }
}
