package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.LectorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Juego {
    private static final String ARCHIVOJSON = "Preguntas.json";
    private static Juego instancia = new Juego();
    List<Ronda> rondas = new ArrayList<Ronda>();
    ListIterator<Ronda> iteradorRondas;
    List<Jugador> jugadores = new ArrayList<Jugador>();

    private Juego(){
        iteradorRondas = rondas.listIterator(1);
        cargarRondas();
    }

    private void cargarRondas() {
        LectorDePreguntas lector = new LectorDePreguntas();
        List<Pregunta> preguntas = new ArrayList<Pregunta>();
        try{
            preguntas = lector.recuperarPreguntas(ARCHIVOJSON);
        }catch (IOException e){
            e.getMessage();
        }

        for(Pregunta pregunta : preguntas){
            rondas.add(new Ronda(pregunta));
        }
    }

    public void setJugadores(List<Jugador> jugadores){
        for (Ronda ronda : rondas){
            ronda.setJugadores(jugadores);
        }
        this.jugadores = jugadores;
        iteradorRondas = rondas.listIterator(1);
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }

    public Pregunta preguntaActual() {
        return rondaActual().getPregunta();
    }

    private Ronda rondaActual() {
        return rondas.get(iteradorRondas.previousIndex());
    }

    public Jugador jugadorActual() {
        return rondaActual().obtenerJugadorActual();
    }

    public static Juego getInstancia(){
        return instancia;
    }

    public Jugador ganadorAlgohoot() {
        if (jugadores.get(0).puntajeValorNumerico() > jugadores.get(1).puntajeValorNumerico()) {
            return jugadores.get(0);
        }else if ((jugadores.get(0).puntajeValorNumerico() == jugadores.get(1).puntajeValorNumerico())) {
            return new Jugador("Empate");
        } else {
            return jugadores.get(1);
        }
    }

    public void limpiar(){
        instancia = new Juego();
    }

    public void aplicarComodin(Comodin comodin) {
        rondaActual().aplicarComodin(comodin);
    }

    public Collection<String> obtenerOpciones() {
        return rondaActual().getOpciones();
    }

    public String tipoPreguntaActual() {
        return rondaActual().getTipoPregunta();
    }
}
