package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicioTree;

import java.time.LocalDateTime;

public class Evento implements Comparable<Evento> {
    private LocalDateTime fecha;
    private String nombre;
    private String ubicacion;

    public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public int compareTo(Evento otro) {
        return this.fecha.compareTo(otro.fecha);
    }

    @Override
    public String toString() {
        return "\"" + nombre + "\", " + fecha.toString().replace("T", " ") + ", " + ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento)) return false;
        Evento e = (Evento) o;
        return fecha.equals(e.fecha) && nombre.equals(e.nombre);
    }

    @Override
    public int hashCode() {
        return fecha.hashCode() + nombre.hashCode();
    }
}
