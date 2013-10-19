package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/19/13.
 */
public class Pennyweight extends AbstractMassUnit {
    public Pennyweight(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return poundToGram(toPound());
    }

    @Override
    public BigDecimal toPound() {
        BigDecimal b = new BigDecimal((double)7000/(double)24, mc);
        return value.divide(b, mc);
    }
}
