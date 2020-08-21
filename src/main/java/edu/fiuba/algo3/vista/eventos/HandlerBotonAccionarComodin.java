package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HandlerBotonAccionarComodin implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private Button botonComodin;
    private Comodin comodinActual;
    VBox panelRelacionado;

    public HandlerBotonAccionarComodin(Button unBotonComodin, Comodin unComodinActual, VBox panelAccionesDiponiblesJugador) {
        this.botonComodin = unBotonComodin;
        this.comodinActual = unComodinActual;
        panelRelacionado=panelAccionesDiponiblesJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Panel panelJuego = Panel.getInstancia();
        panelJuego.aplicarComodin(comodinActual);
        botonComodin.setText(botonComodin.getText()+":Selecionado");
        panelRelacionado.setDisable(true);
        //Agregar al handler, De que forma le aplica el comodin a la pregunta.
    }

}