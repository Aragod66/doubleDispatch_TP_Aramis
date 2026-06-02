package biblioteca;

import java.time.LocalDate;

public class Revista implements Articulo {

    private int paginas;
    private LocalDate fechaPublicacion;

    public Revista(int paginas, LocalDate fechaPublicacion) {
        this.paginas = paginas;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int paginas() {
        return paginas;
    }

    public LocalDate fechaPublicacion() {
        return fechaPublicacion;
    }

    @Override
    public int diasPrestamo(Condicion condicion) {
        return condicion.diasPrestamo(this);
    }
}