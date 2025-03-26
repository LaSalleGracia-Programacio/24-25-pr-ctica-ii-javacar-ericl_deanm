package org.JavaCar;

public class BicicletaElectrica extends VehicleGeneral{

    /**
     * Constructor amb paràmetres
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public BicicletaElectrica(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
    }

    //Getters i setters
    @Override
    public String getMatricula(){
        return matricula;
    }
    @Override
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
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

    //Mètode per calcular el preu
    @Override
    public double calcularPreu(int minuts) {
        return super.calcularPreu(minuts);
    }

    @Override
    public double calcularPreuAmbDescompte(int minuts) {
        double preuSenseDescompte = calcularPreu(minuts);
        double preuAmbDescompte;
        if (minuts >= 60) {
            return preuAmbDescompte = preuSenseDescompte - minuts*0.03;
        } else if (minuts>=90) {
            preuAmbDescompte = preuSenseDescompte - minuts*0.07;
        } else if (minuts >= 120) {
            preuAmbDescompte = preuSenseDescompte - minuts*0.15;
        } else {
            preuAmbDescompte = preuSenseDescompte;
        }
        return preuAmbDescompte;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
