package org.JavaCar;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solicitarCredenciales();
        mostrarMenuPrincipal();
    }


    public static void imprimirArchivo(String nombreArchivo) {
        try {
            BufferedReader lecturaArchivo = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lecturaArchivo.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean encontrarArchivo(String nombreArchivo, String comprobar) {
        try {
            BufferedReader lecturaArchivo = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lecturaArchivo.readLine()) != null) {
                System.out.println(linea);
                if (linea.equals(comprobar)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void solicitarCredenciales() {
        boolean variableControl = false;
        do {
            System.out.print("\nPrimero introduzca su usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("A continuación, introduzca su contraseña: ");
            String contrasena = scanner.nextLine();

            String credenciales = usuario.trim() + "," + contrasena.trim();
            if (encontrarArchivo("logins.txt", credenciales)) {
                System.out.println("Bienvenido al sistema.");
                variableControl = true;
            } else {
                System.out.println("Usuario no encontrado.");
            }
        }while (!variableControl);
    }

    public static void mostrarMenuPrincipal() {
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

    public static void mostrarMenuVehiculos() {
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

    public static void mostrarMenuRegistros() {
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