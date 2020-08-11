package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaTemporizador {

    VBox contenedorTemporizador;

    Label tiempoRestanteTxt;
    public VistaTemporizador(){
        contenedorTemporizador = new VBox();
        int tiempoRestante = 60;
        contenedorTemporizador.setSpacing(20);
        Label tiempoLbl = new Label("Tiempo");
        tiempoRestanteTxt = new Label(String.valueOf(tiempoRestante));

        tiempoLbl.getStyleClass().add("otros-text");
        contenedorTemporizador.getStyleClass().add("otros-text");
        contenedorTemporizador.getChildren().addAll(tiempoLbl, tiempoRestanteTxt);
        contenedorTemporizador.setAlignment(Pos.CENTER);
    }

    public VBox obtenerPanelTemporizador(){
        return contenedorTemporizador;
    }
}
