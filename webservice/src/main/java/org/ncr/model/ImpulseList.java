package org.ncr.model;

import org.ncr.dto.motor.ImpulseDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImpulseList implements Iterable<ImpulseDTO> {

    public static final List<ImpulseDTO> IMPULSES = Collections.unmodifiableList(Arrays.asList(ImpulseDTO.values()));

    public ImpulseList() {
    }

    public Iterator<ImpulseDTO> iterator() {
        return IMPULSES.iterator();
    }
}
