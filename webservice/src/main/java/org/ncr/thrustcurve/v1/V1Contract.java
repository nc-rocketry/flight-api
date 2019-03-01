package org.ncr.thrustcurve.v1;

import org.ncr.model.MotorImpulse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface V1Contract {

    Object search(MotorImpulse impulse) throws IOException;

    Object search(int diameter) throws IOException;

    List<Integer> diameters();

    List<String> impulses();

    List<Map<String, Object>> manufacturers();
}
