package org.JavaCar;

public class BicicletaElectrica extends VehicleGeneral{
    private int autonomia;

    /**
     * Constructor amb paràmetres
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public BicicletaElectrica(String marca, String model, double preuBase, Motor motor, Roda[] rodes, int autonomia) {
        super(marca, model, preuBase, motor, rodes);
        this.autonomia = autonomia;
    }

    //Mètode per calcular el preu
    @Override
    public double calcularPreu(int minuts) {
        if (minuts >= 60) {
            descompte=minuts*0.03;
        }else if (minuts >= 90) {
            descompte=minuts*0.7;
        }else if (minuts >= 120) {
            descompte=minuts*0.15;
        }
        return super.calcularPreu(minuts)-descompte;
    }
}
