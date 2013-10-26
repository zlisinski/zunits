package com.zlisinski.zunits.volumeUnits;

/**
 * Created by zlisinski on 10/26/13.
 */
public enum VolumeTypes {
    milliliter("Milliliters", "ml", Milliliter.class),
    cubicCentimeters("Cubic Centimeters", "cc", CubicCentimeter.class),
    liter("Liters", "l", Liter.class),
    cubicInch("Cubic Inches", "ci", CubicInch.class),
    gallonUS("Gallon(US)", "gal", GallonUS.class);

    private String name;
    private String unitSymbol;
    private Class className;

    private VolumeTypes(String name, String unitSymbol, Class className) {
        this.name = name;
        this.unitSymbol = unitSymbol;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public Class getClassName() {
        return this.className;
    }

    public String getDisplayName() {
        return name + " (" + unitSymbol + ")";
    }
}
