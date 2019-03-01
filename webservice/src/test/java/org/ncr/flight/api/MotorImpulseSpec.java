package org.ncr.flight.api;

import org.junit.Assert;
import org.junit.Test;
import org.ncr.model.MotorImpulse;

public class MotorImpulseSpec {

    final double FLOAT_PRECISION = 0.000000;

    @Test
    public void testMotorImpulseNsCalculations() {
        Assert.assertEquals("A Impulse", 2.5, MotorImpulse.A.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("B Impulse", 5.0, MotorImpulse.B.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("C Impulse", 10.0, MotorImpulse.C.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("D Impulse", 20.0, MotorImpulse.D.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("E Impulse", 40.0, MotorImpulse.E.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("F Impulse", 80.0, MotorImpulse.F.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("G Impulse", 160.0, MotorImpulse.G.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("H Impulse", 320.0, MotorImpulse.H.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("I Impulse", 640.0, MotorImpulse.I.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("J Impulse", 1_280.0, MotorImpulse.J.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("K Impulse", 2_560.0, MotorImpulse.K.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("L Impulse", 5_120.0, MotorImpulse.L.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("M Impulse", 10_240.0, MotorImpulse.M.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("N Impulse", 20_480.0, MotorImpulse.N.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("O Impulse", 40_960.0, MotorImpulse.O.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("P Impulse", 81_920.0, MotorImpulse.P.maxNewtonSeconds, FLOAT_PRECISION);
        Assert.assertEquals("Q Impulse", 163_840.0, MotorImpulse.Q.maxNewtonSeconds, FLOAT_PRECISION);
    }
}
