package scrum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void historiaNoPuedeContenerHistoria() {

        var historia1 = new HistoriaDeUsuario(10);
        var historia2 = new HistoriaDeUsuario(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> historia1.agregarItem(historia2));

        assertEquals(
                ItemDeProyecto.VALIDA_HISTORIA,
                e.getMessage());
    }

    @Test
    void historiaNoPuedeContenerSpike() {

        var historia = new HistoriaDeUsuario(10);
        var spike = new Spike(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> historia.agregarItem(spike));

        assertEquals(
                ItemDeProyecto.VALIDA_HISTORIA,
                e.getMessage());
    }

    @Test
    void historiaNoPuedeContenerEpica() {

        var historia = new HistoriaDeUsuario(10);
        var epica = new TareaEpica(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> historia.agregarItem(epica));

        assertEquals(
                ItemDeProyecto.VALIDA_HISTORIA,
                e.getMessage());
    }

    @Test
    void historiaPuedeContenerTareaDesarrollo() {

        var historia = new HistoriaDeUsuario(10);
        var desarrollo = new TareaDesarrollo(20);

        assertDoesNotThrow(
                () -> historia.agregarItem(desarrollo));
    }

    @Test
    void epicaPuedeContenerSpike() {

        var epica = new TareaEpica(10);
        var spike = new Spike(20);

        assertDoesNotThrow(
                () -> epica.agregarItem(spike));
    }

    @Test
    void epicaNoPuedeContenerHistoria() {

        var epica = new TareaEpica(10);
        var historia = new HistoriaDeUsuario(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> epica.agregarItem(historia));

        assertEquals(
                ItemDeProyecto.VALIDA_EPICA,
                e.getMessage());
    }

    @Test
    void epicaNoPuedeContenerTareaDesarrollo() {

        var epica = new TareaEpica(10);
        var desarrollo = new TareaDesarrollo(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> epica.agregarItem(desarrollo));

        assertEquals(
                ItemDeProyecto.VALIDA_EPICA,
                e.getMessage());
    }

    @Test
    void epicaNoPuedeContenerOtraEpica() {

        var epica1 = new TareaEpica(10);
        var epica2 = new TareaEpica(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> epica1.agregarItem(epica2));

        assertEquals(
                ItemDeProyecto.VALIDA_EPICA,
                e.getMessage());
    }

    @Test
    void tareaDesarrolloNoPuedeContenerItems() {

        var desarrollo = new TareaDesarrollo(10);
        var spike = new Spike(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> desarrollo.puedeAgregar(spike));

        assertEquals(
                ItemDeProyecto.VALIDA_AGREGAR_SIMPLE,
                e.getMessage());
    }

    @Test
    void spikeNoPuedeContenerItems() {

        var spike = new Spike(10);
        var desarrollo = new TareaDesarrollo(20);

        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> spike.puedeAgregar(desarrollo));

        assertEquals(
                ItemDeProyecto.VALIDA_AGREGAR_SIMPLE,
                e.getMessage());
    }
}