package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Panel;
//import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.VistaPuntajeJugador;
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

import static edu.fiuba.algo3.AlgoHoot.ALTO;
import static edu.fiuba.algo3.AlgoHoot.ANCHO;

public class HandlerBotonVerdaderoFalso implements EventHandler {

    private Respuesta respuestaJugador1;
    private List<Respuesta> listaRespuestas;
    private Panel panelJuego = Panel.getInstancia();
    private String opcion;
    private ControladorPrincipal controlador = ControladorPrincipal.getInstancia();

    public HandlerBotonVerdaderoFalso(String opcion){
        this.opcion = opcion;
    }

    @Override
    public void handle(Event event) {

        respuestaJugador1 = new Respuesta(panelJuego.jugadorActual());
        respuestaJugador1.agregarOpcion(opcion);
        listaRespuestas = new ArrayList<Respuesta>();
        /* Si hay jugador siguiente turno, sino calificar y siguiente pregunta!!!

         */
        listaRespuestas.add(respuestaJugador1);
        panelJuego.preguntaActual().calificar(listaRespuestas);
        controlador.siguienteTurno();

    }

}
