package com.zlisinski.zunits.massUnits;

/**
 * Created by zlisinski on 10/18/13.
 */
public enum MassTypes {
    milligram("Milligrams", "mg", Milligram.class),
    gram("Grams", "g", Gram.class),
    kilogram("Kilograms", "kg", Kilogram.class),
    ounce("Ounces", "oz", Ounce.class),
    pound("Pounds", "lb", Pound.class),
    shortTon("Short Tons(US Tons)", "t", ShortTon.class),
    longton("Long Tons(UK Tons)", "t", LongTon.class),
    metricTon("Tonnes(Metric Tons)", "t", MetricTon.class),
    carat("Carats", "ct", Carat.class),
    grain("Grains", "gr", Grain.class),
    dram("Dram", "dr", Dram.class),
    pennyweight("Pennyweights", "dwt", Pennyweight.class),
    stone("Stone", "st", Stone.class);

    private String name;
    private String unitSymbol;
    private Class className;

    private MassTypes(String name, String unitSymbol, Class className) {
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
