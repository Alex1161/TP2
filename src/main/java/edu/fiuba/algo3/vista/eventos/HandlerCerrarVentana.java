package edu.fiuba.algo3.vista.eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerCerrarVentana  implements EventHandler {
    Stage ventana;
    public HandlerCerrarVentana(Stage ventana) {
        this.ventana=ventana;
    }

    @Override
    public void handle(Event event) {
        ventana.close();
    }
}
