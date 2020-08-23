package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Juego;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerBotonConfirmar implements EventHandler {

    private Juego panelJuego = Juego.getInstancia();
    private Button btn;
    private ControladorPrincipal controlador = ControladorPrincipal.getInstancia();

    public HandlerBotonConfirmar() {

    }

    @Override
    public void handle(Event event) {

        controlador.siguienteTurno();
    }
}
