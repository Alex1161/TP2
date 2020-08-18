package edu.fiuba.algo3.modelo.PanelTest;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PanelTest {
    @Test
    public void panelPasaSiguienteJugadorCorrectamente(){
        Panel panel = Panel.getInstancia();
        Jugador j1 = new Jugador("Pablo");
        Jugador j2 = new Jugador("Juan");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);

        panel.agregarJugadores(jugadores);

        assertEquals("Pablo", panel.jugadorActual().getNombre());
        assertTrue(panel.tieneSiguienteJugador());

        panel.cambiarJugador();

        assertEquals("Juan", panel.jugadorActual().getNombre());
        assertFalse(panel.tieneSiguienteJugador());
    }
}
