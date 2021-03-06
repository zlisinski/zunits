package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/28/13.
 */
public class Furlong extends AbstractDistanceUnit {
    public Furlong(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        return inchToMeter(toInch());
    }

    @Override
    public BigDecimal toInch() {
        return value.multiply(new BigDecimal("7920"));
    }
}
