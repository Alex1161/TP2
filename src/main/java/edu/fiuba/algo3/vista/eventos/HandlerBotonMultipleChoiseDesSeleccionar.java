package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class HandlerBotonMultipleChoiseDesSeleccionar implements EventHandler{
    private Panel panelJuego = Panel.getInstancia();
    Button btn;
    String opcion;
    public HandlerBotonMultipleChoiseDesSeleccionar(Button btn,String opcion) {
        this.btn = btn;
        this.opcion = opcion;

    }


    @Override
    public void handle(Event event) {
        btn.setText(opcion);
        btn.setOnAction(new HandlerBotonMultipleChoise(opcion, btn));
        panelJuego.quitarOpcion(opcion);
    }
}
