package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerBotonAccionarComodin implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private Button botonComodin;
    private Comodin comodinActual;

    public HandlerBotonAccionarComodin(Jugador unJugadorActual, Button unBotonComodin, Comodin unComodinActual) {
        this.jugadorActual = unJugadorActual;
        this.botonComodin = unBotonComodin;
        this.comodinActual = unComodinActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorActual.sacarComodin(comodinActual);
        botonComodin.setDisable(true);
        //Agregar al handler, De que forma le aplica el comodin a la pregunta.
    }

}