package org.JavaCar;

public class BicicletaElectrica extends VehicleGeneral{

    /**
     * Constructor amb paràmetres
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public BicicletaElectrica(String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        super(marca, model, preuBase, motor, rodes);
    }

    //Mètode per calcular el preu
    @Override
    public double calcularPreu(int dies) {
        return super.calcularPreu(dies);
    }
}
