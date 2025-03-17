package org.JavaCar;

public class Motor {
    private String tipus;
    private int potencia;
    private int autonomia;

    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
        this.autonomia = 0;
    }

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

    public int getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
}

