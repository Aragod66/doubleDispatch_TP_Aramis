package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Deteriorado implements Condicion {

    @Override
    public int diasPrestamo(Libro libro) {
        return (int) Math.ceil(libro.paginas() / 100.0);
    }

    @Override
    public int diasPrestamo(Disco disco) {

        if (disco.anioBanda() < 1980) {
            throw new RuntimeException(
                    "No se puede prestar un disco deteriorado de una banda anterior a 1980");
        }

        return Math.max(1, 5 - 1);
    }

    @Override
    public int diasPrestamo(Revista revista) {

        int diasBase;

        if (revista.paginas() < 100) {
            diasBase = 2;
        } else if (revista.paginas() < 2000) {
            diasBase = 3;
        } else {
            diasBase = 5;
        }

        long antiguedad =
                ChronoUnit.YEARS.between(
                        revista.fechaPublicacion(),
                        LocalDate.now());

        if (antiguedad > 10) {
            return Math.max(1, diasBase - 3);
        }

        return Math.max(1, diasBase - 1);
    }
}