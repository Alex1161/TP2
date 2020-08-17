package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.VistaTemporizador;
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
