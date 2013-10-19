package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/18/13.
 */
public class Pound extends AbstractMassUnit {
    public Pound(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return poundToGram(value);
    }

    @Override
    public BigDecimal toPound() {
        return value;
    }
}
