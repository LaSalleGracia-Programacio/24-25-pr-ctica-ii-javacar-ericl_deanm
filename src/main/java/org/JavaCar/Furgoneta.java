package org.JavaCar;

public class Furgoneta extends Vehicle{
    //Atributs
    private int capacitatCarga;

    /**
     * Constructor amb tots els paràmetres
     * @param matricula
     * @param marca
     * @param model
     * @param preubase
     * @param capacitatCarga
     * @param motor
     * @param rodes
     * @param mesMatriculacio
     * @param anyMatriculacio
     */
    public Furgoneta(String matricula, String marca, String model, double preubase, int capacitatCarga, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio){
        super(matricula, marca, model, preubase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.capacitatCarga = capacitatCarga;
        super.calculEtiquetaAmbiental(mesMatriculacio, anyMatriculacio);
    }
    //Constructor trampa
    public Furgoneta(String matricula, String marca, String model, double preubase, int capacitatCarga, Motor motor, Roda[] rodes){
        super(matricula, marca, model, preubase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    //Getter capacitat
    public int getCapacitatCarga(){
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga>1000) {
            return super.calcularPreu(dies)+10*dies;
        } else {
            return super.calcularPreu(dies);
        }
    }
}