package com.grcp.tdd.laborcalculator.usecase.calculator;

import com.grcp.tdd.laborcalculator.usecase.calculator.command.DbaCalculatorCommand;
import com.grcp.tdd.laborcalculator.usecase.calculator.command.DeveloperCalculatorCommand;
import com.grcp.tdd.laborcalculator.usecase.calculator.command.ManagerCalculatorCommand;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.grcp.tdd.laborcalculator.core.domain.Employee.Position;

@Component
public class CalculatorFlyweight {

    private final Map<Position, CalculatorCommand> calculatorCommands;

    public CalculatorFlyweight(DeveloperCalculatorCommand developerCalculatorCommand,
                               DbaCalculatorCommand dbaCalculatorCommand,
                               ManagerCalculatorCommand managerCalculatorCommand) {
        this.calculatorCommands = new HashMap<>(){{
            put(Position.DEVELOPER, developerCalculatorCommand);
            put(Position.DBA, dbaCalculatorCommand);
            put(Position.MANAGER, managerCalculatorCommand);
        }};
    }

    public CalculatorCommand getEmployeeCommand(Position position) {
        return calculatorCommands.get(position);
    }
}
