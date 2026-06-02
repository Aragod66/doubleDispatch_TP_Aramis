package biblioteca;

import java.time.LocalDate;

public class Prestamo {

    private Articulo articulo;
    private Persona persona;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public Prestamo(
            Articulo articulo,
            Persona persona,
            Condicion condicion) {

        this.articulo = articulo;
        this.persona = persona;

        this.fechaInicio = LocalDate.now();

        this.fechaDevolucion =
                fechaInicio.plusDays(
                        articulo.diasPrestamo(condicion));
    }

    public Persona persona() {
        return persona;
    }

    public LocalDate fechaInicio() {
        return fechaInicio;
    }

    public LocalDate fechaDevolucion() {
        return fechaDevolucion;
    }

    public Articulo articulo() {
        return articulo;
    }
}