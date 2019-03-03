package org.ncr.dto.motor;

import club.ncr.cayenne.Motor;
import club.ncr.dto.MotorDataDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MotorSummary implements Comparable<MotorSummary> {

    public final String name;
    public final String identifier;
    public final ImpulseDTO impulse;
    public final float diameter;
    public final String manufacturer;
    public final String designation;
    public final double weight;
    public final double burnTime;
    public final String propellant;
    public final List<MotorDataDTO> data;

    public MotorSummary(Motor motor) {
        this.identifier = motor.getCommonName().getName() +" ["+ motor.getManufacturer().getAbbreviation() +"]";
        this.name = motor.getBrandName();
        this.impulse = ImpulseDTO.valueOf(motor.getImpulse().getImpulse());
        this.diameter = motor.getDiameter().getDiameter();
        this.manufacturer = motor.getManufacturer().getName();
        this.designation = motor.getDesignation();
        this.weight = motor.getWeight();
        this.burnTime = motor.getBurnTime();
        this.propellant= motor.getPropellant().getName();
        this.data = motor.getData().stream().map(d -> new MotorDataDTO(motor, d)).collect(Collectors.toList());
    }

    @Override
    public int compareTo(MotorSummary m) {
        int diff;
        if ((diff = impulse.compareTo(m.impulse)) != 0) {
            return diff;
        } else if ((diff = manufacturer.compareTo(m.manufacturer)) != 0) {
            return diff;
        } else if ((diff = (int)(diameter - m.diameter)) != 0) {
            return diff;
        } else if ((diff = (int)(weight - m.weight)) != 0) {
            return diff;
        } else if ((diff = (int)(burnTime - m.burnTime)) != 0) {
            return diff;
        }
        return diff;
    }
}
