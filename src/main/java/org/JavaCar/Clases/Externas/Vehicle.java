package org.JavaCar.Clases.Externas;

import org.JavaCar.Alquiler.Llogable;
import org.JavaCar.Etiquetas.Etiquetas;

public abstract class Vehicle implements Llogable {
    // Atributos
    private int fechaMatriculacion;
    private String matricula;
    private String marca;
    private String modelo;
    private int preuBase;
    private Motor motor;
    private Roda rodes;
    private Etiquetas etiquetaAmbiental;

    // Constructor
    public Vehicle(int fechaMatriculacion, String matricula, String marca, String modelo, int preuBase, Motor motor, Roda rodes, Etiquetas etiquetaAmbiental) {
        this.fechaMatriculacion = fechaMatriculacion;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental = etiquetaAmbiental;
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPreuBase() {
        return preuBase;
    }

    public Motor getMotor() {
        return motor;
    }

    public Roda getRodes() {
        return rodes;
    }

    public Etiquetas getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    public Etiquetas setEtiquetaAmbiental(Etiquetas etiquetaAmbiental) {
        this.etiquetaAmbiental = etiquetaAmbiental;
    }

    //Extras
    private String fechasEtiquetas() {
        if (motor.equalsIgnoreCase("Gasolina"))
    }
}
