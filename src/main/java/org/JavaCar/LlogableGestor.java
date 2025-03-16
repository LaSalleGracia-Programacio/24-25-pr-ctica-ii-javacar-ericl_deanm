package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class LlogableGestor {

    public static class GestorLloguers {
        private List<Vehicle> vehicles = new ArrayList<>();

        // Métodos
        public void agregarVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        public List<Vehicle> obtindreVehicles() {
            return vehicles;
        }

        public double calcularIngressosTotals(int dies) {
            double ingressosTotals = 0.0;
            for (Vehicle vehicle : vehicles) {
                ingressosTotals += vehicle.calcularPreu(dies);
            }
            return ingressosTotals;
        }

        public List<Vehicle> filtrarPerPreu(double preuMax) {
            List<Vehicle> vehiclesFiltrats = new ArrayList<>();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.calcularPreu(1) <= preuMax) { // Preu per un dia
                    vehiclesFiltrats.add(vehicle);
                }
            }
            return vehiclesFiltrats;
        }
    }
}
