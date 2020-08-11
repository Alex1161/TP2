package edu.fiuba.algo3.vista;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HandlerBotonParaJugar implements EventHandler {

    private Stage ventana;
    private Scene escenaProxima;

    public HandlerBotonParaJugar(Stage unaVentana, Scene unaEscenaProxima){
        this.ventana = unaVentana;
        this.escenaProxima = unaEscenaProxima;
    }
    @Override
    public void handle(Event event) {
        ventana.setScene(escenaProxima);
    }
}
