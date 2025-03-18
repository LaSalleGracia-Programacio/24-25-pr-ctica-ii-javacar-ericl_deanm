package org.JavaCar;

public class Moto extends Vehicle {
    //Atributs
    private int cilindrada;

    /**
     * Constructor amb tots els paràmetres
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param cilindrada
     * @param motor
     * @param rodes
     * @param mesMatriculacio
     * @param anyMatriculacio
     */
    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        super(matricula, marca, model, preuBase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.cilindrada = cilindrada;
        super.calculEtiquetaAmbiental(mesMatriculacio, anyMatriculacio);
    }
    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    //Getter cilindrada
    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        if (cilindrada>500) {
            return ((super.calcularPreu(dies)/dies)+5)*dies;
        } else {
            return super.calcularPreu(dies);
        }
    }
}