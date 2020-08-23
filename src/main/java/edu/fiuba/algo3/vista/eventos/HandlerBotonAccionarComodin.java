package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Comodin.Comodin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HandlerBotonAccionarComodin implements EventHandler<ActionEvent> {

    private Button botonComodin;
    private Comodin comodinActual;
    VBox panelRelacionado;

    public HandlerBotonAccionarComodin(Button unBotonComodin, Comodin unComodinActual, VBox panelAccionesDiponiblesJugador) {
        this.botonComodin = unBotonComodin;
        this.comodinActual = unComodinActual;
        panelRelacionado = panelAccionesDiponiblesJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Panel panelJuego = Panel.getInstancia();
        panelJuego.aplicarComodin(comodinActual);   //Facil de refactorizar
        botonComodin.setText(botonComodin.getText()+": Selecionado");
        panelRelacionado.setDisable(true);
    }

}