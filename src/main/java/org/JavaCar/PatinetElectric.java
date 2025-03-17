package org.JavaCar;

public class PatinetElectric extends VehicleGeneral {
    //Atributs
    private int autonomia;

    /**
     * Constructor amb paràmetres
     * @param marca
     * @param model
     * @param preuBase
     * @param motor
     * @param rodes
     */
    public PatinetElectric(String marca, String model, double preuBase, Motor motor, Roda[] rodes, int autonomia) {
        super(marca, model, preuBase, motor, rodes);
        this.autonomia = autonomia;
    }

    //Mètode per calcular el preu
    @Override
    public double calcularPreu(int minuts) {
        if (minuts >= 30) {
            descompte=minuts*0.02;
        }else if (minuts >= 60) {
            descompte=minuts*0.05;
        }else if (minuts >= 120) {
            descompte=minuts*0.10;
        }
        return super.calcularPreu(minuts)-descompte;
    }
}
