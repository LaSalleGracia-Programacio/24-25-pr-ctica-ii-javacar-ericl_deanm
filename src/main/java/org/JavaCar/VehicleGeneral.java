package org.JavaCar;

public abstract class VehicleGeneral implements Llogable {
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected double descompte;

    /**
     * Constructor amb paràmetres
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public VehicleGeneral(String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    public double calcularPreu(int dies) {
        return preuBase*dies;
    }
}