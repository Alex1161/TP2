package edu.fiuba.algo3;
import edu.fiuba.algo3.vista.VistaTemporizador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;





public class VistaPreguntaEnCurso{
    //private static String URL_FONDO_PREGUNTA = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoDegradadoNaranjaPrueba.png";
    VistaEnunciado vistaEnunciado;
    VistaGrillaRespuestas vistaGrillaRespuestas;
    VistaInfoJugadores vistaInfoJugadores;
    VistaTemporizador vistaTemporizador;
    VBox panelDerecho;
    VBox panelIzquierdo;
    VBox panelCentral;
    HBox panelSuperior;
    VBox ventanaCompleta;

    public VistaPreguntaEnCurso(/*Pregunta pregunta*/){
        super();

        vistaInfoJugadores = new VistaInfoJugadores();

        panelIzquierdo = vistaInfoJugadores.obtenerPanelInfoJugadores();

        vistaTemporizador = new VistaTemporizador();

        panelDerecho = vistaTemporizador.obtenerPanelTemporizador();

        vistaEnunciado = new VistaEnunciado();

        panelCentral = vistaEnunciado.obtenerPanelEnunciado();

        panelSuperior = new HBox();
        panelSuperior.getChildren().addAll(panelIzquierdo, panelCentral, panelDerecho);
        panelSuperior.setSpacing(20);
        panelSuperior.setAlignment(Pos.CENTER);
        panelSuperior.setMinHeight(500);

        vistaGrillaRespuestas = new VistaGrillaRespuestas();

        ventanaCompleta = new VBox();
        ventanaCompleta.getChildren().addAll(panelSuperior, vistaGrillaRespuestas.obtenerGrilla());
        ventanaCompleta.getStyleClass().add("fondo-general");



        /*
        BackgroundSize bSize =
                new BackgroundSize(600,
                        800,
                        false,
                        false,
                        true, false);*/

    }

    public VBox obtenerVista(){
        return ventanaCompleta;
    }

}
