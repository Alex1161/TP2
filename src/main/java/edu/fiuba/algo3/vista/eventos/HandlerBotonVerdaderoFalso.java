package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Panel;
import javafx.event.Event;
import javafx.event.EventHandler;


public class HandlerBotonVerdaderoFalso implements EventHandler {

    private Panel panelJuego = Panel.getInstancia();
    private String opcion;
    private ControladorPrincipal controlador = ControladorPrincipal.getInstancia();

    public HandlerBotonVerdaderoFalso(String opcion){
        this.opcion = opcion;
    }

    @Override
    public void handle(Event event) {

        panelJuego.agregarOpcion(opcion);
        if (!panelJuego.tieneSiguienteJugador()){
            panelJuego.calificar();
        }
        controlador.siguienteTurno();
    }
}
