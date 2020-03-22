package com.grcp.tdd.laborcalculator.core.domain;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Employee {

    private String name;
    private double salary;
    private Position position;

    public enum Position {
        DEVELOPER,
        DBA,
        MANAGER
    }
}
