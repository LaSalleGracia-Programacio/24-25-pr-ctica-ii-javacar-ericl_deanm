package org.JavaCan.Tipos.Vehiculo;

import org.JavaCar.Clases.Externas.Vehicle;
import org.JavaCar.Clases.Externas.Roda;
import org.JavaCar.Etiquetas.Etiquetas;

public class Moto extends Vehicle {
    private int cilindrada;


    public Moto(int cilindrada, String matricula, String marca, String modelo, int preuBase, Motor motor, Roda nodes, Etiquetas etiquetaAmbiental) {
        super(matricula, marca, modelo, preuBase, motor, nodes, etiquetaAmbiental);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }

    public
}
