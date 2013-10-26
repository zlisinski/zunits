package com.zlisinski.zunits.volumeUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/26/13.
 */
public class CubicInch extends AbstractVolumeUnit {
    public CubicInch(String value) {
        super(value);
    }

    @Override
    public BigDecimal toLiter() {
        return gallonUSToLiter(this.toGallonUS());
    }

    @Override
    public BigDecimal toGallonUS() {
        return value.multiply(new BigDecimal("0.004329"));
    }
}
