package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class
Respuestas {
    private List<Respuesta> respuestas=new ArrayList<>();
    private List<Jugador> jugadores=new ArrayList<>();
    private int iterador = 1;;

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        respuestas.add(new Respuesta(jugador));
    }

    public List<Respuesta> obtenerRespuestas() {
        return respuestas;
    }

    public void limpiar(){
        respuestas=new ArrayList<>();
        for (Jugador jugador: jugadores){
            respuestas.add(new Respuesta(jugador));
        }
    }

    public Jugador obtenerJugador(int i) {
        return respuestas.get(i).obtenerJugador();
    }

    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }

    public Respuesta obtenerRespuestaActual() {
        return respuestas.get(iterador);
    }

    public void cambiarJugador() {
        if ( iterador == 0){
            iterador = 1;
        }else{
            iterador = 0;
        }
    }

    public boolean tieneSiguienteJugador() {
        if(iterador == 1){
            return false;
        }else{
            return true;
        }
    }

    public Jugador obtenerJugadorActual() {
        return obtenerRespuestaActual().obtenerJugador();
    }

}
