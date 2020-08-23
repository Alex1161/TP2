package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ControladorOpciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HandlerBotonOrderedChoiceClick implements EventHandler<ActionEvent> {
    private ControladorOpciones controladorOpciones;
    GridPane grupo2;
    HBox grupo1;
    Pane grupoActual;
    Button boton;
    public HandlerBotonOrderedChoiceClick(Button btn, HBox grupoOrdenado, GridPane grillaRespuestas) {
        this.grupo1=grupoOrdenado;
        this.grupo2=grillaRespuestas;
        grupoActual=grillaRespuestas;

        boton=btn;
    }

    public HandlerBotonOrderedChoiceClick(Button btn, HBox grupoOrdenado, GridPane grillaRespuestas, ControladorOpciones controladorOpciones) {
        this.grupo1=grupoOrdenado;
        this.grupo2=grillaRespuestas;
        grupoActual=grillaRespuestas;

        boton=btn;
        this.controladorOpciones = controladorOpciones;
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

