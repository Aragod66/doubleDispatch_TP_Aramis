package biblioteca;

public class Disco implements Articulo {

    private int anioBanda;

    public Disco(int anioBanda) {
        this.anioBanda = anioBanda;
    }

    public int anioBanda() {
        return anioBanda;
    }

    @Override
    public int diasPrestamo(Condicion condicion) {
        return condicion.diasPrestamo(this);
    }
}