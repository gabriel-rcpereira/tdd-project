package com.grcp.tdd.laborcalculator.usecase.calculator.command;

import com.grcp.tdd.laborcalculator.core.domain.Employee;
import com.grcp.tdd.laborcalculator.usecase.calculator.CalculatorCommand;
import org.springframework.stereotype.Component;

@Component
public class DbaCalculatorCommand implements CalculatorCommand {

    private final double SALARY_LIMIT_TO_DISCOUNT_FOR_DBA = 3000.0;
    private final double DBA_DISCOUNT_TO_ABOVE_LABEL = 0.9;
    private final double DBA_DISCOUNT_TO_BELOW_LABEL = 0.91;

    @Override
    public double calculate(Employee employee) {
        if (employee.getSalary() > SALARY_LIMIT_TO_DISCOUNT_FOR_DBA) {
            return employee.getSalary() * DBA_DISCOUNT_TO_ABOVE_LABEL;
        }
        return employee.getSalary() * DBA_DISCOUNT_TO_BELOW_LABEL;
    }
}
