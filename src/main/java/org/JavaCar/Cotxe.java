package org.JavaCar;

public class Cotxe extends Vehicle {
    //Atributs
    private int nombrePlaces;

    /**
     * Construcor de cotxe amb totes les variables
     * @param matricula
     * @param marca
     * @param model
     * @param preubase
     * @param nombrePlaces
     * @param motor
     * @param rodes
     * @param mesMatriculacio
     * @param anyMatriculacio
     */
    public Cotxe(String matricula, String marca, String model, double preubase, int nombrePlaces, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        super(matricula, marca, model, preubase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.nombrePlaces = nombrePlaces;
        super.calculEtiquetaAmbiental(mesMatriculacio, anyMatriculacio);
    }
    //Constructor trampa
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

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f, %d, %s, %d, %d, %d",
                getMatricula(),
                getMarca(),
                getModel(),
                getPreuBase(),
                nombrePlaces,
                getMotor().getTipus(),
                getRodes().length,
                getMesMatriculacio(),
                getAnyMatriculacio()
        );
    }
}