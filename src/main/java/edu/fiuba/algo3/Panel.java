package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.LectorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuestas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Panel {

    private static Panel instancia = new Panel();
    private static String ARCHIVOJSON = "prueba.json";

    LectorDePreguntas lectorJson = new LectorDePreguntas();
    List<Pregunta> listaPreguntas = new ArrayList<>();

    int iteradorPregunta;

    private Respuestas respuestas=new Respuestas();

    private Panel(){
        iteradorPregunta = 0;
    }

    public static Panel getInstancia(){
        return instancia;
    }

    public Jugador ganadorAlgohoot() {
        List<Jugador> Jugadores = respuestas.obtenerJugadores();
        if (Jugadores.get(0).puntajeValorNumerico() > Jugadores.get(1).puntajeValorNumerico()) {
            return Jugadores.get(0);
        }
        if ((Jugadores.get(0).puntajeValorNumerico() == Jugadores.get(1).puntajeValorNumerico())) {
            return new Jugador("Empate");
        } else {
            return Jugadores.get(1);
        }
    }

    public void cargarPreguntas() throws IOException {
        listaPreguntas = lectorJson.recuperarPreguntas(ARCHIVOJSON);
    }

    public void agregarJugador(Jugador jugador) {
        respuestas.agregarJugador(jugador);


    }

    public Jugador obtenerJugador(int i) {
        return respuestas.obtenerJugador(i);
    }

    public Pregunta preguntaActual() {
        return listaPreguntas.get(iteradorPregunta);
   }

    public List<Jugador> obtenerJugadores(){
        return respuestas.obtenerJugadores();
    }

    public void cambiarJugador() {
        respuestas.cambiarJugador();

    }

    public boolean tieneSiguienteJugador(){
        return respuestas.tieneSiguienteJugador();

    }

    public void cambiarPregunta(){
        if(iteradorPregunta + 1 >= listaPreguntas.size()){
            iteradorPregunta = 0;
        }else{
            iteradorPregunta ++;
        }
    }

    public boolean tieneSiguientePregunta(){
        if ((iteradorPregunta + 1) >= listaPreguntas.size()){
            return false;
        }else{
            return true;
        }
    }

    public void agregarOpcion(String opcion){
        respuestas.obtenerRespuestaActual().agregarOpcion(opcion);
    }

    public Jugador jugadorActual() {
        return respuestas.obtenerJugadorActual();
    }

    public void calificar() {
        this.preguntaActual().calificar(respuestas.obtenerRespuestas());
        this.respuestas.limpiar();
    }

    public void quitarOpcion(String opcion) {
        this.respuestas.obtenerRespuestaActual().quitarOpcion(opcion);
    }

    public void limpiar(){
        instancia = new Panel();
        ARCHIVOJSON = "prueba.json";

        lectorJson = new LectorDePreguntas();
        listaPreguntas = new ArrayList<>();

        respuestas=new Respuestas();
        iteradorPregunta = 0;
    }
}
