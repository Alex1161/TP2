package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerSiguientePregunta implements EventHandler {

    public HandlerSiguientePregunta(){
    }

    @Override
    public void handle(Event event) {
        ControladorPrincipal.getInstancia().iniciarSiguientePregunta();
    }
}
