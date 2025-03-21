package org.JavaCar;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        solicitarCredenciales();
        mostrarMenuPrincipal();

        try {
            BufferedWriter archivo = new BufferedWriter(new FileWriter("logins.txt"));
            archivo.write("ericLorenzo123");
            archivo.write("\n1234");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader lecturaArchivo = new BufferedReader(new FileReader("logins.txt"));
            String linea;
            while ((linea = lecturaArchivo.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter archivo2 = new BufferedWriter(new FileWriter("furgonetas.txt"));
            Furgoneta furgoneta1 = new Furgoneta("1234ABC", "Ford", "Transit", 20000, 1000, new Motor("Diesel", 150), new Roda[4], 5, 2020);
            Furgoneta furgoneta2 = new Furgoneta("5678DEF", "Mercedes", "Sprinter", 25000, 1200, new Motor("Gasolina", 200), new Roda[4], 6, 2021);
            Furgoneta furgoneta3 = new Furgoneta("9101GHI", "Renault", "Master", 18000, 800, new Motor("Eléctrico", 100), new Roda[4], 4, 2019);

            archivo2.write(furgoneta1.toString() + "\n");
            archivo2.write(furgoneta2.toString() + "\n");
            archivo2.write(furgoneta3.toString() + "\n");
            archivo2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader lecturaArchivo2 = new BufferedReader(new FileReader("furgonetas.txt"))) {
            String linea2;
            while ((linea2 = lecturaArchivo2.readLine()) != null) {
                String[] datos = linea2.split(",");
                Furgoneta furgoneta = new Furgoneta(
                        datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]),
                        new Motor(datos[5], Integer.parseInt(datos[6])), new Roda[Integer.parseInt(datos[7])], Integer.parseInt(datos[8]), Integer.parseInt(datos[9])
                );
                System.out.println(furgoneta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedWriter archivoCoches = new BufferedWriter(new FileWriter("cotxes.txt"));
            Cotxe cotxe1 = new Cotxe("1111AAA", "Toyota", "Corolla", 25000, 5, new Motor("Gasolina", 150), new Roda[4], 6, 2021);
            Cotxe cotxe2 = new Cotxe("2222BBB", "Honda", "Civic", 23000, 5, new Motor("Híbrido", 120), new Roda[4], 7, 2022);
            Cotxe cotxe3 = new Cotxe("3333CCC", "Ford", "Focus", 21000, 5, new Motor("Diésel", 180), new Roda[4], 8, 2020);

            archivoCoches.write(cotxe1.toString() + "\n");
            archivoCoches.write(cotxe2.toString() + "\n");
            archivoCoches.write(cotxe3.toString() + "\n");
            archivoCoches.close();

            BufferedReader lecturaCoches = new BufferedReader(new FileReader("cotxes.txt"));
            String lineaCoche;
            while ((lineaCoche = lecturaCoches.readLine()) != null) {
                String[] datos = lineaCoche.split(",");
                Cotxe cotxe = new Cotxe(
                        datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]),
                        new Motor(datos[5], Integer.parseInt(datos[6])), new Roda[Integer.parseInt(datos[7])], Integer.parseInt(datos[8]), Integer.parseInt(datos[9])
                );
                System.out.println(cotxe);
            }
            lecturaCoches.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter archivoMotos = new BufferedWriter(new FileWriter("motos.txt"));
            Moto moto1 = new Moto("4444DDD", "Yamaha", "MT-07", 8000, 700, new Motor("Gasolina", 75), new Roda[2], 3, 2019);
            Moto moto2 = new Moto("5555EEE", "Kawasaki", "Ninja", 12000, 1000, new Motor("Gasolina", 120), new Roda[2], 4, 2020);
            Moto moto3 = new Moto("6666FFF", "Harley-Davidson", "Sportster", 15000, 1200, new Motor("Gasolina", 150), new Roda[2], 5, 2021);

            archivoMotos.write(moto1.toString() + "\n");
            archivoMotos.write(moto2.toString() + "\n");
            archivoMotos.write(moto3.toString() + "\n");
            archivoMotos.close();

            BufferedReader lecturaMotos = new BufferedReader(new FileReader("motos.txt"));
            String lineaMoto;
            while ((lineaMoto = lecturaMotos.readLine()) != null) {
                String[] datos = lineaMoto.split(",");
                Moto moto = new Moto(
                        datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]),
                        new Motor(datos[5], Integer.parseInt(datos[6])), new Roda[Integer.parseInt(datos[7])], Integer.parseInt(datos[8]), Integer.parseInt(datos[9])
                );
                System.out.println(moto);
            }
            lecturaMotos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter archivoPatinetes = new BufferedWriter(new FileWriter("patinetesElectricos.txt"));
            PatinetElectric patinet1 = new PatinetElectric("Xiaomi", "Mi Scooter", 500, new Motor("Eléctrico", 30), new Roda[2], 30);
            PatinetElectric patinet2 = new PatinetElectric("Segway", "Ninebot", 600, new Motor("Eléctrico", 40), new Roda[2], 40);
            PatinetElectric patinet3 = new PatinetElectric("Razor", "E300", 400, new Motor("Eléctrico", 25), new Roda[2], 25);

            archivoPatinetes.write(patinet1.toString() + "\n");
            archivoPatinetes.write(patinet2.toString() + "\n");
            archivoPatinetes.write(patinet3.toString() + "\n");
            archivoPatinetes.close();

            BufferedReader lecturaPatinetes = new BufferedReader(new FileReader("patinetesElectricos.txt"));
            String lineaPatinet;
            while ((lineaPatinet = lecturaPatinetes.readLine()) != null) {
                String[] datos = lineaPatinet.split(",");
                PatinetElectric patinet = new PatinetElectric(
                        datos[0], datos[1], Double.parseDouble(datos[2]), new Motor(datos[3], Integer.parseInt(datos[4])), new Roda[Integer.parseInt(datos[5])], Integer.parseInt(datos[6])
                );
                System.out.println(patinet);
            }
            lecturaPatinetes.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            BufferedWriter archivoBicis = new BufferedWriter(new FileWriter("bicis.txt"));
            BicicletaElectrica bici1 = new BicicletaElectrica("BH", "Atom", 1200, new Motor("Eléctrico", 50), new Roda[2], 50);
            BicicletaElectrica bici2 = new BicicletaElectrica("Orbea", "Vibe", 1500, new Motor("Eléctrico", 60), new Roda[2], 60);
            BicicletaElectrica bici3 = new BicicletaElectrica("Trek", "Powerfly", 2000, new Motor("Eléctrico", 70), new Roda[2], 70);

            archivoBicis.write(bici1.toString() + "\n");
            archivoBicis.write(bici2.toString() + "\n");
            archivoBicis.write(bici3.toString() + "\n");
            archivoBicis.close();

            BufferedReader lecturaBicis = new BufferedReader(new FileReader("bicis.txt"));
            String lineaBici;
            while ((lineaBici = lecturaBicis.readLine()) != null) {
                String[] datos = lineaBici.split(",");
                BicicletaElectrica bici = new BicicletaElectrica(
                        datos[0], datos[1], Double.parseDouble(datos[2]), new Motor(datos[3], Integer.parseInt(datos[4])), new Roda[Integer.parseInt(datos[5])], Integer.parseInt(datos[6])
                );
                System.out.println(bici);
            }
            lecturaBicis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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