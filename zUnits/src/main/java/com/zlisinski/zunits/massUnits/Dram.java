package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/19/13.
 */
public class Dram extends AbstractMassUnit {
    public Dram(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return poundToGram(toPound());
    }

    @Override
    public BigDecimal toPound() {
        return value.divide(new BigDecimal("256"), mc);
    }
}
