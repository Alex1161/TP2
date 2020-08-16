package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.ActionListenerCronometro;
import edu.fiuba.algo3.vista.HandlerCronometro;
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
    VistaEnunciado vistaEnunciado;
    VistaGrillaRespuestas vistaGrillaRespuestas;
    VistaInfoJugadores vistaInfoJugadores;
    VistaTemporizador vistaTemporizador;
    VBox panelDerecho;
    VBox panelIzquierdo;
    VBox panelCentral;
    HBox panelSuperior;
    VBox ventanaCompleta;

    Jugador jugador1;
    Jugador jugador2;

    public VistaPreguntaEnCurso(Jugador unJugador1, Jugador unJugador2){
        jugador1 = unJugador1;
        jugador2 = unJugador2;

        vistaInfoJugadores = new VistaInfoJugadores(jugador1, jugador2);

        panelIzquierdo = vistaInfoJugadores.obtenerPanelInfoJugadores();

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

        vistaGrillaRespuestas = new VistaGrillaRespuestas(vistaTemporizador);

        ventanaCompleta = new VBox();
        ventanaCompleta.getChildren().addAll(panelSuperior, vistaGrillaRespuestas.obtenerGrilla());
        ventanaCompleta.getStyleClass().add("fondo-general");

    }

    public VBox obtenerVista(){
        return ventanaCompleta;
    }

    public VistaInfoJugadores obtenerVistaInfoJugadores(){
        return this.vistaInfoJugadores;
    }

}
