package org.ncr.dto.flight;

import club.ncr.cayenne.Motor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClusterConfiguration extends MotorList implements FlightConfiguration {

    @Override
    public boolean isMultiStage() {
        return true;
    }

    @Override
    public boolean hasMultipleMotors() {
        return true;
    }


}
