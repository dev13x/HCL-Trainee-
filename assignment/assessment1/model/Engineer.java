package assignment.assessment1.model;

import java.math.BigDecimal;

/*
 * Assessment 1 - Engineer role: festival bonus is 12% of (basic + HRA).
 */
public class Engineer extends Employee {

    private static final BigDecimal BONUS_PERCENT = BigDecimal.valueOf(12);

    public Engineer(int id, String name, SalaryStructure salary) {
        super(id, name, salary);
    }

    @Override
    protected BigDecimal getBonusPercentage() {
        return BONUS_PERCENT;
    }
}
