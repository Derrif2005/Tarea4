package tarea4;

import java.util.Random;
import java.util.Scanner;

public class ejercicio3 {
    static final int FILAS = 4; // Número de semanas
    static final int COLUMNAS = 7; // Número de días (Lunes a Domingo)
    static int[][] temperaturas = new int[FILAS][COLUMNAS]; // Matriz de temperaturas
    static String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    public static void ejecutarEjercicio3() {
        generarTemperaturas();
        mostrarMenu();
    }

    // Generar números aleatorios para las temperaturas diarias (entre 7 y 38 grados)
    public static void generarTemperaturas() {
        Random random = new Random();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                temperaturas[i][j] = random.nextInt(32) + 7; // Números entre 7 y 38
            }
        }
    }

    // Mostrar la matriz de temperaturas con colores (rojo para el más alto, azul para el más bajo)
    public static void mostrarTemperaturasColoreadas() {
        for (int i = 0; i < FILAS; i++) {
            int maxTemp = Integer.MIN_VALUE;
            int minTemp = Integer.MAX_VALUE;

            // Encontrar las temperaturas máxima y mínima de la semana
            for (int j = 0; j < COLUMNAS; j++) {
                if (temperaturas[i][j] > maxTemp) {
                    maxTemp = temperaturas[i][j];
                }
                if (temperaturas[i][j] < minTemp) {
                    minTemp = temperaturas[i][j];
                }
            }

            // Imprimir las temperaturas coloreadas
            for (int j = 0; j < COLUMNAS; j++) {
                if (temperaturas[i][j] == maxTemp) {
                    // Rojo para la temperatura más alta
                    System.out.print("\u001B[31m" + temperaturas[i][j] + " ");
                } else if (temperaturas[i][j] == minTemp) {
                    // Azul para la temperatura más baja
                    System.out.print("\u001B[34m" + temperaturas[i][j] + " ");
                } else {
                    // Color por defecto
                    System.out.print("\u001B[0m" + temperaturas[i][j] + " ");
                }
            }
            System.out.println("\u001B[0m"); // Reset de color
        }
    }

    // Opción A: Mostrar la temperatura más alta y más baja de cada semana y su día correspondiente
    public static void mostrarMaxMinSemanal() {
        for (int i = 0; i < FILAS; i++) {
            int maxTemp = Integer.MIN_VALUE;
            int minTemp = Integer.MAX_VALUE;
            int diaMax = 0;
            int diaMin = 0;

            for (int j = 0; j < COLUMNAS; j++) {
                if (temperaturas[i][j] > maxTemp) {
                    maxTemp = temperaturas[i][j];
                    diaMax = j;
                }
                if (temperaturas[i][j] < minTemp) {
                    minTemp = temperaturas[i][j];
                    diaMin = j;
                }
            }
            System.out.println("Semana " + (i + 1) + ":");
            System.out.println("  Temperatura más alta: " + maxTemp + " grados el día " + diasSemana[diaMax]);
            System.out.println("  Temperatura más baja: " + minTemp + " grados el día " + diasSemana[diaMin]);
        }
    }

    // Opción B: Mostrar el promedio de temperatura por semana
    public static void mostrarPromedioSemanal() {
        for (int i = 0; i < FILAS; i++) {
            int suma = 0;
            for (int j = 0; j < COLUMNAS; j++) {
                suma += temperaturas[i][j];
            }
            int promedio = suma / COLUMNAS;
            System.out.println("En la semana " + (i + 1) + " el promedio de temperatura es de " + promedio + " grados.");
        }
    }

    // Opción C: Mostrar la temperatura más alta de todo el mes y su ubicación (semana y día)
    public static void mostrarMaximaMensual() {
        int maxTemp = Integer.MIN_VALUE;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (temperaturas[i][j] > maxTemp) {
                    maxTemp = temperaturas[i][j];
                }
            }
        }
        
        System.out.println("La(s) temperatura(s) más alta(s) del mes:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (temperaturas[i][j] == maxTemp) {
                    System.out.println("  " + maxTemp + " grados en la semana " + (i + 1) + " el día " + diasSemana[j]);
                }
            }
        }
    }

    // Mostrar menú de opciones
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Mostrar la temperatura más alta y más baja de cada semana");
            System.out.println("2. Mostrar el promedio de temperatura de cada semana");
            System.out.println("3. Mostrar la temperatura más alta del mes");
            System.out.println("4. Mostrar matriz de temperaturas coloreada");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarMaxMinSemanal();
                    break;
                case 2:
                    mostrarPromedioSemanal();
                    break;
                case 3:
                    mostrarMaximaMensual();
                    break;
                case 4:
                    mostrarTemperaturasColoreadas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
}


