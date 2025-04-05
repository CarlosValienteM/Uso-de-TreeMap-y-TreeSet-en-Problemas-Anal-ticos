package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree.Evento;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree.GestorEventos;

public class GestorEventosTest {

    @Test
    public void testAgregarYObtenerProximoEvento() {
        GestorEventos gestor = new GestorEventos();

        Evento e1 = new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");
        Evento e2 = new Evento(LocalDateTime.of(2025, 4, 15, 14, 0), "Taller de ML", "Sala 3");

        gestor.agregarEvento(e1);
        gestor.agregarEvento(e2);

        Evento proximo = gestor.obtenerProximoEvento();
        assertEquals("Taller de ML", proximo.getNombre());
    }

    @Test
    public void testEliminarEventosPasados() {
        GestorEventos gestor = new GestorEventos();

        // Evento en el pasado (esto se eliminará automáticamente)
        Evento pasado = new Evento(LocalDateTime.of(2020, 1, 1, 10, 0), "Evento Pasado", "Sala X");
        Evento futuro = new Evento(LocalDateTime.now().plusDays(1), "Evento Futuro", "Auditorio");

        gestor.agregarEvento(pasado);
        gestor.agregarEvento(futuro);

        Evento proximo = gestor.obtenerProximoEvento();
        assertEquals("Evento Futuro", proximo.getNombre());
    }

    @Test
    public void testFallaIntencional() {
        GestorEventos gestor = new GestorEventos();
        Evento futuro = new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");

        gestor.agregarEvento(futuro);

        // Este test debe fallar a propósito
        assertEquals("Taller de Python", gestor.obtenerProximoEvento().getNombre());
    }
}
