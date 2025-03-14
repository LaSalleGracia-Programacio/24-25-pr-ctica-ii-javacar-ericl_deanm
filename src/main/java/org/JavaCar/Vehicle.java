package org.JavaCar;

public abstract class Vehicle implements Llogable {
    //Atributs
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preubase;
    protected String motor;
    protected int rodes;
    protected String etiquetaAmbiental;

    /**
     * Constructor amb variables
     * @param matricula
     * @param marca
     * @param model
     * @param preubase
     * @param motor
     * @param rodes
     */
    public Vehicle(String matricula, String marca, String model, double preubase, String motor, int rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preubase = preubase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental=calculEtiquetaAmbiental();
    }

    private String calculEtiquetaAmbiental() {}

    //Getters dels atributs
    public String getMatricula() {
        return matricula;
    }
    public String getMarca() {
        return marca;
    }
    public String getModel() {
        return model;
    }
    public double getPreubase() {
        return preubase;
    }
    public String getMotor() {
        return motor;
    }
    public int getRodes() {
        return rodes;
    }
    public String getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    /**
     * Mètode implementat de Llogable
     * @param dies
     * @return
     */
    public double calcularPreu(int dies) {
        return preubase*dies;
    }
}
