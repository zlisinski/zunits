package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class Mil extends AbstractDistanceUnit {
    public Mil(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return inchToMeter(toInch());
    }

    @Override
    public BigDecimal toInch() {
        return value.divide(new BigDecimal("1000"), mc);
    }
}
