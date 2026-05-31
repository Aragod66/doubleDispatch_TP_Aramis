package juego;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JugadaTest {

    @Test
    void piedraLeGanaATijera() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Piedra().comparar(new Tijera());

        assertEquals(
                "¡Ganaste!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void piedraPierdeConPapel() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Piedra().comparar(new Papel());

        assertEquals(
                "¡Perdiste!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void piedraEmpataConPiedra() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Piedra().comparar(new Piedra());

        assertEquals(
                "¡Es un empate!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void papelLeGanaAPiedra() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Papel().comparar(new Piedra());

        assertEquals(
                "¡Ganaste!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void papelPierdeConTijera() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Papel().comparar(new Tijera());

        assertEquals(
                "¡Perdiste!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void papelEmpataConPapel() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Papel().comparar(new Papel());

        assertEquals(
                "¡Es un empate!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void tijeraLeGanaAPapel() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Tijera().comparar(new Papel());

        assertEquals(
                "¡Ganaste!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void tijeraPierdeConPiedra() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Tijera().comparar(new Piedra());

        assertEquals(
                "¡Perdiste!" + System.lineSeparator(),
                salida.toString());
    }

    @Test
    void tijeraEmpataConTijera() {

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(salida));

        new Tijera().comparar(new Tijera());

        assertEquals(
                "¡Es un empate!" + System.lineSeparator(),
                salida.toString());
    }
}