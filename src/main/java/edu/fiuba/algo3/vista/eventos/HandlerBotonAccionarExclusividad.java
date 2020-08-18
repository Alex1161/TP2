package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerBotonAccionarExclusividad implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private Button botonComodin;

    public HandlerBotonAccionarExclusividad(Jugador unJugadorActual, Button unBotonComodin) {
        this.jugadorActual = unJugadorActual;
        this.botonComodin = unBotonComodin;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorActual.sacarComodin(new Exclusividad());
        botonComodin.setDisable(true);
    }

}