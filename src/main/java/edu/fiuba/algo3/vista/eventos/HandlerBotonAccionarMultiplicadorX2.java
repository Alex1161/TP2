package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerBotonAccionarMultiplicadorX2 implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private Button botonComodin;

    public HandlerBotonAccionarMultiplicadorX2(Jugador unJugadorActual, Button unBotonComodin) {
        this.jugadorActual = unJugadorActual;
        this.botonComodin = unBotonComodin;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorActual.sacarComodin(new MultiplicadorX2());
        botonComodin.setDisable(true);
    }

}
