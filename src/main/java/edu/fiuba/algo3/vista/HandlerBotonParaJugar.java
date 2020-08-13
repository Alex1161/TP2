package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class HandlerBotonParaJugar implements EventHandler {

    private Stage ventana;
    private Scene escenaProxima;
    private VistaInfoJugadores vistaInfoJugadores;
    private Jugador jugador1;
    private  Jugador jugador2;
    private  TextField campoJugador1;
    private TextField campoJugador2;

    public HandlerBotonParaJugar(Stage unaVentana, Scene unaEscenaProxima, VistaInfoJugadores unaVistaInfoJugadores, Jugador unJugador1, Jugador unJugador2, TextField nombreJug1, TextField nombreJug2){
        this.ventana = unaVentana;
        this.escenaProxima = unaEscenaProxima;
        this.jugador1 = unJugador1;
        this.jugador2 = unJugador2;
        this.vistaInfoJugadores = unaVistaInfoJugadores;
        this.campoJugador1 = nombreJug1;
        this.campoJugador2 = nombreJug2;
    }
    @Override
    public void handle(Event event) {

        jugador1.setNombre(campoJugador1.getText());
        jugador2.setNombre(campoJugador2.getText());
        vistaInfoJugadores.actualizar();
        ventana.setScene(escenaProxima);

    }
}
