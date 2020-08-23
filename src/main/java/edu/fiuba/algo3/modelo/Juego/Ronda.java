package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Ronda {

    private Pregunta pregunta;
    private List<Turno> turnos = new ArrayList<Turno>();
    private ListIterator<Turno> iteradorTurnos;
    private List<Respuesta> respuestas = new ArrayList<Respuesta>();

    public Ronda(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Pregunta pregunta() {
        return pregunta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public Jugador obtenerJugadorActual() {
        return turnoActual().getJugador();
    }

    private Turno turnoActual() {
        return turnos.get(iteradorTurnos.previousIndex());
    }

    public void setJugadores(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores){
            turnos.add(new Turno(jugador));
        }

        iteradorTurnos = turnos.listIterator(1);
    }

    public void aplicarComodin(Comodin comodin) {
        turnoActual().aplicarComodin(pregunta, comodin);
    }

    public Collection<String> getOpciones() {
        return pregunta.obtenerOpciones().obtenerOpciones();
    }

    public String getTipoPregunta() {
        return pregunta.getTipo();
    }

    public void responder(List<String> opcionesElegidas) {
        turnoActual().responder(opcionesElegidas,this);
    }

    public void agregarRespuesta(Respuesta respuesta) {
        respuestas.add(respuesta);
        if (iteradorTurnos.hasNext()){
            iteradorTurnos.next();
            Juego.getInstancia().actualizarTurno();
        }else{
            pregunta.calificar(respuestas);
            Juego.getInstancia().mostrarPuntaje();
        }
    }
}
