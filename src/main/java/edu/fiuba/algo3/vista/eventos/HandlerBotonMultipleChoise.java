package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.ControladorOpciones;
import javafx.scene.control.Button;

import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerBotonMultipleChoise implements EventHandler {

    ControladorOpciones controladorOpciones;
    private Juego panelJuego = Juego.getInstancia();
    Button btn;
    String opcion;

    public HandlerBotonMultipleChoise(String opcion, Button btn, ControladorOpciones controladorOpciones) {
        super();
        this.btn = btn;
        this.opcion=opcion;
        this.controladorOpciones = controladorOpciones;
    }


    @Override
    public void handle(Event event) {
        controladorOpciones.agregarOpcion(opcion);
        btn.setOnAction(new HandlerBotonMultipleChoiseDesSeleccionar(btn,opcion, controladorOpciones));
        btn.setText("Seleccionado: " + btn.getText());
    }
}
