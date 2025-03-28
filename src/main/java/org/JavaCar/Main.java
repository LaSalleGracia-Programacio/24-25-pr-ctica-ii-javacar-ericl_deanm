package org.JavaCar;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.JavaCar.GestorLloguers.*;

public class Main {
    //Variables estàtiques
    static Scanner scanner = new Scanner(System.in);
    static List<VehicleGeneral> vehiclesDisponibles = new ArrayList<>();

    //Main
    public static void main(String[] args) {
        vehiclesDisponibles = crearObjectes();
        String control = solicitarCredenciales();
        if (!control.equals("0")) {
            mostrarMenuPrincipal();
        }
    }

    /**
     * Solicita les credencials al usuari
     */
    public static String solicitarCredenciales() {
        boolean variableControl = false;
        String usuario = "";
        do {
            System.out.print("\nPrimero introduzca su usuario, o pulse 0 para salir del programa: ");
            usuario = scanner.nextLine();
            if (usuario.equals("0")) {
                System.out.println("¡Hasta la próxima!");
                return usuario;
            }

            System.out.print("A continuación, introduzca su contraseña: ");
            String contrasena = scanner.nextLine();

            String credenciales = usuario.trim() + ";" + contrasena.trim();
            if (encontrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/logins.txt", credenciales)) {
                System.out.println("Bienvenido al sistema.");
                variableControl = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Vuelva a intentarlo.");
            }
        }while (!variableControl);
        return usuario;
    }

