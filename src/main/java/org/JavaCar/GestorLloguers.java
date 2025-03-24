package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {

    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double ingressosTotals = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            ingressosTotals += vehicles.get(i).calcularPreuAmbDescompte(dies);
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

    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).calcularPreuAmbDescompte(1) <= preuMax) { // Preu per un dia
                vehiclesFiltrats.add(vehicles.get(i));
            }
        }
        return vehiclesFiltrats;
    }
    public static List<VehicleGeneral> filtrarPerPreuVG(List<VehicleGeneral> vehicles, double preuMax) {
        List<VehicleGeneral> vehiclesFiltrats = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).calcularPreuAmbDescompte(1) <= preuMax) { // Preu per un dia
                vehiclesFiltrats.add(vehicles.get(i));
            }
        }
        return vehiclesFiltrats;
    }
}