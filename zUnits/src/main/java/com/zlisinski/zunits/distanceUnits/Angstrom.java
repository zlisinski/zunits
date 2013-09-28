package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/27/13.
 */
public class Angstrom extends AbstractDistanceUnit{
    public Angstrom(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value.divide(new BigDecimal("10000000000"), mc);
    }

    @Override
    public BigDecimal toInch() {
        return meterToInch(toMeter());
    }
}
