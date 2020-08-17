package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.ActionListenerCronometro;
import edu.fiuba.algo3.vista.VistaTemporizador;
import javafx.geometry.Pos;

import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;


public class VistaPreguntaEnCurso{
    VistaEnunciado vistaEnunciado;
    VistaVoF vistaVoF;
    VistaInfoJugadores vistaInfoJugadores;
    VistaTemporizador vistaTemporizador;
    VBox panelDerecho;
    VBox panelIzquierdo;
    VBox panelCentral;
    HBox panelSuperior;
    VBox ventanaCompleta;

    public VistaPreguntaEnCurso(Stage stage, Panel unPanelJuego, Pregunta preguntaActual, Jugador jugadorActual){

        vistaInfoJugadores = new VistaInfoJugadores(unPanelJuego.getJugador1(), unPanelJuego.getJugador2());

        panelIzquierdo = vistaInfoJugadores.obtenerPanelInfoJugadores();

        vistaTemporizador = new VistaTemporizador();
        Cronometro cronometro = new Cronometro(new ActionListenerCronometro(vistaTemporizador));
        cronometro.start();

        panelDerecho = vistaTemporizador.obtenerPanelTemporizador();

        vistaEnunciado = new VistaEnunciado(preguntaActual);

        panelCentral = vistaEnunciado.obtenerPanelEnunciado();

        panelSuperior = new HBox();
        panelSuperior.getChildren().addAll(panelIzquierdo, panelCentral, panelDerecho);
        panelSuperior.setSpacing(20);
        panelSuperior.setAlignment(Pos.CENTER);
        panelSuperior.setMinHeight(500);

        vistaVoF = new VistaVoF(stage, vistaTemporizador, preguntaActual, vistaInfoJugadores, unPanelJuego, jugadorActual);

        ventanaCompleta = new VBox();

        //obtener Vista
        ventanaCompleta.getChildren().addAll(panelSuperior, vistaVoF.obtenerGrilla());
        ventanaCompleta.getStyleClass().add("fondo-general");

    }

    public VBox obtenerVista(){
        return ventanaCompleta;
    }

    public VistaInfoJugadores obtenerVistaInfoJugadores(){
        return this.vistaInfoJugadores;
    }

}
