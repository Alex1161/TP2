package edu.fiuba.algo3.vista.eventos;

import javafx.scene.control.Button;

import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerBotonMultipleChoise implements EventHandler {

    Button btn;

    public HandlerBotonMultipleChoise(String opcion, Button btn) {
        super();
        this.btn = btn;
    }


    @Override
    public void handle(Event event) {
        //btn.getStyleClass().add("buttonPressed");
        btn.setOnAction(new HandlerBotonMultipleChoiseDesSeleccionar(btn));
        btn.setText("Seleccionado");
    }
}
