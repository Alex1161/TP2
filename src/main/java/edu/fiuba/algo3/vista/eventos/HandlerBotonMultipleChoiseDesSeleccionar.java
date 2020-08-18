package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.eventos.HandlerBotonMultipleChoise;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class HandlerBotonMultipleChoiseDesSeleccionar implements EventHandler{

    Button btn;
    String texto;
    public HandlerBotonMultipleChoiseDesSeleccionar(Button btn) {
        this.btn = btn;
        this.texto = btn.getText();
    }


    @Override
    public void handle(Event event) {
        btn.setText(texto);
        btn.setOnAction(new HandlerBotonMultipleChoise(texto, btn));
    }
}
