package assignment.assessment1.service;

import assignment.assessment1.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Assessment 1 - BonusService: sorts employees by calculated bonus descending.
 * If bonus amounts are tied, lower employee ID comes first.
 */
public class BonusService {

    private static final Comparator<Employee> BY_BONUS_DESCENDING =
            Comparator.comparing(Employee::calculateBonus).reversed()
                    .thenComparingInt(Employee::getId);

    public List<Employee> sortByBonusDescending(List<? extends Employee> employees) {
        List<Employee> sortedList = new ArrayList<>(employees);
        sortedList.sort(BY_BONUS_DESCENDING);
        return sortedList;
    }
}
