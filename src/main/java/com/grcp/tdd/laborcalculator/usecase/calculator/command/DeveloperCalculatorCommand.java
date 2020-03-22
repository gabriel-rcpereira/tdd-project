package com.grcp.tdd.laborcalculator.usecase.calculator.command;

import com.grcp.tdd.laborcalculator.core.domain.Employee;
import com.grcp.tdd.laborcalculator.usecase.calculator.CalculatorCommand;
import org.springframework.stereotype.Component;

@Component
public class DeveloperCalculatorCommand implements CalculatorCommand {

    private final double SALARY_LIMIT_TO_DISCOUNT_FOR_DEVELOPER = 3000.0;
    private final double DEVELOPER_DISCOUNT_TO_ABOVE_LABEL = 0.89;
    private final double DEVELOPER_DISCOUNT_TO_BELOW_LABEL = 0.9;

    @Override
    public double calculate(Employee employee) {
        if (employee.getSalary() > SALARY_LIMIT_TO_DISCOUNT_FOR_DEVELOPER){
            return employee.getSalary() * DEVELOPER_DISCOUNT_TO_ABOVE_LABEL;
        } else {
            return employee.getSalary() * DEVELOPER_DISCOUNT_TO_BELOW_LABEL;
        }
    }
}
