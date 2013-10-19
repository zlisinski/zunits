package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/19/13.
 */
public class Carat extends AbstractMassUnit {
    public Carat(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return value.divide(new BigDecimal("5"), mc);
    }

    @Override
    public BigDecimal toPound() {
        return gramToPound(toGram());
    }
}
