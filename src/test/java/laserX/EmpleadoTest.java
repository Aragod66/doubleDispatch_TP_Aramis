package laserX;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void calculoSalarial() {

        var director = new Director("director", 1500);
        var mandoMedio = new MandoMedio("mandoMedio", 500);
        var junior = new EmpleadoRegular("junior", 100);

        director.agregarEmpleado(mandoMedio);
        mandoMedio.agregarEmpleado(junior);

        assertEquals(2100, director.calcularSalario());
    }

    @Test
    void directorNoPuedeTenerJuniorACargo() {

        var director = new Director("director", 1000);
        var junior = new EmpleadoRegular("junior", 100);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> director.agregarEmpleado(junior));

        assertEquals(
                EmpleadoRegular.VALIDA_DIRECTOR,
                e.getMessage());
    }

    @Test
    void mandoMedioNoPuedeTenerDirectorACargo() {

        var director = new Director("director", 1000);
        var mandoMedio = new MandoMedio("mandoMedio", 500);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> mandoMedio.agregarEmpleado(director));

        assertEquals(
                Empleado.VALIDA_MANDOMEDIO,
                e.getMessage());
    }

    @Test
    void directorPuedeTenerMandoMedioACargo() {

        var director = new Director("director", 1000);
        var mandoMedio = new MandoMedio("mandoMedio", 500);

        assertDoesNotThrow(
                () -> director.agregarEmpleado(mandoMedio));
    }

    @Test
    void mandoMedioPuedeTenerJuniorACargo() {

        var mandoMedio = new MandoMedio("mandoMedio", 500);
        var junior = new EmpleadoRegular("junior", 100);

        assertDoesNotThrow(
                () -> mandoMedio.agregarEmpleado(junior));
    }

    @Test
    void juniorNoPuedeTenerEmpleadosACargo() {

        var junior = new EmpleadoRegular("junior", 100);
        var otroJunior = new EmpleadoRegular("otroJunior", 100);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> junior.puedeEmplear(otroJunior));

        assertEquals(
                Empleado.VALIDA_REGULAR,
                e.getMessage());
    }

    @Test
    void directorNoPuedeTenerDirectorACargo() {

        var director1 = new Director("director1", 1000);
        var director2 = new Director("director2", 1000);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> director1.agregarEmpleado(director2));

        assertEquals(
                Empleado.VALIDA_DIRECTOR,
                e.getMessage());
    }

    @Test
    void mandoMedioNoPuedeTenerMandoMedioACargo() {

        var mando1 = new MandoMedio("mando1", 500);
        var mando2 = new MandoMedio("mando2", 500);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> mando1.agregarEmpleado(mando2));

        assertEquals(
                Empleado.VALIDA_MANDOMEDIO,
                e.getMessage());
    }
}