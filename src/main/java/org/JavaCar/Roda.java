package org.JavaCar;

public class Roda {
    //Atributos
    private String marca;
    private int diametre;

    //Constructor
    public Roda(String marca, int diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }

    //Métodos
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDiametre() {
        return diametre;
    }
    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    //Override
    @Override
    public String toString() {
        return "Roda: " + marca + ", diametre: " + diametre;
    }
}
