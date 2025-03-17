package org.JavaCar;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Primero introduzca su usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("A continuación, introduzca su contraseña: ");
        String contrasena = scanner.nextLine();

        //Aquí metemos el bucle for para leer el file que contiene el usuario y la
        //contraseña para verificar lo introducido.

        int opcion;
        do {
            System.out.println("Ahora introduzca a que portal desea acceder: ");
            System.out.println("1. Vehículos");
            System.out.println("2. Cuentas");
            System.out.println("3. Registros");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Bienvenido al portal de vehículos. Indique la opción deseada: ");
                    System.out.println("1. Añadir nuevo vehículo");
                    System.out.println("2. Modificar vehículo existente.");
                    System.out.println("3. Eliminar vehículo existente.");
                    System.out.println("4. Salir.");
                    int opcion2 = scanner.nextInt();
                    switch (opcion2) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            System.out.println("Saliendo del portal Vehículo...");
                            break;
                    }
                case 2:
                    //En esteapartado pues se hará una previsión de lo que vale el vehículo por los dias que le ponemos.
                    break;
                case 3:
                    System.out.println("Bienvenido al portal de registros. Indique de qué vehículo desea consultar los vehículos alquilados: ");
                    System.out.println("1. Registro de coches.");
                    System.out.println("2. Registro de motos.");
                    System.out.println("3. Registro de furgonetas.");
                    System.out.println("4. Registro de biciletas.");
                    System.out.println("5. Registro de patinetes eléctricos.");
                    System.out.println("6. Salir");
                    int opcion3 = scanner.nextInt();
                    switch (opcion3) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            System.out.println("Saliendo del portal Registros...");
                            break;
                    }
                case 4:
                    System.out.println("Hasta la próxima...");
            }
        } while (opcion != 4);

    }
}