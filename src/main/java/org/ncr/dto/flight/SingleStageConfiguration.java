package org.ncr.dto.flight;

import club.ncr.cayenne.Motor;

public class SingleStageConfiguration implements FlightConfiguration {

    private Motor motor;

    public SingleStageConfiguration(Motor motor) {
        this.motor= motor;
    }

    public boolean isMultiStage() {
        return false;
    }

    public boolean hasMultipleMotors() {
        return false;
    }

    public Motor[] getMotors() {
        return new Motor[] {motor};
    }

    public double totalWeight() {
        return motor.getWeight();
    }

}
