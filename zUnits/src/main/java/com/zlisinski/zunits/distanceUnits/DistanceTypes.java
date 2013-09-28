package com.zlisinski.zunits.distanceUnits;

/**
 * Created by zlisinski on 9/16/13.
 */
public enum DistanceTypes {
    angstrom("Angstroms", Angstrom.class),
    nanometer("Nanometers", Nanometer.class),
    micrometer("Micrometers", Micrometer.class),
    millimeter("Millimeters", Millimeter.class),
    centimeter("Centimeters", Centimeter.class),
    meter("Meters", Meter.class),
    kilometer("Kilometers", Kilometer.class),
    mil("Mils", Mil.class),
    inch("Inches", Inch.class),
    foot("Feet", Foot.class),
    yard("Yards", Yard.class),
    fathom("Fathoms", Fathom.class),
    statuteMile("Miles(Statute)", StatuteMile.class),
    nauticalMile("Miles(Nautical)", NauticalMile.class),
    rod("Rods", Rod.class),
    chain("Chains", Chain.class),
    furlong("Furlongs", Furlong.class),
    astronomicalUnit("Astronomical Units", AstronomicalUnit.class);

    private Class className;
    private String displayName;

    private DistanceTypes(String displayName, Class className) {
        this.displayName = displayName;
        this.className = className;
    }

    public Class getClassName() {
        return this.className;
    }

    public String getDisplayName() {
        return displayName;
    }
}
