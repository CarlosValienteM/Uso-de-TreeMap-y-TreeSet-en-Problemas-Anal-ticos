package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree;

import java.util.TreeMap;

public class RastreadorDeVersiones {

    private final TreeMap<Integer, String> versiones = new TreeMap<>();
    private int ultimaVersion = 0;

    // Agregar nueva versión
    public void agregarVersion(String contenido) {
        ultimaVersion++;
        versiones.put(ultimaVersion, contenido);
        System.out.println("Agregar versión " + ultimaVersion + ": \"" + contenido + "\"");
    }

    // Obtener versión específica
    public String obtenerVersion(int numeroVersion) {
        return versiones.get(numeroVersion);
    }

    // Obtener la última versión
    public String obtenerUltimaVersion() {
        return versiones.get(ultimaVersion);
    }

    // Eliminar una versión
    public void eliminarVersion(int numeroVersion) {
        versiones.remove(numeroVersion);
    }

    // MAIN para probar desde consola
    public static void main(String[] args) {
        RastreadorDeVersiones rastreador = new RastreadorDeVersiones();

        rastreador.agregarVersion("System.out.println('Hola Mundo');");
        rastreador.agregarVersion("System.out.println('Hola Java');");

        System.out.println("Última versión: \"" + rastreador.obtenerUltimaVersion() + "\"");
        System.out.println("Versión 1: \"" + rastreador.obtenerVersion(1) + "\"");

        // (Opcional) Eliminar versión 1
        rastreador.eliminarVersion(1);
        System.out.println("Versión 1 después de eliminar: " + rastreador.obtenerVersion(1)); // debe ser null
    }
}
