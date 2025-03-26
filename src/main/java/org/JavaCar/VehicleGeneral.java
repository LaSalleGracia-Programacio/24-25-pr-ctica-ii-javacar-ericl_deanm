package org.JavaCar;

import java.util.Arrays;

public abstract class VehicleGeneral implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;

    /**
     * Constructor amb paràmetres
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public VehicleGeneral(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    //Getters i setters
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getPreuBase() {
        return preuBase;
    }
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }
    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    public Roda[] getRodes() {
        return rodes;
    }
    public void setRodes(Roda[] rodes) {
        this.rodes = rodes;
    }

    @Override
    public double calcularPreu(int dies) {
        return preuBase*dies;
    }

    @Override
    public double calcularPreuAmbDescompte(int dies) {
        double preuSenseDescompte = calcularPreu(dies);
        double preuAmbDescompte = preuSenseDescompte;
        return preuAmbDescompte;
    }

    @Override
    public String toString() {
        return "Matrícula='" + matricula + '\'' +
                ", Marca='" + marca + '\'' +
                ", Modelo='" + model + '\'' +
                ", Precio base=" + preuBase +
                ", Motor={" + motor.getTipus() +
                ", Ruedas={" + rodes[0].getMarca()+rodes[0].getDiametre()+"}";
    }
}