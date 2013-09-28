package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 9/16/13.
 */
public class Inch extends AbstractDistanceUnit {
    public Inch(String value) {
        super(value);
    }

    @Override
    public BigDecimal toMeter() {
        //return value.multiply(new BigDecimal("0.0254"));
        return inchToMeter(value);
    }

    @Override
    public BigDecimal toInch() {
        return value;
    }
}
