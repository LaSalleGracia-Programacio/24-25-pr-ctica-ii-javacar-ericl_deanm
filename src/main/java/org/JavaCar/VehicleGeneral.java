package org.JavaCar;

public abstract class VehicleGeneral {
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Roda[] rodes;

    public VehicleGeneral(String marca, String model, double preuBase, Roda[] rodes) {
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.rodes = rodes;
    }
}