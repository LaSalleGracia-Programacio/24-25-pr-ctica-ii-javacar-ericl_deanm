package org.JavaCar.Tipos.Vehiculo;

import org.JavaCar.Clases.Externas.Motor;
import org.JavaCar.Clases.Externas.Vehicle;
import org.JavaCar.Clases.Externas.Roda;
import org.JavaCar.Etiquetas.Etiquetas;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe(int nombrePlaces, String matricula, String marca, String modelo, int preuBase, Motor motor, Roda rodes, Etiquetas etiquetaAmbiental) {
        super(matricula, marca, modelo, preuBase, motor, rodes, etiquetaAmbiental);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return getPreuBase() * dies;
    }
}
