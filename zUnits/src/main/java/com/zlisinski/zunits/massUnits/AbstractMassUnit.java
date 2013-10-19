package com.zlisinski.zunits.massUnits;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by zlisinski on 10/18/13.
 */
public abstract class AbstractMassUnit {
    protected BigDecimal value;
    protected MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

    public AbstractMassUnit(String strValue) {
        this.value = new BigDecimal(strValue);
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal toMilligram() {
        return this.toGram().multiply(new BigDecimal("1000"));
    }

    public abstract BigDecimal toGram();

    public BigDecimal toKilogram() {
        return this.toGram().divide(new BigDecimal("1000"), mc);
    }

    public BigDecimal toOunce() {
        return this.toPound().multiply(new BigDecimal("16"));
    }

    public abstract BigDecimal toPound();

    public BigDecimal toShortTon() {
        return this.toPound().divide(new BigDecimal("2000"), mc);
    }

    public BigDecimal toLongTon() {
        return this.toPound().divide(new BigDecimal("2240"), mc);
    }

    public BigDecimal toMetricTon() {
        return this.toGram().divide(new BigDecimal("1000000"));
    }

    public BigDecimal toCarat() {
        return this.toGram().multiply(new BigDecimal("5"));
    }

    public BigDecimal toGrain() {
        return this.toPound().multiply(new BigDecimal("7000"));
    }

    public BigDecimal toDram() {
        return this.toPound().multiply(new BigDecimal("256"));
    }

    public BigDecimal toPennyweight() {
        BigDecimal b = new BigDecimal((double)7000/(double)24, mc);
        return this.toPound().multiply(b);
    }

    public BigDecimal toStone() {
        return this.toPound().divide(new BigDecimal("14"), mc);
    }

    public static BigDecimal gramToPound(BigDecimal gram) {
        return gram.multiply(new BigDecimal("0.00220462"));
    }

    public static BigDecimal poundToGram(BigDecimal pound) {
        return pound.multiply(new BigDecimal("453.592"));
    }
}
