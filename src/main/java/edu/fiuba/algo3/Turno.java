package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Turno {
    private Jugador jugador;
    private Respuesta respuesta;

    public Turno(Jugador jugador) {
        this.jugador = jugador;
        respuesta = new Respuesta(jugador);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void aplicarComodin(Pregunta pregunta, Comodin comodin) {
        pregunta.agregarComodin(comodin, respuesta);
    }
}
