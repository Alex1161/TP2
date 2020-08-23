package edu.fiuba.algo3.vista.eventos;

import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerBotonSalir implements EventHandler {


    @Override
    public void handle(Event event) {
        System.exit(0);
    }

}
