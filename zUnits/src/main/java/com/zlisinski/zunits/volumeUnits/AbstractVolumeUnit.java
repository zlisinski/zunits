package com.zlisinski.zunits.volumeUnits;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by zlisinski on 10/26/13.
 */
public abstract class AbstractVolumeUnit {
    protected BigDecimal value;
    protected MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

    public AbstractVolumeUnit(String strValue) {
        this.value = new BigDecimal(strValue);
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal toMilliliter() {
        return this.toLiter().multiply(new BigDecimal("1000"));
    }

    public BigDecimal toCubicCentimeter() {
        return this.toLiter().multiply(new BigDecimal("1000"));
    }

    public abstract BigDecimal toLiter();

    public BigDecimal toCubicInch() {
        return this.toGallonUS().divide(new BigDecimal("0.004329"), mc);
    }

    public abstract BigDecimal toGallonUS();

    public static BigDecimal literToGallonUS(BigDecimal liter) {
        return liter.multiply(new BigDecimal("0.264172"));
    }

    public static BigDecimal gallonUSToLiter(BigDecimal gallonUS) {
        return gallonUS.multiply(new BigDecimal("3.785411784"));
    }
}
