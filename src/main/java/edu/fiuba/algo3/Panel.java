package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.LectorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Panel {
    private static Panel instancia = new Panel();
    private List<Jugador> listaJugadores = new ArrayList<Jugador>();
    private final String ARCHIVOJSON = "Preguntas.json";
    List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
    ListIterator<Pregunta> iteradorPreguntas;
    ListIterator<Jugador> iteradorJugadores;
    int iterador;
    int iteradorPregunta;

    private Panel(){
        iterador = 1;
        iteradorPregunta = 0;
        LectorDePreguntas lector = new LectorDePreguntas();
        try{
            listaPreguntas = lector.recuperarPreguntas(ARCHIVOJSON);
        }catch (IOException e){
            e.getMessage();
        }
        iteradorPreguntas = listaPreguntas.listIterator();
        iteradorPreguntas.next();
    }

    public static Panel getInstancia(){
        return instancia;
    }

    /*public Panel(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fachadaCreadorPregunta = new CreadorDePreguntas();
    }

     */

    public Jugador ganadorAlgohoot(){
        if (listaJugadores.get(0).puntajeValorNumerico()> listaJugadores.get(1).puntajeValorNumerico()){
            return listaJugadores.get(0);
        }
        else return listaJugadores.get(1);
    }

    public void agregarJugador(Jugador jugador) {
        listaJugadores.add(jugador);
    }

    public Jugador obtenerJugador(int i) {
        return listaJugadores.get(i);
    }

    public Pregunta preguntaActual() {
        return listaPreguntas.get(iteradorPreguntas.previousIndex());
        //return CreadorDePreguntas.preguntaVoFClasico("2+2= 12392193","Falso");
    }

    public List<Jugador> obtenerJugadores(){
        return this.listaJugadores;
    }

    public Jugador jugadorActual() {
        return listaJugadores.get(iteradorJugadores.previousIndex());
    }

    public void cambiarJugador() {
        if ( tieneSiguienteJugador() ){
            iteradorJugadores.next();
        }else{
            iteradorJugadores = listaJugadores.listIterator();
            iteradorJugadores.next();
        }
    }

    public boolean tieneSiguienteJugador(){
        return iteradorJugadores.hasNext();
    }

    public void cambiarPregunta(){
        if(!iteradorPreguntas.hasNext()){
            iteradorPreguntas = listaPreguntas.listIterator();
        }else{
            iteradorPreguntas.next();
        }
    }

    public boolean tieneSiguientePregunta(){
        return iteradorPreguntas.hasNext();
    }

    public void agregarJugadores(List<Jugador> jugadores) {
        this.listaJugadores = jugadores;
        this.iteradorJugadores = jugadores.listIterator();
        iteradorJugadores.next();
    }
}