    /**
     * Mostra el menú principal
     */
    public static void mostrarMenuPrincipal() {
        int opcion;

        do {
            System.out.println("\nSeleccione el portal al que desea acceder:");
            System.out.println("1. Vehículos\n2. Cuentas\n3. Registros\n4. Salir");

            System.out.print("Opción: ");
            opcion = comprovarInt();

            switch (opcion) {
                case 1:
                    mostrarMenuVehiculos();
                    break;
                case 2:
                    mostrarMenuCuentas();
                    break;
                case 3:
                    mostrarMenuRegistros();
                    break;
                case 4:
                    System.out.println("\n¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    /**
     * Mostra el menú de vehicles
     */
    public static void mostrarMenuVehiculos() {
        System.out.println("\nPortal de Vehículos. Seleccione una opción:");
        System.out.println("1. Añadir nuevo vehículo\n2. Eliminar vehículo existente\n3. Salir");

        System.out.print("Opción: ");
        int opcion = comprovarInt();

        switch (opcion) {
            case 1:
                afegirVehicle();
                break;
            case 2:
                eliminarVehicle();
                break;
            case 3:
                System.out.println("\nSaliendo del portal de Vehículos...");
                break;
            default:
                System.out.println("\nOpción no válida.");
                break;
        }
    }

    /**
     * Mostra el menu de mostrar comptes
     */
    public static void mostrarMenuCuentas() {
        //Declaració variables
        int opcion;

        //Inici funció
        System.out.println("\nPortal de Cuentas\n1. Ver ingresos totales\n2. Filtrar vehículos por precio\n3. Salir");
        System.out.print("Opcion: ");
        opcion = comprovarInt();

        switch (opcion) {
            case 1: {
                veureIngresosTotals();
                break;
            }
            case 2: {
                filtrarPerPreu();
                break;
            }
            case 3: {
                System.out.println("\nSaliendo...");
                break;
            }
            default: {
                System.out.println("\nOpción no válida.");
                break;
            }
        }
    }

    /**
     * Mostra el menú de registres
     */
    public static void mostrarMenuRegistros() {
        System.out.println("\nPortal de Registros. Seleccione una opción:");
        System.out.println("1. Registro de coches\n2. Registro de motos\n3. Registro de furgonetas\n4. Registro de bicicletas\n5. Registro de patinetes eléctricos\n6. Registro de todos los vehículos\n7. Salir");

        System.out.print("Opción: ");
        int opcion = comprovarInt();

        switch (opcion) {
            case 1:
                System.out.println("Registro de coches:");
                imprimirArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/cotxes.txt");
                break;
            case 2:
                System.out.println("Registro de motos:");
                imprimirArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/motos.txt");
                break;
            case 3:
                System.out.println("Registro de furgonetas:");
                imprimirArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/furgonetas.txt");
                break;
            case 4:
                System.out.println("Registro de bicicletas:");
                imprimirArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/bicis.txt");
                break;
            case 5:
                System.out.println("Registro de patinetes:");
                imprimirArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/patinetesElectricos.txt");
                break;
            case 6:
                System.out.println("Registro de todos los vehículos:");
                imprimirArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/vehicleGeneral.txt");
                break;
            case 7:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("\nOpción no válida.");
                break;
        }
    }

    /**
     * Mostra el menú per triar un dels vehícles que afegir
     */
    public static void afegirVehicle() {
        System.out.println("¿Qué vehículo quieres añadir?");
        System.out.println("1. Coche\n2. Moto\n3. Furgoneta\n4. Bicicleta\n5. Patinete\n6. Salir");

        System.out.print("Opción: ");
        int opcion = comprovarInt();

        switch (opcion) {
            case 1:
                construirVehicle("Coche");
                break;
            case 2:
                construirVehicle("Moto");
                break;
            case 3:
                construirVehicle("Furgoneta");
                break;
            case 4:
                construirVehicle("Bicicleta");
                break;
            case 5:
                construirVehicle("Patinete");
                break;
            case 6:
                System.out.println("\nSaliendo del portal de Vehículos...");
                break;
            default:
                System.out.println("\nOpción no válida.");
        }
    }

    /**
     * Filtra la llista de vehicles especificada segons el preu máxim especificat
     */
    public static void filtrarPerPreu() {
        //Declaració variables
        int opcion;
        double preuMax;
        int comptador=1;
        String id;
        boolean vehicleTrobat=false;
        List<VehicleGeneral> vehiclesMirar = new ArrayList<>();

        //Inici funció
        System.out.println("¿Quieres filtrar por precio todos los vehículos o algunos concretos?");
        System.out.println("1. Todos");
        System.out.println("2. Concretos");
        opcion = comprovarInt();

        switch (opcion) {
            case 1: {
                System.out.println("Indica el precio máximo por día (bicicletas y patinetes se calcularán por minutos):");
                preuMax=comprovarDouble();
                System.out.println("Vehículos filtrados por precio: "+preuMax);
                filtrarPerPreuVG(vehiclesDisponibles, preuMax);
                break;
            }
            case 2: {
                scanner.nextLine();
                System.out.println("Indica las matrículas o id de los vehículos que quieras calcular, e introduce 0 cuando ya no quieras introducir más:");
                while (true) {
                    do {
                        if (vehicleTrobat) {
                            comptador++;
                        }
                        System.out.println("Matrícula/id " + comptador + ":");
                        id = scanner.nextLine();
                        if (id.equals("0")) {
                            break;
                        }else {
                            id = id.toUpperCase();
                            for (int i = 0; i < vehiclesDisponibles.size(); i++) {
                                if (vehiclesDisponibles.get(i).getMatricula().equals(id)) {
                                    vehiclesMirar.add(vehiclesDisponibles.get(i));
                                    vehicleTrobat = true;
                                    break;
                                }
                            }
                            if (!vehicleTrobat) {
                                System.out.println("Matrícula no encontrada, vehículo no añadido");
                            }
                        }
                    }while (!vehicleTrobat);
                    if (id.equals("0")) {
                        break;
                    }else {
                        System.out.println("Vehículo encontrado y añadido");
                    }
                }
                System.out.println("Lista de vehículos terminada.");
                if (vehiclesMirar.isEmpty()) {
                    System.out.println("No hay ningún vehículo en la lista.");
                }else {
                    System.out.println("Indica el precio máximo por día (bicicletas y patinetes se calcularán por minutos):");
                    preuMax = comprovarDouble();
                    System.out.println("Vehículos filtrados por precio: " + preuMax);
                    filtrarPerPreuVG(vehiclesMirar, preuMax);
                }
                break;
            }
            default: {
                System.out.println("Opción no válida.");
                break;
            }
        }
    }

    /**
     * Mostra els ingressos totals de tots els vehícles o dels especificats segons x dies
     */
    public static void veureIngresosTotals() {
        //Declaració variables
        int opcion;
        int dies;
        double ingressosTotalsSD;
        double ingressosTotalsAD;
        int comptador=1;
        String id;
        boolean vehicleTrobat=false;
        List<VehicleGeneral> vehiclesMirar = new ArrayList<>();

        //Inici funció
        System.out.println("¿Quieres calcular ingresos de todos los vehículos o de algunos concretos?");
        System.out.println("1. Todos");
        System.out.println("2. Concretos");
        opcion = comprovarInt();

        switch (opcion) {
            case 1: {
                System.out.println("Indica los días que quieres calcular (bicicletas y patinetes se calcularán por minutos):");
                dies=comprovarInt();
                ingressosTotalsSD=calcularIngressosTotalsVGSD(vehiclesDisponibles, dies);
                ingressosTotalsAD=calcularIngressosTotalsVGAD(vehiclesDisponibles, dies);
                System.out.println("Los ingresos totales sin descuento de todos los vehículos: " + ingressosTotalsSD);
                System.out.println("Los ingresos totales con descuento de todos los vehículos: " + ingressosTotalsAD);
                break;
            }
            case 2: {
                scanner.nextLine();
                System.out.println("Indica las matrículas o id de los vehículos que quieras calcular, e introduce 0 cuando ya no quieras introducir más:");
                while (true) {
                    do {
                        if (vehicleTrobat) {
                            comptador++;
                        }
                        System.out.println("Matrícula/id " + comptador + ":");
                        id = scanner.nextLine();
                        if (id.equals("0")) {
                            break;
                        }else {
                            id = id.toUpperCase();
                            for (int i = 0; i < vehiclesDisponibles.size(); i++) {
                                if (vehiclesDisponibles.get(i).getMatricula().equals(id)) {
                                    vehiclesMirar.add(vehiclesDisponibles.get(i));
                                    vehicleTrobat = true;
                                    break;
                                }
                            }
                            if (!vehicleTrobat) {
                                System.out.println("Matrícula no encontrada, vehículo no añadido");
                            }
                        }
                    }while (!vehicleTrobat);
                    if (id.equals("0")) {
                        break;
                    }else {
                        System.out.println("Vehículo encontrado y añadido");
                    }
                }
                System.out.println("Lista de vehículos terminada.");
                if (vehiclesMirar.isEmpty()) {
                    System.out.println("No hay ningún vehículo en la lista.");
                }else {
                    System.out.println("Indica los días que quieres calcular (bicicletas y patinetes se calcularán por minutos):");
                    dies = comprovarInt();
                    ingressosTotalsSD = calcularIngressosTotalsVGSD(vehiclesMirar, dies);
                    ingressosTotalsAD = calcularIngressosTotalsVGAD(vehiclesMirar, dies);
                    System.out.println("Los ingresos totales sin descuento de los vehículos indicados: " + ingressosTotalsSD);
                    System.out.println("Los ingresos totales con descuento de los vehículos indicados: " + ingressosTotalsAD);
                }
                break;
            }
            default: {
                System.out.println("Opción no válida.");
                break;
            }
        }
    }

    /**
     * Elimina un vehicle tant de l'arraylist com dels documents.txt
     */
    public static void eliminarVehicle() {
        //Declaració variables
        String id;
        char confirmar;
        boolean vehicleTrobat=false;

        //Inici funció
        scanner.nextLine();
        System.out.println("Escribe la matrícula o el identificador del vehículo que quieres eliminar: ");
        id = scanner.nextLine();
        id=(id.toUpperCase());
        for (int i = 0; i < vehiclesDisponibles.size(); i++) {
            if (vehiclesDisponibles.get(i).getMatricula().equals(id)) {
                vehicleTrobat=true;
            }
        }
        if (vehicleTrobat){
            System.out.println("Identificador encontrado, seguro que quieres eliminar el vehículo siguiente?:");
            imprimirLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/vehicleGeneral.txt", id);
            System.out.println("y/n");
            do {
                confirmar = comprovarChar();
                if (confirmar != 'n' && confirmar != 'y' && confirmar != 'N' && confirmar != 'Y') {
                    System.out.println("Escribe 'n' para denegar o 'y' para confirmar.");
                }
            }while (confirmar != 'n' && confirmar != 'y' && confirmar != 'N' && confirmar != 'Y');
            if (confirmar == 'y' || confirmar == 'Y') {
                for (int i = 0; i < vehiclesDisponibles.size(); i++) {
                    if (vehiclesDisponibles.get(i).getMatricula().equals(id)) {
                        vehiclesDisponibles.remove(i);
                    }
                }
                borrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/vehicleGeneral.txt", id);
                borrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/bicis.txt", id);
                borrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/cotxes.txt", id);
                borrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/furgonetas.txt", id);
                borrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/motos.txt", id);
                borrarLineaArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/patinetesElectricos.txt", id);
                System.out.println("Vehículo eliminado.");
            }else {
                System.out.println("Desconfirmando...");
            }
        }else {
            System.out.println("Esta matrícula no se encuentra entre los vehículos disponibles.");
        }
    }


    /**
     * Construïm el vehicle segons el tipus i segons les especificacions de l'usuari i l'afegim a l'array de vehiclesDisponibles
     * @param tipusVehicle
     */
    public static void construirVehicle(String tipusVehicle) {
        //declaració variables
        String matricula="";
        int identificador=0;
        String marca;
        String model;
        double preuBase;
        int nombrePlaces=0;
        int cilindrada=0;
        int capacitatCarga=0;
        Motor motor;
        int numRodes;
        Roda[] rodes;
        int mesMatriculacio=0;
        int anyMatriculacio=0;
        boolean repetir = false;

        //Inici mètode
        if (tipusVehicle.equals("Coche") || tipusVehicle.equals("Moto") || tipusVehicle.equals("Furgoneta")) {
            matricula = comprovarMatricula();
        }else if (tipusVehicle.equals("Bicicleta") || tipusVehicle.equals("Patinete")) {
            do {
                System.out.println("Escribe solo el número del identificador:");
                identificador = comprovarInt();
                if (tipusVehicle.equals("Bicicleta")) {
                        if (encontrarAtributoArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/bicis.txt", "BIC-" + identificador)) {
                        System.out.println("Este id ya ha sido usado antes, introduce otro.");
                        repetir = true;
                    } else {
                        System.out.println("ID aceptado.");
                        repetir = false;
                    }
                }else if (tipusVehicle.equals("Patinete")) {
                    if (encontrarAtributoArchivo("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/patinetesElectricos.txt", "PAT-" + identificador)) {
                        System.out.println("Este id ya ha sido usado antes, introduce otro.");
                        repetir = true;
                    } else {
                        System.out.println("ID aceptado.");
                        repetir = false;
                    }
                }
            }while(repetir);
            scanner.nextLine();
        }
        System.out.println("Escribe la marca del vehículo:");
        marca = scanner.nextLine();
        System.out.println("Escribe el modelo del vehículo:");
        model = scanner.nextLine();
        System.out.println("Escribe el precio base del vehículo:");
        preuBase = comprovarDouble();
        if (tipusVehicle.equals("Coche")) {
            System.out.println("Escribe el número de plazas:");
            nombrePlaces = comprovarInt();
        }else if (tipusVehicle.equals("Moto")) {
            System.out.println("Escribe la cilindrada:");
            cilindrada = comprovarInt();
        }else if (tipusVehicle.equals("Furgoneta")) {
            System.out.println("Escribe la capacidad de carga:");
            capacitatCarga = comprovarInt();
        }
        if (tipusVehicle.equals("Coche") || tipusVehicle.equals("Moto") || tipusVehicle.equals("Furgoneta")) {
            System.out.println("Escribe el mes y el año de matriculación: ");
            System.out.print("Mes: ");
            do {
                mesMatriculacio = comprovarInt();
                if (mesMatriculacio < 1 || mesMatriculacio > 12) {
                    System.out.println("Escribe un mes del año, entre 1 y 12.");
                    scanner.nextLine();
                }
            } while (mesMatriculacio < 1 || mesMatriculacio > 12);
            System.out.println("Año: ");
            do {
                anyMatriculacio = comprovarInt();
                if (anyMatriculacio < 1000 || anyMatriculacio > 9999) {
                    System.out.println("Escribe un número de 4 cifras.");
                }
            } while (anyMatriculacio < 1000 || anyMatriculacio > 9999);
        }
        motor = construirMotor();
        System.out.println("Escribe el número de ruedas del vehículo:");
        numRodes = comprovarInt();
        rodes=construirRodes(numRodes);
        if (tipusVehicle.equals("Coche")) {
            //Construïm el cotxe
            Cotxe cotxe = new Cotxe(matricula, marca, model, preuBase, nombrePlaces, motor, rodes, mesMatriculacio, anyMatriculacio);
            //Afegim el cotxe a l'arraylist vehiclesDisponibles
            vehiclesDisponibles.add(cotxe);
            escriureArxiu("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/cotxes.txt", matricula+";"+marca+";"+model+";"+preuBase+";"+nombrePlaces+";"+motor.getTipus()+";"+rodes[0].getMarca()+";"+mesMatriculacio+";"+anyMatriculacio+";"+cotxe.etiquetaAmbiental);
        }else if (tipusVehicle.equals("Moto")) {
            //Construïm la moto
            Moto moto = new Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes, mesMatriculacio, anyMatriculacio);
            //Afegim la moto a l'arraylist vehiclesDisponibles
            vehiclesDisponibles.add(moto);
            escriureArxiu("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/motos.txt", matricula+";"+marca+";"+model+";"+preuBase+";"+cilindrada+";"+motor.getTipus()+";"+rodes[0].getMarca()+";"+mesMatriculacio+";"+anyMatriculacio+";"+moto.etiquetaAmbiental);
        }else if (tipusVehicle.equals("Furgoneta")) {
            //Construïm la furgo
            Furgoneta furgo = new Furgoneta(matricula, marca, model, preuBase, capacitatCarga, motor, rodes, mesMatriculacio, anyMatriculacio);
            //Afegim la furgo a l'arraylist vehiclesDisponibles
            vehiclesDisponibles.add(furgo);
            escriureArxiu("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/furgonetas.txt", matricula+";"+marca+";"+model+";"+preuBase+";"+capacitatCarga+";"+motor.getTipus()+";"+rodes[0].getMarca()+";"+mesMatriculacio+";"+anyMatriculacio+";"+furgo.etiquetaAmbiental);
        }else if (tipusVehicle.equals("Bicicleta")) {
            //Construïm la bici
            BicicletaElectrica bici = new BicicletaElectrica(matricula, marca, model, preuBase, motor, rodes);
            //Afegim la bici a l'arraylist vehiclesDisponibles
            vehiclesDisponibles.add(bici);
            escriureArxiu("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/bicis.txt", matricula+";"+marca+";"+model+";"+preuBase+";"+motor.getTipus()+";"+rodes[0].getMarca());
        }else if (tipusVehicle.equals("Patinete")) {
            //Construïm el patinet
            PatinetElectric patinet = new PatinetElectric(matricula, marca, model, preuBase, motor, rodes);
            //Afegim el patinet a l'arraylist vehiclesDisponibles
            vehiclesDisponibles.add(patinet);
            escriureArxiu("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/patinetesElectricos.txt", matricula+";"+marca+";"+model+";"+preuBase+";"+motor.getTipus()+";"+rodes[0].getMarca());
        }
        System.out.println("Vehículo insertado con éxito.");
    }

    /**
     * Comprova que la matrícula tingui al menys un digit i un caràcter i que sigui única
     * @return
     */
    public static String comprovarMatricula() {
        String linea;
        boolean teLletra;
        boolean teNumero;
        boolean matriculaExisteix;

        scanner.nextLine();
        do {
            teLletra = false;
            teNumero = false;
            matriculaExisteix=false;

            System.out.println("Introduce la matrícula (debe contener al menos una letra y un número): ");
            linea = scanner.nextLine();
            // Recorremos cada carácter de la línea
            for (char c : linea.toCharArray()) {
                if (Character.isLetter(c)) {
                    teLletra = true;
                } else if (Character.isDigit(c)) {
                    teNumero = true;
                }

                // Si ya cumplió ambos requisitos, salimos del bucle
                if (teLletra && teNumero) {
                    break;
                }
            }
            if (!teLletra || !teNumero) {
                System.out.println("La línea no cumple los requisitos. Debe tener al menos una letra y un número.");
                continue;
            }
            for (int i = 0; i < vehiclesDisponibles.size(); i++) {
                if (vehiclesDisponibles.get(i).getMatricula().equalsIgnoreCase(linea)) {
                    System.out.println("Esta matrícula ya existe, no pueden haber dos iguales.");
                    matriculaExisteix=true;
                    break;
                }
            }
        } while (!teLletra || !teNumero || matriculaExisteix);
        // Convertir todas las letras a mayúsculas
        return linea.toUpperCase();
    }

    /**
     * Construeix les rodes segons les especificades
     * @param numRodes
     * @return
     */
    public static Roda[] construirRodes(int numRodes) {
        //Declaració variables
        String marcaRoda;
        int diametreRoda;
        Roda[] rodes = new Roda[numRodes];

        //Inici funció
        System.out.println("Escribe la marca y el diámetro de las ruedas que usa el coche: ");
        scanner.nextLine();
        System.out.print("Marca: ");
        marcaRoda = scanner.nextLine();
        System.out.println();
        System.out.print("Diámetro: ");
        diametreRoda = comprovarInt();
        System.out.println();
        for (int i = 0; i < numRodes; i++) {
            rodes[i] = new Roda(marcaRoda, diametreRoda);
        }
        return rodes;
    }

    /**
     * Construeix el motor del vehicle
     * @return
     */
    public static Motor construirMotor() {
        //Declaració variables
        String tipusMotor;
        int potenciaMotor;
        int autonomiaMotor;

        //Inici funció
        System.out.println("Introduce el tipo de motor, su potencia y si tiene autonomía:");
        scanner.nextLine();
        System.out.print("Tipo de motor: ");
        tipusMotor = scanner.nextLine();
        System.out.println();
        System.out.print("Potencia de motor: ");
        potenciaMotor = comprovarInt();
        System.out.println();
        System.out.print("Si tiene autonomía, introduce su valor. Si no, pon un valor negativo: ");
        autonomiaMotor = comprovarInt();
        System.out.println();
        //Construïm el motor del vehicle
        if (autonomiaMotor < 0) {
            return new Motor(tipusMotor, potenciaMotor);
        }else {
            return new Motor(tipusMotor, potenciaMotor, autonomiaMotor);
        }
    }

    public static void escriureArxiu(String nombreArchivo, String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true));
            writer.write(text);
            writer.newLine();
            writer.close();

            BufferedWriter writerV = new BufferedWriter(new FileWriter("C:/Users/Eric/OneDrive/Documentos/GitHub/24-25-pr-ctica-ii-javacar-ericl_deanm/src/main/java/org/JavaCar/vehicleGeneral.txt", true));
            writerV.write(text);
            writerV.newLine();
            writerV.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }


    /**
     * Trova linees dins d'un arxiu
     * @param nombreArchivo
     * @param comprobar
     * @return
     */
    public static boolean encontrarLineaArchivo(String nombreArchivo, String comprobar) {
        try {
            BufferedReader lecturaArchivo = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lecturaArchivo.readLine()) != null) {
                if (linea.trim().equals(comprobar.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Troba atributs dins d'un arxiu
     * @param nombreArchivo
     * @param comprobar
     * @return
     */
    public static boolean encontrarAtributoArchivo(String nombreArchivo, String comprobar) {
        try {
            BufferedReader lecturaArchivo = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lecturaArchivo.readLine()) != null) {
                for (String atribut : linea.split(";")) {
                    if (atribut.trim().equals(comprobar.trim())) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void borrarLineaArchivo(String nombreArchivo, String atributABorrar) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                boolean contieneAtributo = false;
                for (String atribut : linea.split(";")) {
                    if (atribut.trim().equals(atributABorrar.trim())) {
                        contieneAtributo = true;
                        break;
                    }
                }
                if (!contieneAtributo) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!lineas.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                for (String linea : lineas) {
                    writer.write(linea);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }

    /**
     * Imprimeix per consola la línea d'un arxiu
     * @param nombreArchivo
     * @param comprobar
     */
    public static void imprimirLineaArchivo(String nombreArchivo, String comprobar) {
        try {
            BufferedReader lecturaArchivo = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lecturaArchivo.readLine()) != null) {
                for (String atribut : linea.split(";")) {
                    if (atribut.trim().equals(comprobar.trim())) {
                        System.out.println(linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprimeix per consola l'arxiu
     * @param nombreArchivo
     */
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

    /**
     * Comprova que la entrada sigui un char
     * @return
     */
    public static char comprovarChar() {
        //Declaració variables
        String text;

        //Inici funció
        do{
        text = scanner.nextLine();
        if (text.length() == 0 || text.length() > 1) {
            if (text.length()==0) {
                System.out.println("Escribe algún caracter.");
            }else {
                System.out.println("Escribe solo un caracter.");
            }
        }
        }while (text.length() == 0 || text.length() > 1);
        return text.charAt(0);
    }

    /**
     * Comprova que el valor sigui double
     * @return
     */
    public static double comprovarDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            System.out.println("Introduzca un número.");
        }
        return scanner.nextDouble();
    }

    /**
     * Comprova que el valor sigui un enter.
     * @return
     */
    private static int comprovarInt() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Introduzca un número entero.");
        }
        return scanner.nextInt();
    }

    /**
     * Crea els vehicles i els guarda a la llista vehicleDisponible
     * @return
     */
    private static List<VehicleGeneral> crearObjectes() {
        //BICI
        Motor motorBici1 = new Motor("BEV", 250, 80);
        Motor motorBici2 = new Motor("BEV", 350, 120);
        Motor motorBici3 = new Motor("BEV", 500, 150);
        Motor motorBici4 = new Motor("BEV", 250, 100);

        Roda rodaBici1 = new Roda("Shimano", 28);
        Roda rodaBici2 = new Roda("Mavic", 26);

        // Constructor per a BicicletaElectrica (preu per minut)
        BicicletaElectrica bici1 = new BicicletaElectrica("BIC-1", "Specialized", "Turbo Vado", 0.25, motorBici1,
                new Roda[]{rodaBici1, rodaBici1});
        vehiclesDisponibles.add(bici1);
        BicicletaElectrica bici2 = new BicicletaElectrica("BIC-2","Trek", "Powerfly", 0.30, motorBici2,
                new Roda[]{rodaBici2, rodaBici2});
        vehiclesDisponibles.add(bici2);
        BicicletaElectrica bici3 = new BicicletaElectrica("BIC-3","Cannondale", "Tesoro Neo", 0.20, motorBici3,
                new Roda[]{rodaBici1, rodaBici1});
        vehiclesDisponibles.add(bici3);
        BicicletaElectrica bici4 = new BicicletaElectrica("BIC-4","BH", "AtomX", 0.15, motorBici4,
                new Roda[]{rodaBici2, rodaBici2});
        vehiclesDisponibles.add(bici4);

        //PATINET
        Motor motorPatinet1 = new Motor("BEV", 350, 30);
        Motor motorPatinet2 = new Motor("BEV", 500, 45);
        Motor motorPatinet3 = new Motor("BEV", 250, 25);
        Motor motorPatinet4 = new Motor("BEV", 600, 50);

        Roda rodaPatinet1 = new Roda("Xiaomi", 8);
        Roda rodaPatinet2 = new Roda("Segway", 10);

        // Constructor per a PatinetElectric (preu per minut)
        PatinetElectric patinet1 = new PatinetElectric("PAT-1","Xiaomi", "Mi Pro 2", 0.20, motorPatinet1,
                new Roda[]{rodaPatinet1, rodaPatinet1});
        vehiclesDisponibles.add(patinet1);
        PatinetElectric patinet2 = new PatinetElectric("PAT-2","Segway", "Ninebot MAX", 0.25, motorPatinet2,
                new Roda[]{rodaPatinet2, rodaPatinet2});
        vehiclesDisponibles.add(patinet2);
        PatinetElectric patinet3 = new PatinetElectric("PAT-3","Kaabo", "Mantis", 0.35, motorPatinet3,
                new Roda[]{rodaPatinet1, rodaPatinet1});
        vehiclesDisponibles.add(patinet3);
        PatinetElectric patinet4 = new PatinetElectric("PAT-4","Dualtron", "Thunder", 0.50, motorPatinet4,
                new Roda[]{rodaPatinet2, rodaPatinet2});
        vehiclesDisponibles.add(patinet4);

        //COTXE
        Motor motorCotxe1 = new Motor("Diesel", 150);
        Motor motorCotxe2 = new Motor("BEV", 204, 450);
        Motor motorCotxe3 = new Motor("PHEV", 245, 50);
        Motor motorCotxe4 = new Motor("Gasolina", 130);

        Roda rodaCotxe1 = new Roda("Michelin", 17);
        Roda rodaCotxe2 = new Roda("Pirelli", 18);
        Roda rodaCotxe3 = new Roda("Continental", 16);

        // Constructor per a Cotxe (preu per dia)
        Cotxe cotxe1 = new Cotxe("1234ABC", "Volkswagen", "Golf", 45.00, 5, motorCotxe1,
                new Roda[]{rodaCotxe1, rodaCotxe1, rodaCotxe1, rodaCotxe1}, 3, 2022);
        vehiclesDisponibles.add(cotxe1);
        Cotxe cotxe2 = new Cotxe("5678DEF", "Tesla", "Model 3", 89.00, 5, motorCotxe2,
                new Roda[]{rodaCotxe2, rodaCotxe2, rodaCotxe2, rodaCotxe2}, 6, 2023);
        vehiclesDisponibles.add(cotxe2);
        Cotxe cotxe3 = new Cotxe("9012GHI", "BMW", "330e", 120.00, 5, motorCotxe3,
                new Roda[]{rodaCotxe3, rodaCotxe3, rodaCotxe3, rodaCotxe3}, 1, 2023);
        vehiclesDisponibles.add(cotxe3);
        Cotxe cotxe4 = new Cotxe("3456JKL", "Seat", "Ibiza", 35.00, 5, motorCotxe4,
                new Roda[]{rodaCotxe1, rodaCotxe1, rodaCotxe1, rodaCotxe1}, 11, 2021);
        vehiclesDisponibles.add(cotxe4);

        //FURGONETA
        Motor motorFurgo1 = new Motor("Diesel", 120);
        Motor motorFurgo2 = new Motor("BEV", 204, 330);
        Motor motorFurgo3 = new Motor("GLP", 136);
        Motor motorFurgo4 = new Motor("Diesel", 150);

        Roda rodaFurgo1 = new Roda("Goodyear", 16);
        Roda rodaFurgo2 = new Roda("Bridgestone", 15);
        Roda rodaFurgo3 = new Roda("Michelin", 17);

        // Constructor per a Furgoneta (preu per dia)
        Furgoneta furgo1 = new Furgoneta("7890MNO", "Mercedes", "Sprinter", 75.00, 1200, motorFurgo1,
                new Roda[]{rodaFurgo1, rodaFurgo1, rodaFurgo1, rodaFurgo1}, 4, 2022);
        vehiclesDisponibles.add(furgo1);
        Furgoneta furgo2 = new Furgoneta("1234PQR", "Ford", "E-Transit", 95.00, 1100, motorFurgo2,
                new Roda[]{rodaFurgo2, rodaFurgo2, rodaFurgo2, rodaFurgo2}, 8, 2023);
        vehiclesDisponibles.add(furgo2);
        Furgoneta furgo3 = new Furgoneta("5678STU", "Citroën", "Jumper", 65.00, 1400, motorFurgo3,
                new Roda[]{rodaFurgo3, rodaFurgo3, rodaFurgo3, rodaFurgo3}, 5, 2021);
        vehiclesDisponibles.add(furgo3);
        Furgoneta furgo4 = new Furgoneta("9012VWX", "Volkswagen", "Crafter", 85.00, 1300, motorFurgo4,
                new Roda[]{rodaFurgo1, rodaFurgo1, rodaFurgo1, rodaFurgo1}, 2, 2023);
        vehiclesDisponibles.add(furgo4);

        //MOTO
        Motor motorMoto1 = new Motor("Gasolina", 125);
        Motor motorMoto2 = new Motor("Gasolina", 600);
        Motor motorMoto3 = new Motor("BEV", 72, 120);
        Motor motorMoto4 = new Motor("Gasolina", 1000);

        Roda rodaMoto1 = new Roda("Dunlop", 17);
        Roda rodaMoto2 = new Roda("Pirelli", 19);
        Roda rodaMoto3 = new Roda("Michelin", 17);

        // Constructor per a Moto (preu per dia)
        Moto moto1 = new Moto("1234ZZZ", "Honda", "CB125F", 25.00, 125, motorMoto1,
                new Roda[]{rodaMoto1, rodaMoto1}, 3, 2023);
        vehiclesDisponibles.add(moto1);
        Moto moto2 = new Moto("5678YYY", "Yamaha", "MT-07", 45.00, 689, motorMoto2,
                new Roda[]{rodaMoto2, rodaMoto2}, 6, 2022);
        vehiclesDisponibles.add(moto2);
        Moto moto3 = new Moto("9012XXX", "Zero", "SR/F", 75.00, 0, motorMoto3,
                new Roda[]{rodaMoto3, rodaMoto3}, 4, 2023);
        vehiclesDisponibles.add(moto3);
        Moto moto4 = new Moto("3456WWW", "Kawasaki", "Ninja", 60.00, 998, motorMoto4,
                new Roda[]{rodaMoto1, rodaMoto1}, 9, 2021);
        vehiclesDisponibles.add(moto4);

        return vehiclesDisponibles;
    }
}