package org.JavaCar;

public class Moto extends Vehicle {
    //Atributs
    private int cilindrada;

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
            return super.calcularPreu(dies)+5*dies;
        } else {
            return super.calcularPreu(dies);
        }
    }
}