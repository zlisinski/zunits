package com.zlisinski.zunits.volumeUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/26/13.
 */
public class Liter extends AbstractVolumeUnit {
    public Liter(String value) {
        super(value);
    }

    @Override
    public BigDecimal toLiter() {
        return value;
    }

    @Override
    public BigDecimal toGallonUS() {
        return literToGallonUS(value);
    }
}
