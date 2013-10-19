package com.zlisinski.zunits.distanceUnits;

/**
 * Created by zlisinski on 9/16/13.
 */
public enum DistanceTypes {
    angstrom("Angstroms", "\u00C5", Angstrom.class),
    nanometer("Nanometers", "nm", Nanometer.class),
    micrometer("Micrometers", "\u00B5m", Micrometer.class),
    millimeter("Millimeters", "mm", Millimeter.class),
    centimeter("Centimeters", "cm", Centimeter.class),
    meter("Meters", "m", Meter.class),
    kilometer("Kilometers", "km", Kilometer.class),
    mil("Mils", "mil", Mil.class),
    inch("Inches", "in", Inch.class),
    foot("Feet", "ft", Foot.class),
    yard("Yards", "yd", Yard.class),
    fathom("Fathoms", "ftm", Fathom.class),
    statuteMile("Miles(Statute)", "mi", StatuteMile.class),
    nauticalMile("Miles(Nautical)", "nmi", NauticalMile.class),
    rod("Rods", "rod", Rod.class),
    chain("Chains", "chain", Chain.class),
    furlong("Furlongs", "fur", Furlong.class),
    astronomicalUnit("Astronomical Units", "au", AstronomicalUnit.class);

    private String name;
    private String unitSymbol;
    private Class className;

    private DistanceTypes(String name, String unitSymbol, Class className) {
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
