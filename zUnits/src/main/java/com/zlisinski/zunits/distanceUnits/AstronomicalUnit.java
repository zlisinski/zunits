package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class AstronomicalUnit extends AbstractDistanceUnit {
    public AstronomicalUnit(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value.multiply(new BigDecimal("149597870700"));
    }

    @Override
    public BigDecimal toInch() {
        return meterToInch(toMeter());
    }
}
