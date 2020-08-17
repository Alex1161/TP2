package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.LectorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Panel {
    private static String ARCHIVO_JSON = "preguntas.json";

    Jugador jugador1;
    Jugador jugador2;
    List<Pregunta> preguntasJuego;

    LectorDePreguntas lectorJson = new LectorDePreguntas();

    public Panel(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void cargarPreguntas() throws IOException {
        preguntasJuego =  lectorJson.recuperarPreguntas(ARCHIVO_JSON);
    }

    public Jugador darGanador(){
        if (jugador1.puntajeValorNumerico()>jugador2.puntajeValorNumerico()){
            return jugador1;
        }
        else return jugador2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2(){
        return jugador2;
    }

    //Crear un iterador para ir pasando las preguntas
    public Pregunta comenzarPregunta() {
        return preguntasJuego.get(0);
    }

}
