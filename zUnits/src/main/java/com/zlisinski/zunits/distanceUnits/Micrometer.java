package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class Micrometer extends AbstractDistanceUnit {
    public Micrometer(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value.divide(new BigDecimal("1000000"), mc);
    }

    @Override
    public BigDecimal toInch() {
        return toMeter().multiply(new BigDecimal("39.3701"));
    }
}
