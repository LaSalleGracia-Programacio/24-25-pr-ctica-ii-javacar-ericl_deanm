package org.JavaCar;

public class PatinetElectric extends VehicleGeneral {
    //Atributs
    private int autonomia;

    /**
     * Constructor amb paràmetres
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public PatinetElectric(String marca, String model, double preuBase, Motor motor, Roda[] rodes, int autonomia) {
        super(marca, model, preuBase, motor, rodes);
        this.autonomia = autonomia;
    }

    //Getters i setters
    @Override
    public String getMarca() {
        return marca;
    }
    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String getModel() {
        return model;
    }
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public double getPreuBase() {
        return preuBase;
    }
    @Override
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }
    @Override
    public Motor getMotor() {
        return motor;
    }
    @Override
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    @Override
    public Roda[] getRodes() {
        return rodes;
    }
    @Override
    public void setRodes(Roda[] rodes) {
        this.rodes = rodes;
    }
    @Override
    public double getDescompte() {
        return descompte;
    }
    @Override
    public void setDescompte(double descompte) {
        this.descompte = descompte;
    }
    public int getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    //Mètode per calcular el preu
    @Override
    public double calcularPreu(int minuts) {
        return super.calcularPreu(minuts);
    }

    @Override
    public double calcularPreuAmbDescompte(int minuts) {
        double preuSenseDescompte = calcularPreu(minuts);
        double preuAmbDescompte;
        if (minuts >= 30) {
            return preuAmbDescompte = preuSenseDescompte - minuts*0.02;
        } else if (minuts>=60) {
            preuAmbDescompte = preuSenseDescompte - minuts*0.05;
        } else if (minuts >= 120) {
            preuAmbDescompte = preuSenseDescompte - minuts*0.10;
        } else {
            preuAmbDescompte = preuSenseDescompte;
        }
        return preuAmbDescompte;
    }
}
