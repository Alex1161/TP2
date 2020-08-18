package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.LectorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Panel {
    private static Panel instancia = new Panel();
    private final CreadorDePreguntas fachadaCreadorPregunta;
    private List<Jugador> listaJugadores = new ArrayList<Jugador>();
    private static String ARCHIVOJSON = "Preguntas.json";
    LectorDePreguntas lectorJson = new LectorDePreguntas();
    List<Pregunta> listaPreguntas = new ArrayList<>();


    private Panel(){
        this.fachadaCreadorPregunta = new CreadorDePreguntas();
    }

    public static Panel getInstancia(){
        return instancia;
    }

    /*public Panel(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fachadaCreadorPregunta = new CreadorDePreguntas();
    }

    public Jugador ganadorAlgohoot(){
        if (jugador1.puntajeValorNumerico() > jugador2.puntajeValorNumerico()){
            return jugador1;
        }
        else return jugador2;
    }
     */

    public void cargarPreguntas() throws IOException {
        listaPreguntas = lectorJson.recuperarPreguntas(ARCHIVOJSON);
    }


    public void agregarJugador(Jugador jugador) {
        listaJugadores.add(jugador);

    }

    public Jugador obtenerJugador(int i) {
        return listaJugadores.get(i);
    }

    public Pregunta preguntaActual() {
        return listaPreguntas.get(1);
        //return CreadorDePreguntas.preguntaVoFClasico("2+2= 12392193","Falso");
    }

    public Jugador jugadorActual() {
        return listaJugadores.get(0);
    }
}
