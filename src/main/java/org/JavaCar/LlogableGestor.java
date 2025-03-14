package org.JavaCar;

import java.util.*;

public class LlogableGestor {

    public static class GestorLlogables {
            private List<Vehicle> vehicle;

        //Construtor
        public GestorLlogables() {
            vehicle = new ArrayList<>();
        }

        //Métodos
        public static void agregarVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        public List<Vehicle> obtindreVehicle() {
            return vehicle;
        }

        public double calcularIngressosTotals (List<Vehicle>, int dies) {
        }

        public List<Vehicle> filtrarPerPreu (List<Vehicle>, double preuMax) {
        }
    }
}
