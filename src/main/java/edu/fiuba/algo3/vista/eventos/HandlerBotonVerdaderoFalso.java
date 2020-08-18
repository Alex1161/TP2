package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
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
    private Respuesta respuestaJugador1;
    private Button boton;
    private List<Respuesta> listaRespuestas;
    private Panel panelJuego = Panel.getInstancia();

    public HandlerBotonVerdaderoFalso(Button boton, Stage unaVentana, VistaInfoJugadores unaVistaInfoJugadores){
        this.ventana = unaVentana;
        //this.escenaProxima = unaEscenaProxima;
        this.vistaInfoJugadores = unaVistaInfoJugadores;

        this.boton = boton;

    }
    @Override
    public void handle(Event event) {
        respuestaJugador1 = new Respuesta(panelJuego.jugadorActual());
        respuestaJugador1.agregarOpcion(boton.getText());
        listaRespuestas = new ArrayList<Respuesta>();
        listaRespuestas.add(respuestaJugador1);
        panelJuego.preguntaActual().calificar(listaRespuestas);
        vistaInfoJugadores.actualizar();
        ventana.setScene(escenaProxima);
    }

}
