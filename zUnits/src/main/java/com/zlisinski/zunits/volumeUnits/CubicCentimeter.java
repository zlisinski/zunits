package com.zlisinski.zunits.volumeUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/26/13.
 */
public class CubicCentimeter extends AbstractVolumeUnit {
    public CubicCentimeter(String value) {
        super(value);
    }

    @Override
    public BigDecimal toLiter() {
        return value.divide(new BigDecimal("1000"), mc);
    }

    @Override
    public BigDecimal toGallonUS() {
        return literToGallonUS(toLiter());
    }
}
