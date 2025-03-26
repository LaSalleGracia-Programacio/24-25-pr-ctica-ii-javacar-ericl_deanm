package org.JavaCar;

public class Motor {
    private String tipus;
    private int potencia;
    private int autonomia;

    /**
     * Constructor sense autonomia
     * @param tipus
     * @param potencia
     */
    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    /**
     * Constructor amb tots els tipus de variables
     * @param tipus
     * @param potencia
     * @param autonomia
     */
    public Motor(String tipus, int potencia, int autonomia) {
        this.tipus = tipus;
        this.potencia = potencia;
        this.autonomia = autonomia;
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

