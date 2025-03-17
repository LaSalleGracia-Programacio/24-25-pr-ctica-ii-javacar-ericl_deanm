package org.JavaCar;
<<<<<<<< HEAD:src/main/java/org/JavaCar/LlogableGestor.java

import org.JavaCar.Clases.Externas.Vehicle;
========
>>>>>>>> edit.test:src/main/java/org/JavaCar/GestorLloguers.java

import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {

<<<<<<<< HEAD:src/main/java/org/JavaCar/LlogableGestor.java
    public static class GestorLloguers {
        private List<Vehicle> vehicles = new ArrayList<>();
========
        private static List<Vehicle> vehicles = new ArrayList<>();
>>>>>>>> edit.test:src/main/java/org/JavaCar/GestorLloguers.java

        // Métodos
        public void agregarVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        public List<Vehicle> obtindreVehicles() {
            return vehicles;
        }

        public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
            double ingressosTotals = 0.0;
            for (Vehicle vehicle : GestorLloguers.vehicles) {
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

