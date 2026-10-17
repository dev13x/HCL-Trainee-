package assignment.assessment1.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Assessment 1 - Base class representing an Employee.
 * Each specific role defines its own bonus percentage.
 * Bonus = (basic + HRA) * bonusPercentage / 100, rounded to 2 decimal places.
 */
public abstract class Employee {

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final int DECIMAL_SCALE = 2;

    private final int id;
    private final String name;
    private final SalaryStructure salary;

    protected Employee(int id, String name, SalaryStructure salary) {
        if (id <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive, but was " + id);
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name must not be blank.");
        }
        if (salary == null) {
            throw new IllegalArgumentException("Salary structure must not be null.");
        }
        this.id = id;
        this.name = name.trim();
        this.salary = salary;
    }

    // Role-specific bonus percentage (e.g., 12 for 12%)
    protected abstract BigDecimal getBonusPercentage();

    public BigDecimal calculateBonus() {
        return salary.getBonusBase()
                .multiply(getBonusPercentage())
                .divide(HUNDRED, DECIMAL_SCALE, RoundingMode.HALF_UP);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SalaryStructure getSalary() {
        return salary;
    }
}
