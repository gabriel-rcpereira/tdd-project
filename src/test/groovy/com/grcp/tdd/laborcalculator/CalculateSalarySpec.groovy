package com.grcp.tdd.laborcalculator

import com.grcp.tdd.laborcalculator.core.domain.Employee
import com.grcp.tdd.laborcalculator.usecase.CalculateSalary
import com.grcp.tdd.laborcalculator.usecase.calculator.CalculatorFlyweight
import com.grcp.tdd.laborcalculator.usecase.calculator.command.DbaCalculatorCommand
import com.grcp.tdd.laborcalculator.usecase.calculator.command.DeveloperCalculatorCommand
import com.grcp.tdd.laborcalculator.usecase.calculator.command.ManagerCalculatorCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static com.grcp.tdd.laborcalculator.core.domain.Employee.Position.DBA
import static com.grcp.tdd.laborcalculator.core.domain.Employee.Position.DEVELOPER
import static com.grcp.tdd.laborcalculator.core.domain.Employee.Position.MANAGER

@ContextConfiguration(classes = [CalculateSalary.class, CalculatorFlyweight.class, DeveloperCalculatorCommand.class,
        DbaCalculatorCommand.class, ManagerCalculatorCommand.class])
@SpringBootTest
class CalculateSalarySpec extends Specification {

    @Autowired
    private CalculateSalary laborCalculator;

    def "should calculate the Developer employee payment when he earns less than three thousand"(){
        expect:
        Employee employee = Employee.builder().name("Employee one").salary(employeeSalary).position(DEVELOPER).build()
        laborCalculator.execute(employee) == salaryExpected

        where:
        employeeSalary  | salaryExpected
        3000.0          | 2700.00
        2700.0          | 2430.00
        1000.0          | 900.00
    }

    def "should calculate the Developer employee payment when he earns more than three thousand"(){
        expect:
        Employee employee = Employee.builder().name("Employee one").salary(employeeSalary).position(DEVELOPER).build()
        laborCalculator.execute(employee) == salaryExpected

        where:
        employeeSalary  | salaryExpected
        3001.0          | 2670.89
        3500.0          | 3115.0
        5000.0          | 4450.0
    }

    def "should calculate the DBA employee payment when he earns less than two thousand"(){
        expect:
        Employee employee = Employee.builder().name("Employee one").salary(employeeSalary).position(DBA).build()
        laborCalculator.execute(employee) == salaryExpected

        where:
        employeeSalary  | salaryExpected
        2000.0          | 1820.00
        1900.0          | 1729.00
    }

    def "should calculate the DBA employee payment when he earns more than two thousand"(){
        expect:
        Employee employee = Employee.builder().name("Employee one").salary(employeeSalary).position(DBA).build()
        laborCalculator.execute(employee) == salaryExpected

        where:
        employeeSalary  | salaryExpected
        2001.0          | 1820.91
        2200.0          | 2002.0
    }

    def "should calculate the MANAGER employee payment when he earns less than five thousand"(){
        expect:
        Employee employee = Employee.builder().name("Employee one").salary(employeeSalary).position(MANAGER).build()
        laborCalculator.execute(employee) == salaryExpected

        where:
        employeeSalary  | salaryExpected
        5000.0          | 4250.00
        4900.0          | 4165.00
    }

    def "should calculate the MANAGER employee payment when he earns more than five thousand"(){
        expect:
        Employee employee = Employee.builder().name("Employee one").salary(employeeSalary).position(MANAGER).build()
        laborCalculator.execute(employee) == salaryExpected

        where:
        employeeSalary  | salaryExpected
        5001.0          | 4200.84
        5500.0          | 4620.00
    }

}
