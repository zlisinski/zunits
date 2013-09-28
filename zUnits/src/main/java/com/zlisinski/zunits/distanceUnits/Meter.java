package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/16/13.
 */
public class Meter extends AbstractDistanceUnit {
    public Meter(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value;
    }

    @Override
    public BigDecimal toInch() {
        return value.multiply(new BigDecimal("39.3701"));
    }
}
