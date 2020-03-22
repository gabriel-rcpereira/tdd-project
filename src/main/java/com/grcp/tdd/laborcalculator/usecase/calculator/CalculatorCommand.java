package com.grcp.tdd.laborcalculator.usecase.calculator;

import com.grcp.tdd.laborcalculator.core.domain.Employee;

public interface CalculatorCommand {

    double calculate(Employee employee);
}
