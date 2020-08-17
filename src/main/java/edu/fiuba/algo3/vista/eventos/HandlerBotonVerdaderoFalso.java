package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
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

public class HandlerBotonVerdaderoFalso implements EventHandler {
    private Stage ventana;
    private Scene escenaProxima;
    private VistaInfoJugadores vistaInfoJugadores;
    private Jugador jugador;
    private Pregunta pregunta;
    private Respuesta respuestaJugador1;
    private Button boton;
    private List<Respuesta> listaRespuestas;

    public HandlerBotonVerdaderoFalso(Button boton, Stage unaVentana, VistaInfoJugadores unaVistaInfoJugadores, Jugador unJugador, Pregunta pregunta){
        this.ventana = unaVentana;
        //this.escenaProxima = unaEscenaProxima;
        this.jugador = unJugador;
        this.vistaInfoJugadores = unaVistaInfoJugadores;
        this.pregunta = pregunta;
        this.boton = boton;

    }
    @Override
    public void handle(Event event) {
        respuestaJugador1 = new Respuesta(jugador);
        respuestaJugador1.agregarOpcion(boton.getText());
        listaRespuestas = new ArrayList<Respuesta>();
        listaRespuestas.add(respuestaJugador1);
        pregunta.calificar(listaRespuestas);
        vistaInfoJugadores.actualizar();
        ventana.setScene(escenaProxima);


    }

}
