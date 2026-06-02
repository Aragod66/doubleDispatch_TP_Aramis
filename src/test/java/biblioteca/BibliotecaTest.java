package biblioteca;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void libroDe250PaginasSePrestaPor3Dias() {

        var libro = new Libro(250);

        assertEquals(
                3,
                libro.diasPrestamo(new Nuevo()));
    }

    @Test
    void libroDe100PaginasSePrestaPor1Dia() {

        var libro = new Libro(100);

        assertEquals(
                1,
                libro.diasPrestamo(new Nuevo()));
    }

    @Test
    void libroDe101PaginasSePrestaPor2Dias() {

        var libro = new Libro(101);

        assertEquals(
                2,
                libro.diasPrestamo(new Nuevo()));
    }

    @Test
    void discoAnteriorA1980NuevoSePrestaPor3Dias() {

        var disco = new Disco(1975);

        assertEquals(
                3,
                disco.diasPrestamo(new Nuevo()));
    }

    @Test
    void discoPosteriorA1980NuevoSePrestaPor5Dias() {

        var disco = new Disco(1985);

        assertEquals(
                5,
                disco.diasPrestamo(new Nuevo()));
    }

    @Test
    void discoDeterioradoAnteriorA1980NoSePuedePrestar() {

        var disco = new Disco(1975);

        assertThrows(
                RuntimeException.class,
                () -> disco.diasPrestamo(
                        new Deteriorado()));
    }

    @Test
    void discoDeterioradoPosteriorA1980PierdeUnDia() {

        var disco = new Disco(1985);

        assertEquals(
                4,
                disco.diasPrestamo(
                        new Deteriorado()));
    }

    @Test
    void revistaMenorA100PaginasSePrestaPor2Dias() {

        var revista =
                new Revista(
                        50,
                        LocalDate.now());

        assertEquals(
                2,
                revista.diasPrestamo(
                        new Nuevo()));
    }

    @Test
    void revistaEntre100Y2000PaginasSePrestaPor3Dias() {

        var revista =
                new Revista(
                        500,
                        LocalDate.now());

        assertEquals(
                3,
                revista.diasPrestamo(
                        new Nuevo()));
    }

    @Test
    void revistaMayorA2000PaginasSePrestaPor5Dias() {

        var revista =
                new Revista(
                        2500,
                        LocalDate.now());

        assertEquals(
                5,
                revista.diasPrestamo(
                        new Nuevo()));
    }

    @Test
    void revistaDeterioradaConMasDe10AniosReduce3Dias() {

        var revista =
                new Revista(
                        2500,
                        LocalDate.now().minusYears(15));

        assertEquals(
                2,
                revista.diasPrestamo(
                        new Deteriorado()));
    }

    @Test
    void revistaDeterioradaConMenosDe10AniosReduce1Dia() {

        var revista =
                new Revista(
                        2500,
                        LocalDate.now().minusYears(5));

        assertEquals(
                4,
                revista.diasPrestamo(
                        new Deteriorado()));
    }

    @Test
    void revistaDeterioradaNuncaPuedeQuedarConMenosDeUnDia() {

        var revista =
                new Revista(
                        50,
                        LocalDate.now().minusYears(15));

        assertEquals(
                1,
                revista.diasPrestamo(
                        new Deteriorado()));
    }

    @Test
    void prestamoCalculaFechaDeDevolucion() {

        var persona = new Persona("Juan");
        var libro = new Libro(250);

        var prestamo =
                new Prestamo(
                        libro,
                        persona,
                        new Nuevo());

        assertEquals(
                LocalDate.now().plusDays(3),
                prestamo.fechaDevolucion());
    }

    @Test
    void prestamoGuardaLaPersona() {

        var persona = new Persona("Juan");

        var prestamo =
                new Prestamo(
                        new Libro(100),
                        persona,
                        new Nuevo());

        assertEquals(
                persona,
                prestamo.persona());
    }
}