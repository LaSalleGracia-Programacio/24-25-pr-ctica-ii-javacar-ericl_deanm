package org.JavaCar;

public class Furgoneta extends Vehicle {
    private int capacitatCarga;

    public Furgoneta(int capacitatCarga, String matricula, String marca, String modelo, int preuBase, Motor motor, Roda rodes, Etiquetas etiquetaAmbiental) {
        super(matricula, marca, modelo, preuBase, motor, rodes, etiquetaAmbiental);
        this.capacitatCarga = capacitatCarga;
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    public void setCapacitatCarga(int capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        return getPreuBase() * dies;
    }
}

