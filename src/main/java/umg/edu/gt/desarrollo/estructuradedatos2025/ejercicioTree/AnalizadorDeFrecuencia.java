package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class AnalizadorDeFrecuencia {

    public static TreeMap<String, Integer> contarFrecuenciaPalabras(String rutaArchivo) {
        TreeMap<String, Integer> frecuencia = new TreeMap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.toLowerCase()
                		.replaceAll("[^a-záéíóúñü\\s\\-]", "")

                        .split("\\s+");

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return frecuencia;
    }

    // Método para imprimir (puede ser útil para probar)
    public static void imprimirFrecuencias(TreeMap<String, Integer> frecuencia) {
        for (String palabra : frecuencia.keySet()) {
            System.out.println(palabra + ": " + frecuencia.get(palabra));
        }
    }
}
