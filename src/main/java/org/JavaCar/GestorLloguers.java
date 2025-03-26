package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {

    //Mètode fals
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double ingressosTotals = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            ingressosTotals += vehicles.get(i).calcularPreu(dies);
        }
        return ingressosTotals;
    }
    //Mètode AD
    public static double calcularIngressosTotalsVGAD(List<VehicleGeneral> vehicles, int dies) {
        double ingressosTotals = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            ingressosTotals += vehicles.get(i).calcularPreuAmbDescompte(dies);
        }
        return ingressosTotals;
    }
    //Mètode SD
    public static double calcularIngressosTotalsVGSD(List<VehicleGeneral> vehicles, int dies) {
        double ingressosTotals = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            ingressosTotals += vehicles.get(i).calcularPreu(dies);
        }
        return ingressosTotals;
    }

    //Mètode fals
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPreuBase() <= preuMax) { // Preu per un dia
                vehiclesFiltrats.add(vehicles.get(i));
            }
        }
        return vehiclesFiltrats;
    }
    public static void filtrarPerPreuVG(List<VehicleGeneral> vehicles, double preuMax) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPreuBase() <= preuMax) { // Preu per un dia
                System.out.println(vehicles.get(i).toString());
            }
        }
    }
}