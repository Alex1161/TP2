package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.AlgoHoot;
import edu.fiuba.algo3.StagePrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonRevancha implements EventHandler {

    Stage ventana = StagePrincipal.getInstance();

    @Override
    public void handle(Event event) {
        AlgoHoot juegoNuevo = new AlgoHoot();
        juegoNuevo.restart(ventana);
    }
}
