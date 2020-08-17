package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.VistaPreguntaEnCurso;
import edu.fiuba.algo3.VistaVoF;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.AlgoHoot.ALTO;
import static edu.fiuba.algo3.AlgoHoot.ANCHO;

public class HandlerBotonVerdaderoFalso implements EventHandler {
    private Stage ventana;
    private Scene escenaProxima;
    private VistaInfoJugadores vistaInfoJugadores;
    private Panel panelDeJuego;
    private Jugador jugador;
    private Pregunta pregunta;
    private Respuesta respuestaJugador;
    private Button boton;
    private List<Respuesta> listaRespuestas;

    public HandlerBotonVerdaderoFalso(Button boton, Stage unaVentana, VistaInfoJugadores unaVistaInfoJugadores, Panel unPanelDeJuego, Jugador unJugador, Pregunta pregunta){
        this.ventana = unaVentana;
        this.panelDeJuego = unPanelDeJuego;
        this.jugador = unJugador;
        this.vistaInfoJugadores = unaVistaInfoJugadores;
        this.pregunta = pregunta;
        this.boton = boton;

    }
    @Override
    public void handle(Event event) {
        if(jugador == null){
            vistaInfoJugadores.actualizar();
            //escenaProxima = new VistaPuntajesParciales(jugador1, jugador2);
            ventana.setScene(escenaProxima);
            //pasar a escena de puntajes parciales.
        }
        else{
            //VistaPreguntaEnCurso preguntaEnCurso = new VistaPreguntaEnCurso(ventana, panelDeJuego, panelDeJuego.comenzarPregunta(), panelDeJuego.getJugador2());
            //escenaProxima = new Scene(preguntaEnCurso.obtenerVista(), ANCHO, ALTO);

            respuestaJugador = new Respuesta(jugador);
            respuestaJugador.agregarOpcion(boton.getText());
            listaRespuestas = new ArrayList<Respuesta>();
            listaRespuestas.add(respuestaJugador);
            pregunta.calificar(listaRespuestas);
            vistaInfoJugadores.actualizar();

            ventana.setScene(escenaProxima);
        }
    }

}
