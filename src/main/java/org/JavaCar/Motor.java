package org.JavaCar;

public class Motor {
    //Atributos
    private String tipus;
    private int potencia;

    //Constructor
    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    //Métodos
    public String getTipus() {
        return tipus;
    }
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    //Override
    @Override
    public String toString() {
        return "Motor: " + tipus + ", potencia: " + potencia;
    }
}
