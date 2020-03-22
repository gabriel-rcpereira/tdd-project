package com.grcp.tdd.laborcalculator.usecase;

import com.grcp.tdd.laborcalculator.core.domain.Employee;
import com.grcp.tdd.laborcalculator.usecase.calculator.CalculatorFlyweight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CalculateSalary {

    private final CalculatorFlyweight calculatorFlyweight;

    public double execute(Employee employee) {
        return calculatorFlyweight
                .getEmployeeCommand(employee.getPosition())
                .calculate(employee);
    }
}
