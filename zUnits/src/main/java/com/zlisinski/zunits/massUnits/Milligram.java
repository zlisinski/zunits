package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/18/13.
 */
public class Milligram extends AbstractMassUnit {
    public Milligram(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return value.divide(new BigDecimal("1000"), mc);
    }

    @Override
    public BigDecimal toPound() {
        return gramToPound(toGram());
    }
}
