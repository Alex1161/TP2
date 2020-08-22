package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.vista.botones.BotonParaJugar;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Collection;


public class HandlerBotonConfirmarGroup implements EventHandler {

    private Panel panelJuego = Panel.getInstancia();
    private ControladorPrincipal controlador = ControladorPrincipal.getInstancia();
    GridPane opcionesSinResponder;
    HBox grupo1;

    public HandlerBotonConfirmarGroup(GridPane grillaRespuestas, HBox grupo1) {
    opcionesSinResponder=grillaRespuestas;
    this.grupo1=grupo1;
    }

    @Override
    public void handle(Event event) {
        if(opcionesSinResponder.getChildren().size()==5){
            for (Node unBoton: grupo1.getChildren()) {
                Button botonActual = (Button) unBoton;
                panelJuego.agregarOpcion(botonActual.getText());
            }
            controlador.siguienteTurno();
        }else{
            Stage dialog=new Stage();

            Button botonSalir = new Button("Selecione Todas Las OPCIONES");
            botonSalir.setPrefSize(500,80);
            HandlerCerrarVentana manejadorSalir = new HandlerCerrarVentana(dialog);
            botonSalir.setOnAction(manejadorSalir);
            Scene scene= new Scene(new Group(botonSalir));
            dialog.setScene(scene);
            dialog.show();
        }
    }
}
