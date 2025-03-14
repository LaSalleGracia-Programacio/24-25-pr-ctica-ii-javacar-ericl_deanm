package org.JavaCar;

public class Cotxe extends Vehicle {
    //Atributs
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preubase, String motor, Roda[] rodes, String etiquetaAmbiental, int nombrePlaces) {
        super(matricula, marca, model, preubase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

}