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
    public static double calcularIngressosTotalsVG(List<VehicleGeneral> vehicles, int dies) {
        double ingressosTotals = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            ingressosTotals += vehicles.get(i).calcularPreuAmbDescompte(dies);
        }
        return ingressosTotals;
    }

    //Mètode fals
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).calcularPreu(1) <= preuMax) { // Preu per un dia
                vehiclesFiltrats.add(vehicles.get(i));
            }
        }
        return vehiclesFiltrats;
    }
    public static void filtrarPerPreuVG(List<VehicleGeneral> vehicles, double preuMax) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).calcularPreuAmbDescompte(1) <= preuMax) { // Preu per un dia
                vehicles.get(i).toString();
            }
        }
    }
}