package com.zlisinski.zunits.volumeUnits;

import java.math.BigDecimal;

/**
 * Created by zlisinski on 10/26/13.
 */
public class GallonUS extends AbstractVolumeUnit {
    public GallonUS(String value) {
        super(value);
    }

    @Override
    public BigDecimal toLiter() {
        return gallonUSToLiter(value);
    }

    @Override
    public BigDecimal toGallonUS() {
        return value;
    }
}
