package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/18/13.
 */
public class Gram extends AbstractMassUnit {
    public Gram(String value) {
        super(value);
    }

    @Override
    public BigDecimal toGram() {
        return value;
    }

    @Override
    public BigDecimal toPound() {
        return gramToPound(value);
    }
}
