package com.grcp.tdd.laborcalculator.usecase.calculator.command;

import com.grcp.tdd.laborcalculator.core.domain.Employee;
import com.grcp.tdd.laborcalculator.usecase.calculator.CalculatorCommand;
import org.springframework.stereotype.Component;

@Component
public class ManagerCalculatorCommand implements CalculatorCommand {

    private final double SALARY_LIMIT_TO_DISCOUNT_FOR_MANAGER = 5000.0;
    private final double MANAGER_DISCOUNT_TO_ABOVE_LABEL = 0.84;
    private final double MANAGER_DISCOUNT_TO_BELOW_LABEL = 0.85;

    @Override
    public double calculate(Employee employee) {
        if (employee.getSalary() > SALARY_LIMIT_TO_DISCOUNT_FOR_MANAGER) {
            return employee.getSalary() * MANAGER_DISCOUNT_TO_ABOVE_LABEL;
        }
        return employee.getSalary() * MANAGER_DISCOUNT_TO_BELOW_LABEL;
    }
}
