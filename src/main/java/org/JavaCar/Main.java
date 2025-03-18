package org.JavaCar;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solicitarCredenciales();
        mostrarMenuPrincipal();
    }

    private static void solicitarCredenciales() {
        System.out.print("\nPrimero introduzca su usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("A continuación, introduzca su contraseña: ");
        String contrasena = scanner.nextLine();
    }

    private static void mostrarMenuPrincipal() {
        int opcion;

        do {
            System.out.println("\nSeleccione el portal al que desea acceder:");
            System.out.println("1. Vehículos\n2. Cuentas\n3. Registros\n4. Salir");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuVehiculos();
                    break;
                case 2:
                    System.out.println("\nAccediendo al portal de Cuentas...");
                    break;
                case 3:
                    mostrarMenuRegistros();
                    break;
                case 4:
                    System.out.println("\nHasta la próxima...");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenuVehiculos() {
        System.out.println("\nPortal de Vehículos. Seleccione una opción:");
        System.out.println("1. Añadir nuevo vehículo\n2. Modificar vehículo existente\n3. Eliminar vehículo existente\n4. Salir");

        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\nAñadiendo nuevo vehículo...");
                break;
            case 2:
                System.out.println("\nModificando vehículo...");
                break;
            case 3:
                System.out.println("\nEliminando vehículo...");
                break;
            case 4:
                System.out.println("\nSaliendo del portal de Vehículos...");
                break;
            default:
                System.out.println("\nOpción no válida.");
        }
    }

    private static void mostrarMenuRegistros() {
        System.out.println("\nPortal de Registros. Seleccione una opción:");
        System.out.println("1. Registro de coches\n2. Registro de motos\n3. Registro de furgonetas\n4. Registro de bicicletas\n5. Registro de patinetes eléctricos\n6. Salir");

        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("\nConsultando registros...");
                break;
            case 6:
                System.out.println("\nSaliendo del portal de Registros...");
                break;
            default:
                System.out.println("\nOpción no válida.");
        }
    }
}