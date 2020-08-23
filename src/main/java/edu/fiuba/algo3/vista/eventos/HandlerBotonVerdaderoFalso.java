package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.vista.Controlador;
import javafx.event.Event;
import javafx.event.EventHandler;


public class HandlerBotonVerdaderoFalso implements EventHandler {
    private Controlador controlador;
    private Juego panelJuego = Juego.getInstancia();
    private String opcion;
    private ControladorPrincipal controlador = ControladorPrincipal.getInstancia();

    public HandlerBotonVerdaderoFalso(String opcion, Controlador controlador){
        this.opcion = opcion;
        this.controlador = controlador;
    }

    @Override
    public void handle(Event event) {
        controlador.agregarOpcion(opcion);
        controlador.enviarRespuestas();
    }
}
