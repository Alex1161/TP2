package edu.fiuba.algo3;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaEnunciado {

    VBox panelEnunciado;

    public VistaEnunciado(){
        panelEnunciado = new VBox();

        panelEnunciado.setPrefSize(400,100);
        Label enunciadoTxt = new Label("Quien fue el primer hombre que se comio una hamburguesa con queso?");
        enunciadoTxt.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        enunciadoTxt.setMaxWidth(800);
        enunciadoTxt.setWrapText(true);
        enunciadoTxt.setAlignment(Pos.CENTER);
        enunciadoTxt.getStyleClass().add("enunciado-text");
        panelEnunciado.getChildren().addAll(enunciadoTxt);
        panelEnunciado.setAlignment(Pos.CENTER);
        panelEnunciado.getStyleClass().add("enunciado-style");

    }

    public VBox obtenerPanelEnunciado(){
        return panelEnunciado;
    }
}
