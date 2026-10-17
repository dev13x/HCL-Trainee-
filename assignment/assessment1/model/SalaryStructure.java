package assignment.assessment1.model;

import java.math.BigDecimal;

/*
 * Assessment 1 - Salary structure for an employee:
 * basic, HRA, travel allowance, and special allowance.
 * Festival bonus is calculated strictly on the base of (basic + HRA).
 */
public class SalaryStructure {

    private final BigDecimal basic;
    private final BigDecimal hra;
    private final BigDecimal travelAllowance;
    private final BigDecimal specialAllowance;

    public SalaryStructure(BigDecimal basic, BigDecimal hra, BigDecimal travelAllowance, BigDecimal specialAllowance) {
        this.basic = validateNonNegative(basic, "Basic salary");
        this.hra = validateNonNegative(hra, "HRA");
        this.travelAllowance = validateNonNegative(travelAllowance, "Travel allowance");
        this.specialAllowance = validateNonNegative(specialAllowance, "Special allowance");
    }

    public BigDecimal getBonusBase() {
        return basic.add(hra);
    }

    public BigDecimal getTotalSalary() {
        return basic.add(hra).add(travelAllowance).add(specialAllowance);
    }

    public BigDecimal getBasic() {
        return basic;
    }

    public BigDecimal getHra() {
        return hra;
    }

    public BigDecimal getTravelAllowance() {
        return travelAllowance;
    }

    public BigDecimal getSpecialAllowance() {
        return specialAllowance;
    }

    private static BigDecimal validateNonNegative(BigDecimal amount, String fieldName) {
        if (amount == null) {
            throw new IllegalArgumentException(fieldName + " must not be null.");
        }
        if (amount.signum() < 0) {
            throw new IllegalArgumentException(fieldName + " must not be negative.");
        }
        return amount;
    }
}
