package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/18/13.
 */
public class LongTon extends AbstractMassUnit {
    public LongTon(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return poundToGram(toPound());
    }

    @Override
    public BigDecimal toPound() {
        return value.multiply(new BigDecimal("2240"));
    }
}
