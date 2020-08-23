package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.ControladorOpciones;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class HandlerBotonMultipleChoiseDesSeleccionar implements EventHandler{
    private ControladorOpciones controladorOpciones;
    private Juego panelJuego = Juego.getInstancia();
    Button btn;
    String opcion;

    public HandlerBotonMultipleChoiseDesSeleccionar(Button btn,String opcion) {
        this.btn = btn;
        this.opcion = opcion;

    }

    public HandlerBotonMultipleChoiseDesSeleccionar(Button btn, String opcion, ControladorOpciones controladorOpciones) {
        this.btn = btn;
        this.opcion= opcion;
        this.controladorOpciones = controladorOpciones;
    }

    @Override
    public void handle(Event event) {
        btn.setText(opcion);
        btn.setOnAction(new HandlerBotonMultipleChoise(opcion, btn, controladorOpciones));
        controladorOpciones.quitarOpcion(opcion);
    }
}
