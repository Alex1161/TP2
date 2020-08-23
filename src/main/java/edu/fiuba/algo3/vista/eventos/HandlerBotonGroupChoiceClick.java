package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HandlerBotonGroupChoiceClick implements EventHandler<ActionEvent> {
    HBox grupo1;
    HBox grupo2;
    HBox grupoActual;
    Button boton;
    public HandlerBotonGroupChoiceClick(Button btn, HBox grupo1, HBox grupo2) {
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;

        boton=btn;
    }

    @Override
    public void handle(ActionEvent event) {
        if (grupoActual == grupo1){
            grupoActual = grupo2;
        }else{
            grupoActual = grupo1;
        }

        grupoActual.getChildren().add(boton);

    }
}
