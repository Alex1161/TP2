package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
/*
public class Controlador {
    private TextField areaEnvioTf;
    VistaIngresoDeJugadores ventana;
    Panel panel;

    public void comienzo(Stage stage){
        this.ventana = new VistaIngresoDeJugadores(stage, this);
        this.panel = new Panel();
        this.ventana.comienzoDelJuego();
    }

    public void teclaEnter(TextField Texto, Label textoInfo){
        EventHandler<KeyEvent> input = new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent evento) {

                if (evento.getCode().equals(KeyCode.ENTER)) {
                    textoInfo.setText("Inserte nombre del segundo jugador y presione ENTER");
                    panel.agregarJugador(Texto.getText());
                    Texto.clear();

                }
                evento.consume();
            }
        };
        Texto.setOnKeyPressed(input);
    }


}

 */
