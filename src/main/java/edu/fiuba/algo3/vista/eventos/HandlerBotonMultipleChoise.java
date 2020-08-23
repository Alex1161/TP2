package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import javafx.scene.control.Button;

import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerBotonMultipleChoise implements EventHandler {

    private Panel panelJuego = Panel.getInstancia();
    Button btn;
    String opcion;

    public HandlerBotonMultipleChoise(String opcion, Button btn) {
        super();
        this.btn = btn;
        this.opcion = opcion;

    }


    @Override
    public void handle(Event event) {
        panelJuego.agregarOpcion(opcion);
        btn.setOnAction(new HandlerBotonMultipleChoiseDesSeleccionar(btn, opcion));
        btn.setText("Seleccionado: " + btn.getText());
    }
}
