package org.JavaCar;

import java.util.Arrays;

public class Furgoneta extends Vehicle{
    //Atributs
    private int capacitatCarga;

    /**
     * Constructor amb tots els paràmetres
     * @param matricula
     * @param marca
     * @param model
     * @param preubase
     * @param capacitatCarga
     * @param motor
     * @param rodes
     * @param mesMatriculacio
     * @param anyMatriculacio
     */
    public Furgoneta(String matricula, String marca, String model, double preubase, int capacitatCarga, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio){
        super(matricula, marca, model, preubase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.capacitatCarga = capacitatCarga;
        this.etiquetaAmbiental=super.calculEtiquetaAmbiental(mesMatriculacio, anyMatriculacio);
    }
    //Constructor trampa
    public Furgoneta(String matricula, String marca, String model, double preubase, int capacitatCarga, Motor motor, Roda[] rodes){
        super(matricula, marca, model, preubase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    //Getters i setters
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    @Override
    public String getMarca() {return marca;}
    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String getModel() {return model;}
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public double getPreuBase() {return preuBase;}
    @Override
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }
    @Override
    public Motor getMotor() {return motor;}
    @Override
    public void setMotor(Motor motor) {this.motor = motor;}
    @Override
    public Roda[] getRodes() {return rodes;}
    @Override
    public void setRodes(Roda[] rodes) {this.rodes = rodes;}
    @Override
    public int getMesMatriculacio() {return mesMatriculacio;}
    @Override
    public void setMesMatriculacio(int mesMatriculacio) {
        this.mesMatriculacio = mesMatriculacio;
    }
    @Override
    public int getAnyMatriculacio() {return anyMatriculacio;}
    @Override
    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
    }
    @Override
    public Etiquetas getEtiquetaAmbiental() {return etiquetaAmbiental;}
    public int getCapacitatCarga(){
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga>1000) {
            return ((super.calcularPreu(dies)/dies)+10)*dies;
        } else {
            return super.calcularPreu(dies);
        }
    }

    @Override
    public double calcularPreuAmbDescompte(int dies) {
        double preuSenseDescompte = calcularPreu(dies);
        double preuAmbDescompte;
        if (dies >= 5) {
            preuAmbDescompte = preuSenseDescompte - dies*5;
        } else if (dies>=10) {
            preuAmbDescompte = preuSenseDescompte - dies * 10;
        }else {
            preuAmbDescompte = preuSenseDescompte;
        }
        return preuAmbDescompte;
    }

    @Override
    public String toString() {
        return super.toString()+", Capacidad de carga: "+capacitatCarga;
    }
}