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
    int iterador;
    int iteradorPregunta;

    private Panel(){
        this.fachadaCreadorPregunta = new CreadorDePreguntas();
        iterador = 1;
        iteradorPregunta = 0;
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
        return listaPreguntas.get(iteradorPregunta);
        //return CreadorDePreguntas.preguntaVoFClasico("2+2= 12392193","Falso");
    }

    public List<Jugador> obtenerJugadores(){
        return this.listaJugadores;
    }

    public Jugador jugadorActual() {
        return listaJugadores.get(iterador);
    }

    public void cambiarJugador() {
        if (  iterador == 0){
            iterador = 1;
        }else{
            iterador = 0;
        }
    }

    public boolean tieneSiguienteJugador(){
        if(iterador == 1){
            return false;
        }else{
            return true;
        }
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

}
