package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.ActionListenerCronometro;
import edu.fiuba.algo3.vista.VistaTemporizador;
import javafx.geometry.Pos;
import edu.fiuba.algo3.VistaPuntajeJugador;

import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;


public class VistaPreguntaEnCurso{
    VistaPuntajeJugador vistaPuntajeParcial;
    VistaEnunciado vistaEnunciado;
    VistaVoF vistaVoF;
    VistaTemporizador vistaTemporizador;

    VBox panelDerecho;
    VBox panelIzquierdo;
    VBox panelCentral;
    HBox panelSuperior;
    VBox ventanaCompleta;

    Panel paneljuego = Panel.getInstancia();

    public VistaPreguntaEnCurso(Stage stage){


        //vistaInfoJugadores = new VistaInfoJugadores();

        //panelIzquierdo = vistaInfoJugadores.obtenerPanelInfoJugadores();

        vistaTemporizador = new VistaTemporizador();
        Cronometro cronometro = new Cronometro(new ActionListenerCronometro(vistaTemporizador));
        cronometro.start();

        panelDerecho = vistaTemporizador.obtenerPanelTemporizador();

        vistaEnunciado = new VistaEnunciado();

        panelCentral = vistaEnunciado.obtenerPanelEnunciado();

        panelSuperior = new HBox();
        panelSuperior.getChildren().addAll(/*panelIzquierdo*/ panelCentral, panelDerecho);
        panelSuperior.setSpacing(20);
        panelSuperior.setAlignment(Pos.CENTER);
        panelSuperior.setMinHeight(500);

        vistaPuntajeParcial = new VistaPuntajeJugador(Panel.getInstancia().obtenerJugador(0),Panel.getInstancia().obtenerJugador(1));
        vistaVoF = new VistaVoF(stage, vistaTemporizador, vistaPuntajeParcial);

        ventanaCompleta = new VBox();
        ventanaCompleta.getChildren().addAll(panelSuperior, vistaVoF.obtenerGrilla());
        ventanaCompleta.getStyleClass().add("fondo-general");

    }

    public VBox obtenerVista(){
        return ventanaCompleta;
    }

    public void actualizar(){
    }

}
