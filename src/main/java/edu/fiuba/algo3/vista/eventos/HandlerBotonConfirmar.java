package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.vista.ControladorOpciones;
import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerBotonConfirmar implements EventHandler {

    private ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
    private ControladorOpciones controladorOpciones;

    public HandlerBotonConfirmar(ControladorOpciones controladorOpciones) {
        this.controladorOpciones = controladorOpciones;
    }

    @Override
    public void handle(Event event) {
        controladorOpciones.pasarOpcionesElegidas();
    }
}
