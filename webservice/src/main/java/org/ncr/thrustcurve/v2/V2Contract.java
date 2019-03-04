package org.ncr.thrustcurve.v2;

import club.ncr.dto.MotorDTO;
import club.ncr.dto.MotorDataDTO;
import club.ncr.dto.MotorManufacturerDTO;
import org.ncr.dto.motor.ImpulseDTO;

import java.io.IOException;
import java.util.List;

public interface V2Contract {

    List<MotorDTO> search(ImpulseDTO impulse) throws IOException;

    List<MotorDTO> search(float diameter) throws IOException;

    List<Float> diameters();

    List<String> impulses();

    List<MotorManufacturerDTO> manufacturers();

    List<MotorDTO> getMotorData(String motorId) throws IOException;
}
