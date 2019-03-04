package org.ncr.thrustcurve.v1;

import org.ncr.dto.motor.ImpulseDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface V1Contract {

    Object search(ImpulseDTO impulse) throws IOException;

    Object search(float diameter) throws IOException;

    List<Float> diameters();

    List<String> impulses();

    List<Map<String, Object>> manufacturers();
}
