package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/18/13.
 */
public class Ounce extends AbstractMassUnit {
    public Ounce(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return poundToGram(toPound());
    }

    @Override
    public BigDecimal toPound() {
        return value.divide(new BigDecimal("16"), mc);
    }
}
