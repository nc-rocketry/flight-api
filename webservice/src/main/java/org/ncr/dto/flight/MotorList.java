package org.ncr.dto.flight;

import club.ncr.cayenne.Motor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MotorList {

    private final List<Motor> motors = new ArrayList<>();

    public MotorList add(Motor motor, int n) {
        for (int i= 0; i < n; i++) {
            motors.add(motor);
        }
        return this;
    }

    public Motor[] getMotors() {
        return motors.toArray(new Motor[]{});
    }

    public double totalWeight() {
        return motors.stream().collect(Collectors.summingDouble(motor -> motor.getWeight()));
    }
}
