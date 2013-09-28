package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class NauticalMile extends AbstractDistanceUnit {
    public NauticalMile(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return value.multiply(new BigDecimal("1852"));
    }

    @Override
    public BigDecimal toInch() {
        return meterToInch(toMeter());
    }
}
