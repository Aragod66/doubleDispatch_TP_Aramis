package laserX;

import laserX.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void calculoSalarial() {

        var director =
                new EmpleadoJerarquico(
                        "director",
                        1500,
                        Cargo.DIRECTOR);

        var mandoMedio =
                new EmpleadoJerarquico(
                        "mandoMedio",
                        500,
                        Cargo.MANDOMEDIO);

        var junior =
                new EmpleadoRegular(
                        "junior",
                        100);

        director.agregarEmpleado(mandoMedio);
        mandoMedio.agregarEmpleado(junior);

        assertEquals(
                2100,
                director.calcularSalario());
    }

    @Test
    void directorNoPuedeTenerJuniorACargo() {

        var director =
                new EmpleadoJerarquico(
                        "director",
                        1000,
                        Cargo.DIRECTOR);

        var junior =
                new EmpleadoRegular(
                        "junior",
                        100);

        RuntimeException e =
                assertThrows(
                        RuntimeException.class,
                        () -> director.agregarEmpleado(junior));

        assertEquals(
                EmpleadoRegular.VALIDA_DIRECTOR,
                e.getMessage());
    }

    @Test
    void mandoMedioNoPuedeTenerDirectorACargo() {

        var director =
                new EmpleadoJerarquico(
                        "director",
                        1000,
                        Cargo.DIRECTOR);

        var mandoMedio =
                new EmpleadoJerarquico(
                        "mandoMedio",
                        500,
                        Cargo.MANDOMEDIO);

        RuntimeException e =
                assertThrows(
                        RuntimeException.class,
                        () -> mandoMedio.agregarEmpleado(director));

        assertEquals(
                EmpleadoJerarquico.VALIDA_MANDOMEDIO,
                e.getMessage());
    }

    @Test
    void directorPuedeTenerMandoMedioACargo() {

        var director =
                new EmpleadoJerarquico(
                        "director",
                        1000,
                        Cargo.DIRECTOR);

        var mandoMedio =
                new EmpleadoJerarquico(
                        "mandoMedio",
                        500,
                        Cargo.MANDOMEDIO);

        assertDoesNotThrow(
                () -> director.agregarEmpleado(
                        mandoMedio));
    }

    @Test
    void mandoMedioPuedeTenerJuniorACargo() {

        var mandoMedio =
                new EmpleadoJerarquico(
                        "mandoMedio",
                        500,
                        Cargo.MANDOMEDIO);

        var junior =
                new EmpleadoRegular(
                        "junior",
                        100);

        assertDoesNotThrow(
                () -> mandoMedio.agregarEmpleado(
                        junior));
    }

    @Test
    void juniorNoPuedeTenerEmpleadosACargo() {

        var junior =
                new EmpleadoRegular(
                        "junior",
                        100);

        var otroJunior =
                new EmpleadoRegular(
                        "otroJunior",
                        100);

        RuntimeException e =
                assertThrows(
                        RuntimeException.class,
                        () -> junior.puedeEmplear(
                                otroJunior));

        assertEquals(
                Empleado.VALIDA_REGULAR,
                e.getMessage());
    }
}