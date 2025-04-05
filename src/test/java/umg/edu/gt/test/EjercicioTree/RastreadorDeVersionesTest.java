package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree.RastreadorDeVersiones;

public class RastreadorDeVersionesTest {

    @Test
    public void testAgregarYObtenerVersiones() {
        RastreadorDeVersiones rv = new RastreadorDeVersiones();

        rv.agregarVersion("System.out.println('Hola Mundo');");
        rv.agregarVersion("System.out.println('Hola Java');");

        assertEquals("System.out.println('Hola Mundo');", rv.obtenerVersion(1));
        assertEquals("System.out.println('Hola Java');", rv.obtenerVersion(2));
    }

    @Test
    public void testObtenerUltimaVersion() {
        RastreadorDeVersiones rv = new RastreadorDeVersiones();

        rv.agregarVersion("Versión A");
        rv.agregarVersion("Versión B");

        assertEquals("Versión B", rv.obtenerUltimaVersion());
    }

    @Test
    public void testEliminarVersion() {
        RastreadorDeVersiones rv = new RastreadorDeVersiones();

        rv.agregarVersion("Version a eliminar");
        rv.eliminarVersion(1);

        assertNull(rv.obtenerVersion(1));
    }

    @Test
    public void testFallaIntencional() {
        RastreadorDeVersiones rv = new RastreadorDeVersiones();
        rv.agregarVersion("System.out.println('Hola');");

        assertEquals("System.out.println('Adiós');", rv.obtenerVersion(1)); // Esto va a fallar
    }
}
