package org.ncr.flight.api;

import org.junit.Assert;
import org.junit.Test;
import org.ncr.dto.motor.ImpulseDTO;

public class MotorImpulseSpec {

    final double FLOAT_PRECISION = 0.000000;

    @Test
    public void testMotorImpulseNsCalculations() {
        Assert.assertEquals("A Impulse", 2.5, ImpulseDTO.A.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("B Impulse", 5.0, ImpulseDTO.B.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("C Impulse", 10.0, ImpulseDTO.C.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("D Impulse", 20.0, ImpulseDTO.D.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("E Impulse", 40.0, ImpulseDTO.E.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("F Impulse", 80.0, ImpulseDTO.F.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("G Impulse", 160.0, ImpulseDTO.G.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("H Impulse", 320.0, ImpulseDTO.H.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("I Impulse", 640.0, ImpulseDTO.I.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("J Impulse", 1_280.0, ImpulseDTO.J.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("K Impulse", 2_560.0, ImpulseDTO.K.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("L Impulse", 5_120.0, ImpulseDTO.L.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("M Impulse", 10_240.0, ImpulseDTO.M.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("N Impulse", 20_480.0, ImpulseDTO.N.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("O Impulse", 40_960.0, ImpulseDTO.O.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("P Impulse", 81_920.0, ImpulseDTO.P.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("Q Impulse", 163_840.0, ImpulseDTO.Q.maxNewtonSeconds, FLOAT_PRECISION);
    }
}
