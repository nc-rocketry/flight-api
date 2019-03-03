package org.ncr.thrustcurve.v2;

import club.ncr.dto.MotorDTO;
import club.ncr.dto.MotorDataDTO;
import club.ncr.dto.MotorManufacturerDTO;
import org.ncr.model.MotorImpulse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface V2Contract {

    List<MotorDTO> search(MotorImpulse impulse) throws IOException;

    List<MotorDTO> search(float diameter) throws IOException;

    List<Float> diameters();

    List<String> impulses();

    List<MotorManufacturerDTO> manufacturers();

    List<MotorDataDTO> getMotorData(String motorId) throws IOException;
}
