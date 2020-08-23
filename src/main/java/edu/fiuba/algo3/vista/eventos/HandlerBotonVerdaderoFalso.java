package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.ControladorOpciones;
import javafx.event.Event;
import javafx.event.EventHandler;


public class HandlerBotonVerdaderoFalso implements EventHandler {
    private ControladorOpciones controladorOpciones;
    private Juego panelJuego = Juego.getInstancia();
    private String opcion;

    public HandlerBotonVerdaderoFalso(String opcion, ControladorOpciones controladorOpciones){
        this.opcion = opcion;
        this.controladorOpciones = controladorOpciones;
    }

    @Override
    public void handle(Event event) {
        controladorOpciones.agregarOpcion(opcion);
        controladorOpciones.enviarRespuestas();
    }
}
