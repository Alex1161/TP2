package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;

public class Panel {
    Jugador jugador1;
    Jugador jugador2;

    public void agregarJugador(String nombre){
        if (this.jugador1 == null){
            this.jugador1 = new Jugador(nombre);
            return;
        }
        this.jugador2 = new Jugador(nombre);
    }


    public boolean todoListo() {
        if (jugador2 != null) {
            return true;
        }
        return false;
    }
}
