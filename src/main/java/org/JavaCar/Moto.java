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
        this.etiquetaAmbiental=super.calculEtiquetaAmbiental(mesMatriculacio, anyMatriculacio);
    }
    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    //Getters i setters
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    @Override
    public String getMarca() {return marca;}
    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String getModel() {return model;}
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public double getPreuBase() {return preuBase;}
    @Override
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }
    @Override
    public Motor getMotor() {return motor;}
    @Override
    public void setMotor(Motor motor) {this.motor = motor;}
    @Override
    public Roda[] getRodes() {return rodes;}
    @Override
    public void setRodes(Roda[] rodes) {this.rodes = rodes;}
    @Override
    public void setDescompte(double descompte) {
        super.setDescompte(descompte);
    }
    @Override
    public double getDescompte() {
        return this.descompte;
    }
    @Override
    public int getMesMatriculacio() {return mesMatriculacio;}
    @Override
    public void setMesMatriculacio(int mesMatriculacio) {
        this.mesMatriculacio = mesMatriculacio;
    }
    @Override
    public int getAnyMatriculacio() {return anyMatriculacio;}
    @Override
    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
    }
    @Override
    public Etiquetas getEtiquetaAmbiental() {return etiquetaAmbiental;}
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

    @Override
    public double calcularPreuAmbDescompte(int dies) {
        double preuSenseDescompte = calcularPreu(dies);
        double preuAmbDescompte;
        if (dies >= 2) {
            return preuAmbDescompte = preuSenseDescompte - dies*1;
        } else if (dies>=5) {
            preuAmbDescompte = preuSenseDescompte - dies * 3;
        }else {
            preuAmbDescompte = preuSenseDescompte;
        }
        return preuAmbDescompte;
    }
}