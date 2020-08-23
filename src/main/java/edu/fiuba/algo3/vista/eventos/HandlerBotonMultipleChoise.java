package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.vista.Controlador;
import javafx.scene.control.Button;

import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerBotonMultipleChoise implements EventHandler {

    Controlador controlador;
    private Juego panelJuego = Juego.getInstancia();
    Button btn;
    String opcion;

    public HandlerBotonMultipleChoise(String opcion, Button btn, Controlador controlador) {
        super();
        this.btn = btn;
        this.opcion=opcion;
        this.controlador = controlador;
    }


    @Override
    public void handle(Event event) {
        controlador.agregarOpcion(opcion);
        btn.setOnAction(new HandlerBotonMultipleChoiseDesSeleccionar(btn,opcion));
        btn.setText("Seleccionado: " + btn.getText());
    }
}
