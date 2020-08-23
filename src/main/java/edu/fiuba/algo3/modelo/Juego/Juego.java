package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.ControladorPrincipal;
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

    //Static
    public static Juego getInstancia(){
        return instancia;
    }

    //Private
    private Juego(){
        cargarRondas();
        iteradorRondas = rondas.listIterator(1);
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

    private Ronda rondaActual() {
        return rondas.get(iteradorRondas.previousIndex());
    }

    //Setters y Getters
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

    public Jugador jugadorActual() {
        return rondaActual().obtenerJugadorActual();
    }

    public Collection<String> obtenerOpciones() {
        return rondaActual().getOpciones();
    }

    public String tipoPreguntaActual() {
        return rondaActual().getTipoPregunta();
    }

    public String enunciadoPreguntaActual() {
        return rondaActual().getEnunciadoPregunta();
    }

    //Acciones
    public String ganadorAlgohoot() {
        if (jugadores.get(0).puntajeValorNumerico() > jugadores.get(1).puntajeValorNumerico()) {
            return jugadores.get(0).getNombre();
        }else if ((jugadores.get(0).puntajeValorNumerico() == jugadores.get(1).puntajeValorNumerico())) {
            return "Empate";
        } else {
            return jugadores.get(1).getNombre();
        }
    }

    public int puntajeGanadorAlgohoot(){
        if (jugadores.get(0).puntajeValorNumerico() > jugadores.get(1).puntajeValorNumerico()) {
            return jugadores.get(0).puntajeValorNumerico();
        }else if ((jugadores.get(0).puntajeValorNumerico() == jugadores.get(1).puntajeValorNumerico())) {
            return jugadores.get(0).puntajeValorNumerico();
        } else {
            return jugadores.get(1).puntajeValorNumerico();
        }
    }

    public void limpiar(){
        instancia = new Juego();
    }

    public void aplicarComodin(Comodin comodin) {
        rondaActual().aplicarComodin(comodin);
    }

    public void responder(List<String> opcionesElegidas) {
        rondaActual().responder(opcionesElegidas);
    }

    public void actualizarTurno() {
        ControladorPrincipal.getInstancia().actualizarTurno();
    }

    public void mostrarPuntaje() {
        if(iteradorRondas.hasNext()){
            iteradorRondas.next();
            ControladorPrincipal.getInstancia().mostrarVistaPuntajes();
        }else {
            ControladorPrincipal.getInstancia().vistaGanador();
        }
    }
}
