package biblioteca;

public interface Condicion {

    int diasPrestamo(Libro libro);

    int diasPrestamo(Disco disco);

    int diasPrestamo(Revista revista);
}