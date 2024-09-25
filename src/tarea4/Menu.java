package tarea4;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Par e Impar con Listas");
            System.out.println("2. Par e Impar con Diccionarios");
            System.out.println("3. Generar matriz de temperaturas");
            System.out.println("4. Salir");
            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Ejecutando Par e Impar con Listas...");
                    List<Integer> numerosAleatorios = ejercicio1.generarNumerosAleatorios(10);
                    System.out.println("Números aleatorios: " + numerosAleatorios);
                    List<String> simbolos = ejercicio1.convertirNumerosASimbolos(numerosAleatorios);
                    System.out.println("Lista convertida a símbolos: " + simbolos);
                    break;
                case 2:
                    System.out.println("Ejecutando Par e Impar con Diccionarios...");
                    Map<Integer, Integer> numerosDiccionario = ejercicio2.generarNumerosAleatorios(10);
                    System.out.println("Números aleatorios: " + numerosDiccionario);
                    Map<Integer, String> simbolosDiccionario = ejercicio2.convertirNumerosASimbolos(numerosDiccionario);
                    System.out.println("Diccionario convertido a símbolos: " + simbolosDiccionario);
                    break;
                case 3:
                    System.out.println("Ejecutando Generar matriz de temperaturas...");
                    ejercicio3.ejecutarEjercicio3(); // Invocación a ejercicio3
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (option != 4);
        
        scanner.close();
    }
}

