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

    Jugador jugador1;
    Jugador jugador2;

    public VistaPreguntaEnCurso(Stage stage, Jugador unJugador1, Jugador unJugador2, Pregunta preguntaActual){
        jugador1 = unJugador1;
        jugador2 = unJugador2;

        vistaInfoJugadores = new VistaInfoJugadores(jugador1, jugador2);

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

        vistaVoF = new VistaVoF(stage,vistaTemporizador,preguntaActual,vistaInfoJugadores,jugador1);

        ventanaCompleta = new VBox();
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
