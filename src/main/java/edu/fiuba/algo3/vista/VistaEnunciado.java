package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaEnunciado {

    VBox panelEnunciado;
    Label enunciadoTxt;
    Label tipoTxt;
    Juego panelJuego = Juego.getInstancia();

    public VistaEnunciado(){
        panelEnunciado = new VBox();

        panelEnunciado.setPrefSize(400,100);
        enunciadoTxt = new Label(panelJuego.preguntaActual().getEnunciado());
        enunciadoTxt.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        enunciadoTxt.setMaxWidth(800);
        enunciadoTxt.setWrapText(true);
        enunciadoTxt.setAlignment(Pos.CENTER);
        enunciadoTxt.getStyleClass().add("enunciado-text");

        tipoTxt = new Label(panelJuego.preguntaActual().getTipo());
        tipoTxt.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        tipoTxt.setMaxWidth(800);
        tipoTxt.setWrapText(true);
        tipoTxt.setAlignment(Pos.TOP_CENTER);
        tipoTxt.getStyleClass().add("enunciado-text");

        panelEnunciado.getChildren().addAll(tipoTxt,enunciadoTxt);

        panelEnunciado.setAlignment(Pos.CENTER);
        panelEnunciado.getStyleClass().add("enunciado-style");

    }

    public VBox obtenerPanelEnunciado(){
        return panelEnunciado;
    }
}
