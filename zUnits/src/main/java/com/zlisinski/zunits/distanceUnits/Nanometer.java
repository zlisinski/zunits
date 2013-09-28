package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class Nanometer extends AbstractDistanceUnit {
    public Nanometer(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value.divide(new BigDecimal("1000000000"), mc);
    }

    @Override
    public BigDecimal toInch() {
        //return toMeter().multiply(new BigDecimal("39.3701"));
        return meterToInch(toMeter());
    }
}
