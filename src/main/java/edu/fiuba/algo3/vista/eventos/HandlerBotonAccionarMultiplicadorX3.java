package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerBotonAccionarMultiplicadorX3 implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private Button botonComodin;

    public HandlerBotonAccionarMultiplicadorX3(Jugador unJugadorActual, Button unBotonComodin) {
        this.jugadorActual = unJugadorActual;
        this.botonComodin = unBotonComodin;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorActual.sacarComodin(new MultiplicadorX3());
        botonComodin.setDisable(true);
    }

}