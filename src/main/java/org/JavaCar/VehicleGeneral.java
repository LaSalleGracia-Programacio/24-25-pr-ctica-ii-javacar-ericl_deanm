package org.JavaCar;

public abstract class VehicleGeneral implements Llogable, Descompte {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected double descompte;

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
    public double getDescompte() {
        return descompte;
    }
    public void setDescompte(double descompte) {
        this.descompte = descompte;
    }

    public double calcularPreu(int dies) {
        return preuBase*dies;
    }

    @Override
    public double calcularPreuAmbDescompte(int dies) {
        double preuSenseDescompte = calcularPreu(dies);
        double preuAmbDescompte = preuSenseDescompte;
        return preuAmbDescompte;
    }
}