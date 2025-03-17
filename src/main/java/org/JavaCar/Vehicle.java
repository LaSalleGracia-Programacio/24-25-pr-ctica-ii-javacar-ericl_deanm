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
    protected int anyMatriculacio;
    protected int mesMatriculacio;

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
        this.mesMatriculacio = -1;
        this.anyMatriculacio = 0;
        this.etiquetaAmbiental=calculEtiquetaAmbiental(anyMatriculacio, mesMatriculacio);
    }

    private String calculEtiquetaAmbiental(int anyMatriculacio) {
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
    public double getPreuBase() {
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

    /**
     * Metodo para introducir el año de matriculacion y asi saber la etiqueta
     * ambiental que le pertoca.
     * @param anyMatriculacio
     */
    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
        this.etiquetaAmbiental = calculEtiquetaAmbiental(anyMatriculacio);
    }

    public void setMesMatriculacio(int mesMatriculacio) {
        this.mesMatriculacio = mesMatriculacio;
        this.etiquetaAmbiental = calculEtiquetaAmbiental(mesMatriculacio);
    }

    private String calculEtiquetaAmbiental(int anyMatriculacio, int mesMatriculacio) {
        if ((anyMatriculacio >= 2001 && mesMatriculacio >=1 && motor.getTipus() == "Gasolina") || (anyMatriculacio >= 2006 && mesMatriculacio >=1 && motor.getTipus() == "Diesel")) {
            return "B";
        } else if ((anyMatriculacio >= 2006 && mesMatriculacio>=1 &&  motor.getTipus() == "Gasolina") || (anyMatriculacio >= 2015 && mesMatriculacio >= 9 && motor.getTipus() == "Diesel")) {
            return "C";
        } else if ((motor.getTipus() == "HEV" || motor.getTipus() == "GLP" || motor.getTipus() == "GNL" || motor.getTipus() == "GNC") && motor.getAutonomia() <= 40) {
            return "Eco";
        } else if ((motor.getTipus() == "BEV" || motor.getTipus() == "REEV" || motor.getTipus() == "PHEV") && motor.getAutonomia() >= 40) {
            return "Zero Emissions";
        }
        else {
            return "Sense distintiu";
        }
    }
}
