package umg.edu.gt.test.EjercicioTree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree.AnalizadorDeFrecuencia;

public class AnalizadorDeFrecuenciaTest {

    @Test
    public void testFrecuenciaPalabrasCorrecta() {
        String ruta = "src/main/resources/ejemplo.txt";
        TreeMap<String, Integer> resultado = AnalizadorDeFrecuencia.contarFrecuenciaPalabras(ruta);

        assertEquals(3, resultado.get("hola"));     // Aparece 3 veces
        assertEquals(1, resultado.get("mundo"));
        assertEquals(1, resultado.get("nuevo"));
        assertEquals(1, resultado.get("texto"));
        assertEquals(1, resultado.get("prueba"));
    }

    @Test
    public void testFallaIntencional() {
        String ruta = "src/main/resources/ejemplo.txt";
        TreeMap<String, Integer> resultado = AnalizadorDeFrecuencia.contarFrecuenciaPalabras(ruta);

        // Este test está hecho para fallar a propósito (espera 99 en vez de 3)
        assertEquals(99, resultado.get("hola"));
    }
}
