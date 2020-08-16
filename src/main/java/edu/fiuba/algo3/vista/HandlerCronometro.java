package edu.fiuba.algo3.vista;

import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerCronometro implements EventHandler {

    VistaTemporizador vistaTemporizador;

    public HandlerCronometro(VistaTemporizador vista){
        vistaTemporizador = vista;
    }
    @Override
    public void handle(Event event) {
        vistaTemporizador.iniciarTempo();
    }


}
