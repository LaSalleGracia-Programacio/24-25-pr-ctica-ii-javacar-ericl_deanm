package org.JavaCar;

public abstract class Vehicle implements Llogable {
    //Atributs
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected String etiquetaAmbiental;

    /**
     * Constructor amb variables
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    protected Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental=calculEtiquetaAmbiental();
    }

    private String calculEtiquetaAmbiental() {
        return "hola";
    }

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
        return preuBase;
    }
    public Motor getMotor() {
        return motor;
    }
    public Roda[] getRodes() {
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
        return preuBase*dies;
    }
}