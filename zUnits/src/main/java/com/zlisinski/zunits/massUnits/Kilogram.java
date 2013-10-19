package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/18/13.
 */
public class Kilogram extends AbstractMassUnit {
    public Kilogram(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return value.multiply(new BigDecimal("1000"));
    }

    @Override
    public BigDecimal toPound() {
        return gramToPound(toGram());
    }
}
