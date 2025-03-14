package org.JavaCar;

public class Furgoneta extends Vehicle{
    //Atributs
    int capacitatCarga;

    //Constructor
    public Furgoneta(String matricula, String marca, String model, double preubase, int capacitatCarga, Motor motor, Roda[] rodes){
        super(matricula, marca, model, preubase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }
}