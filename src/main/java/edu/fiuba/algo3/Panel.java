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
    private final CreadorDePreguntas fachadaCreadorPregunta;
    Jugador jugador1;
    Jugador jugador2;
    private static String ARCHIVOJSON = "Preguntas.json";
    LectorDePreguntas lectorJson = new LectorDePreguntas();

    public Panel(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fachadaCreadorPregunta = new CreadorDePreguntas();
    }

    public Jugador ganadorKahoot(){
        if (jugador1.puntajeValorNumerico()>jugador2.puntajeValorNumerico()){
            return jugador1;
        }
        else return jugador2;
    }

    public List<Pregunta> cargarPreguntas() throws IOException {
        return lectorJson.recuperarPreguntas(ARCHIVOJSON);
    }

}
