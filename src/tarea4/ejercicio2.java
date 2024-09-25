package tarea4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ejercicio2 {
    // Función para generar números aleatorios y llenar el diccionario
    public static Map<Integer, Integer> generarNumerosAleatorios(int cantidad) {
        Map<Integer, Integer> numeros = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            numeros.put(i, random.nextInt(100)); // Genera números entre 0 y 99
        }
        return numeros;
    }

    // Función para convertir los números en símbolos
    public static Map<Integer, String> convertirNumerosASimbolos(Map<Integer, Integer> numeros) {
        Map<Integer, String> simbolos = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numeros.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                simbolos.put(entry.getKey(), "$");
            } else {
                simbolos.put(entry.getKey(), "#"); 
            }
        }
        return simbolos;
    }
}
