package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/16/13.
 */
public class Foot extends AbstractDistanceUnit {
    public Foot(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        //return value.multiply(new BigDecimal("0.3048"));
        return inchToMeter(toInch());
    }

    @Override
    public BigDecimal toInch() {
        return value.multiply(new BigDecimal("12"));
    }
}
