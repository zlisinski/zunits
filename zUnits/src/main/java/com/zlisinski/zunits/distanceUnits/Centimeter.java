package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class Centimeter extends AbstractDistanceUnit {
    public Centimeter(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value.divide(new BigDecimal("100"), mc);
    }

    @Override
    public BigDecimal toInch() {
        return meterToInch(toMeter());
    }
}
