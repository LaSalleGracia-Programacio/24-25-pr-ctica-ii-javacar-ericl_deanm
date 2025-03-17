package org.JavaCar;

import java.util.Scanner;

public abstract class Vehicle extends VehicleGeneral {
    //Atributs
    protected String matricula;
    protected int anyMatriculacio;
    protected int mesMatriculacio;
    protected String etiquetaAmbiental;


    //Inici escàner
    Scanner lector = new Scanner(System.in);

    /**
     * Constructor amb paràmetres
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    protected Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        super(marca, model, preuBase, motor, rodes);
        this.matricula = matricula;
        this.mesMatriculacio = 0;
        this.anyMatriculacio = 0;
        this.etiquetaAmbiental=calculEtiquetaAmbiental(anyMatriculacio, mesMatriculacio);
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
    public Roda[] getRodes() {return rodes;}
    public int getAnyMatriculacio() {return anyMatriculacio;}
    public int getMesMatriculacio() {return mesMatriculacio;}
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

    //Setters any i més matriculació
    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
    }
    public void setMesMatriculacio(int mesMatriculacio) {
        this.mesMatriculacio = mesMatriculacio;
    }

    /**
     * Calcula la etiqueta mediambiental segons l'any i mes de matriculació i el tipus
     * @param anyMatriculacio
     * @param mesMatriculacio
     * @return
     */
    private String calculEtiquetaAmbiental(int anyMatriculacio, int mesMatriculacio) {
        if ((anyMatriculacio >= 2001 && mesMatriculacio >=1 && motor.getTipus().equals("Gasolina")) || (anyMatriculacio >= 2006 && mesMatriculacio >=1 && motor.getTipus().equals("Diesel"))) {
            return "B";
        } else if ((anyMatriculacio >= 2006 && mesMatriculacio>=1 &&  motor.getTipus().equals("Gasolina")) || (anyMatriculacio >= 2015 && mesMatriculacio >= 9 && motor.getTipus().equals("Diesel"))) {
            return "C";
        } else if ((motor.getTipus().equals("HEV") || motor.getTipus().equals("GLP") || motor.getTipus().equals("GNL") || motor.getTipus().equals("GNC")) && motor.getAutonomia() < 40) {
            return "Eco";
        } else if ((motor.getTipus().equals("BEV") || motor.getTipus().equals("REEV") || motor.getTipus().equals("PHEV")) && motor.getAutonomia() >= 40) {
            return "Zero Emissions";
        }
        else {
            return "Sense distintiu";
        }
    }
}
