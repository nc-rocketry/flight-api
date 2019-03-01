package org.ncr.model;

public enum MotorImpulse {

    A(2.5),
    B((int)(2.0 * A.maxNewtonSeconds)),
    C((int)(2.0 * B.maxNewtonSeconds)),
    D((int)(2.0 * C.maxNewtonSeconds)),
    E((int)(2.0 * D.maxNewtonSeconds)),
    F((int)(2.0 * E.maxNewtonSeconds)),
    G((int)(2.0 * F.maxNewtonSeconds)),
    H((int)(2.0 * G.maxNewtonSeconds)),
    I((int)(2.0 * H.maxNewtonSeconds)),
    J((int)(2.0 * I.maxNewtonSeconds)),
    K((int)(2.0 * J.maxNewtonSeconds)),
    L((int)(2.0 * K.maxNewtonSeconds)),
    M((int)(2.0 * L.maxNewtonSeconds)),
    N((int)(2.0 * M.maxNewtonSeconds)),
    O((int)(2.0 * N.maxNewtonSeconds)),
    P((int)(2.0 * O.maxNewtonSeconds)),
    Q((int)(2.0 * P.maxNewtonSeconds)),
    ;

    public final double minNewtonSeconds;
    public final double maxNewtonSeconds;

    MotorImpulse(double maxNewtonSeconds) {
        this.maxNewtonSeconds= maxNewtonSeconds;
        this.minNewtonSeconds= maxNewtonSeconds / 2;
    }
}
