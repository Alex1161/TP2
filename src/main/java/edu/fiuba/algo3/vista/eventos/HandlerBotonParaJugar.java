package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    VBox cuadro;

    public HandlerBotonParaJugar(Stage unaVentana, Scene unaEscenaProxima, VistaInfoJugadores unaVistaInfoJugadores, Jugador unJugador1, Jugador unJugador2, TextField nombreJug1, TextField nombreJug2, VBox cuadro){
        this.ventana = unaVentana;
        this.escenaProxima = unaEscenaProxima;
        this.jugador1 = unJugador1;
        this.jugador2 = unJugador2;
        this.vistaInfoJugadores = unaVistaInfoJugadores;
        this.campoJugador1 = nombreJug1;
        this.campoJugador2 = nombreJug2;
        this.cuadro = cuadro;

    }
    @Override
    public void handle(Event event){
        if(campoJugador1.getText().isEmpty() || campoJugador2.getText().isEmpty()){
            Label textoInfoError = new Label();
            textoInfoError.setText("Nombre de Usuario Incorrecto");
            textoInfoError.setTextFill(Color.RED);
            cuadro.getChildren().addAll(textoInfoError);

        }else {
            jugador1.setNombre(campoJugador1.getText());
            jugador2.setNombre(campoJugador2.getText());
            vistaInfoJugadores.actualizar();
            ventana.setScene(escenaProxima);
        }

    }
}
