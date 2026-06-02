package biblioteca;

public class Libro implements Articulo {

    private int paginas;

    public Libro(int paginas) {
        this.paginas = paginas;
    }

    public int paginas() {
        return paginas;
    }

    @Override
    public int diasPrestamo(Condicion condicion) {
        return condicion.diasPrestamo(this);
    }
}