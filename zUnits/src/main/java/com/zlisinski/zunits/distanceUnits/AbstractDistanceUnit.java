package com.zlisinski.zunits.distanceUnits;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by zlisinski on 9/16/13.
 */
public abstract class AbstractDistanceUnit {
    protected BigDecimal value;
    protected MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

    public AbstractDistanceUnit(String strValue) {
        this.value = new BigDecimal(strValue);
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal toAngstrom() {
        return this.toMeter().multiply(new BigDecimal("10000000000"));
    }

    public BigDecimal toNanometer() {
        return this.toMeter().multiply(new BigDecimal("1000000000"));
    }

    public BigDecimal toMicrometer() {
        return this.toMeter().multiply(new BigDecimal("1000000"));
    }

    public BigDecimal toMillimeter() {
        return this.toMeter().multiply(new BigDecimal("1000"));
    }

    public BigDecimal toCentimeter() {
        return this.toMeter().multiply(new BigDecimal("100"));
    }

    public abstract BigDecimal toMeter();

    public BigDecimal toKilometer() {
        return this.toMeter().divide(new BigDecimal("1000"));
    }

    public BigDecimal toMil() {
        return this.toInch().multiply(new BigDecimal("1000"));
    }

    public abstract BigDecimal toInch();

    public BigDecimal toFoot() {
        return this.toInch().divide(new BigDecimal("12"), mc);
    }

    public BigDecimal toYard() {
        return this.toInch().divide(new BigDecimal("36"), mc); // 3 feet
    }

    public BigDecimal toFathom() {
        return this.toInch().divide(new BigDecimal("72"), mc); // 6 feet
    }

    public BigDecimal toStatuteMile() {
        return this.toInch().divide(new BigDecimal("63360"), mc); // 5280 feet
    }

    public BigDecimal toNauticalMile() {
        return this.toMeter().divide(new BigDecimal("1852"), mc);
    }

    public BigDecimal toRod() {
        return this.toInch().divide(new BigDecimal("198"), mc); // 16.5 feet
    }

    public BigDecimal toChain() {
        return this.toInch().divide(new BigDecimal("792"), mc); // 66 feet
    }

    public BigDecimal toFurlong() {
        return this.toInch().divide(new BigDecimal("7920"), mc); // 660 feet, .125 mile
    }

    public BigDecimal toAstronomicalUnit() {
        return this.toMeter().divide(new BigDecimal("149597870700"), mc);
    }

    public static BigDecimal inchToMeter(BigDecimal inch) {
        return inch.multiply(new BigDecimal("0.0254"));
    }

    public static BigDecimal meterToInch(BigDecimal meter) {
        return meter.multiply(new BigDecimal("39.3701"));
    }
}
