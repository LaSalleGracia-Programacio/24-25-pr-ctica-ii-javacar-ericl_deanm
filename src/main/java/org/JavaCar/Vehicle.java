package org.JavaCar;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Vehicle extends VehicleGeneral {
    //Atributs

    //Override
    protected String marca;
    protected String model;
    protected String matricula;
    //

    protected int mesMatriculacio;
    protected int anyMatriculacio;
    protected Etiquetas etiquetaAmbiental;


    //Inici escàner
    Scanner lector = new Scanner(System.in);

    /**
     * Constructor amb totes les variables
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     * @param mesMatriculacio
     * @param anyMatriculacio
     */
    protected Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.matricula = matricula;
        this.mesMatriculacio = mesMatriculacio;
        this.anyMatriculacio = anyMatriculacio;
    }
    //Constructor trampa
    protected Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;

    }

    //Getters dels atributs
    @Override
    public String getMatricula() {return matricula;}
    @Override
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
    public void setDescompte(double descompte) {
        super.setDescompte(descompte);
    }
    @Override
    public double getDescompte() {
        return this.descompte;
    }
    public int getMesMatriculacio() {return mesMatriculacio;}
    public void setMesMatriculacio(int mesMatriculacio) {
        this.mesMatriculacio = mesMatriculacio;
    }
    public int getAnyMatriculacio() {return anyMatriculacio;}
    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
    }
    public Etiquetas getEtiquetaAmbiental() {return etiquetaAmbiental;}

    /**
     * Mètode implementat de Llogable
     * @param dies
     * @return
     */
    public double calcularPreu(int dies) {
        return preuBase*dies;
    }

    @Override
    public double calcularPreuAmbDescompte(int dies) {
        return super.calcularPreuAmbDescompte(dies);
    }

    /**
     * Calcula la etiqueta mediambiental segons l'any i mes de matriculació i el tipus
     * @param mesMatriculacio
     * @param anyMatriculacio
     * @return etiquetaAmbiental
     */
    protected Etiquetas calculEtiquetaAmbiental(int mesMatriculacio, int anyMatriculacio) {
        if ((anyMatriculacio >= 2001 && mesMatriculacio >=1 && motor.getTipus().equals("Gasolina")) || (anyMatriculacio >= 2006 && mesMatriculacio >=1 && motor.getTipus().equals("Diesel"))) {
            return Etiquetas.B;
        } else if ((anyMatriculacio >= 2006 && mesMatriculacio>=1 &&  motor.getTipus().equals("Gasolina")) || (anyMatriculacio >= 2015 && mesMatriculacio >= 9 && motor.getTipus().equals("Diesel"))) {
            return Etiquetas.C;
        } else if ((motor.getTipus().equals("HEV") || motor.getTipus().equals("GLP") || motor.getTipus().equals("GNL") || motor.getTipus().equals("GNC")) && motor.getAutonomia() < 40) {
            return Etiquetas.Eco;
        } else if ((motor.getTipus().equals("BEV") || motor.getTipus().equals("REEV") || motor.getTipus().equals("PHEV")) && motor.getAutonomia() >= 40) {
            return Etiquetas.ZeroEmissions;
        }
        else {
            return Etiquetas.SenseDistintiu;
        }
    }
}
