package org.JavaCar;

public class Cotxe extends Vehicle {
    //Atributs
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preubase, int nombrePlaces, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preubase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    //Getter nombre places
    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        if (dies>=3 && etiquetaAmbiental.equals("Eco") || etiquetaAmbiental.equals("Zero emissions")) {
            descompte=dies*3;
        }else if (dies>=7 && etiquetaAmbiental.equals("Eco") || etiquetaAmbiental.equals("Zero emissions")) {
            descompte=dies*7;
        }
        return super.calcularPreu(dies)-descompte;
    }
}