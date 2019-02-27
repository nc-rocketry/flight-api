package org.ncr.dto.flight;

import club.ncr.cayenne.Motor;

public interface FlightConfiguration {

    public boolean isMultiStage();
    public boolean hasMultipleMotors();
    public Motor[] getMotors();

    public double totalWeight();
}
