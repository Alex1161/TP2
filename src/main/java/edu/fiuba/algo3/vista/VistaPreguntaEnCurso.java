package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.Cronometro;
import edu.fiuba.algo3.vista.*;
import javafx.geometry.Pos;

import javafx.scene.layout.*;


public class VistaPreguntaEnCurso{
    VistaEnunciado vistaEnunciado;
    VistaOpciones vistaVoF;
    VistaAccionesJugador vistaAccionesJugador;

    VistaTemporizador vistaTemporizador;

    VBox panelDerecho;
    VBox panelIzquierdo;
    VBox panelCentral;
    HBox panelSuperior;
    VBox ventanaCompleta;

    public VistaPreguntaEnCurso(){

        vistaAccionesJugador = new VistaAccionesJugador();

        panelIzquierdo = vistaAccionesJugador.obtenerPanelInfoJugadores();

        vistaTemporizador = new VistaTemporizador();
        Cronometro cronometro = new Cronometro(new ActionListenerCronometro(vistaTemporizador));
        cronometro.start();

        panelDerecho = vistaTemporizador.obtenerPanelTemporizador();

        vistaEnunciado = new VistaEnunciado();

        panelCentral = vistaEnunciado.obtenerPanelEnunciado();

        panelSuperior = new HBox();
        panelSuperior.getChildren().addAll(panelIzquierdo, panelCentral, panelDerecho);
        panelSuperior.setSpacing(20);
        panelSuperior.setAlignment(Pos.CENTER);
        panelSuperior.setMinHeight(500);

        vistaVoF = new VistaOpciones();

        ventanaCompleta = new VBox();
        ventanaCompleta.getChildren().addAll(panelSuperior, vistaVoF.obtenerGrilla());
        ventanaCompleta.getStyleClass().add("fondo-general");

    }

    public VBox obtenerVista(){
        return ventanaCompleta;
    }


}
