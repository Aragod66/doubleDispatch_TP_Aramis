package biblioteca;

public class Nuevo implements Condicion {

    @Override
    public int diasPrestamo(Libro libro) {
        return (int) Math.ceil(libro.paginas() / 100.0);
    }

    @Override
    public int diasPrestamo(Disco disco) {
        return disco.anioBanda() < 1980 ? 3 : 5;
    }

    @Override
    public int diasPrestamo(Revista revista) {

        if (revista.paginas() < 100) {
            return 2;
        }

        if (revista.paginas() < 2000) {
            return 3;
        }

        return 5;
    }
}