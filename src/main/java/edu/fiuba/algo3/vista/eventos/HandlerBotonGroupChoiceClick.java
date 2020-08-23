package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.Controlador;
import edu.fiuba.algo3.vista.botones.BotonParaJugar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HandlerBotonGroupChoiceClick implements EventHandler<ActionEvent> {
    private Controlador controlador;
    HBox grupo1;
    HBox grupo2;
    HBox grupoActual;
    Button boton;
    public HandlerBotonGroupChoiceClick(Button btn, HBox grupo1, HBox grupo2) {
        this.grupo1=grupo1;
        this.grupo2=grupo2;

        boton=btn;
    }

    public HandlerBotonGroupChoiceClick(Button btn, HBox grupo1, HBox grupo2, Controlador controlador) {
        this.grupo1=grupo1;
        this.grupo2=grupo2;

        boton=btn;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent event) {
        if (grupoActual==grupo1){
            grupoActual=grupo2;
        }else{
            grupoActual=grupo1;
        }

        grupoActual.getChildren().add(boton);

    }
}
