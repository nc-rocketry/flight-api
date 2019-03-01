package org.ncr.model;

import org.apache.commons.collections.list.UnmodifiableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImpulseList implements Iterable<MotorImpulse> {

    public static final List<MotorImpulse> IMPULSES = Collections.unmodifiableList(Arrays.asList(MotorImpulse.values()));

    public ImpulseList() {
    }

    public Iterator<MotorImpulse> iterator() {
        return IMPULSES.iterator();
    }
}
