package tarea4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ejercicio1 {
    public static List<Integer> generarNumerosAleatorios(int cantidad) {
        List<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            numeros.add(random.nextInt(10)); 
        }
        return numeros;
    }

    // Función para convertir los números en símbolos
    public static List<String> convertirNumerosASimbolos(List<Integer> numeros) {
        List<String> simbolos = new ArrayList<>();
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                simbolos.add("$"); 
            } else {
                simbolos.add("#"); 
            }
        }
        return simbolos;
    }
}
