package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.TreeSet;

public class GestorEventos {

    private TreeSet<Evento> eventos = new TreeSet<>();

    // Agregar un evento nuevo
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    // Mostrar todos los eventos en orden cronológico
    public void mostrarEventos() {
        int i = 1;
        for (Evento e : eventos) {
            System.out.println(i++ + ". " + e);
        }
    }

    // Obtener el próximo evento y eliminar los pasados
    public Evento obtenerProximoEvento() {
        eliminarEventosPasados();
        return eventos.isEmpty() ? null : eventos.first();
    }

    // Eliminar eventos con fecha anterior a ahora
    private void eliminarEventosPasados() {
        LocalDateTime ahora = LocalDateTime.now();
        Iterator<Evento> it = eventos.iterator();
        while (it.hasNext()) {
            if (it.next().getFecha().isBefore(ahora)) {
                it.remove();
            }
        }
    }

    // Main para probar desde consola
    public static void main(String[] args) {
        GestorEventos gestor = new GestorEventos();

        gestor.agregarEvento(new Evento(LocalDateTime.of(2025, 4, 15, 14, 0), "Taller de Machine Learning", "Sala 3"));
        gestor.agregarEvento(new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A"));

        Evento proximo = gestor.obtenerProximoEvento();
        System.out.println("Próximo evento: " + (proximo != null ? proximo : "No hay eventos"));

        System.out.println("Lista de eventos:");
        gestor.mostrarEventos();
    }
}
