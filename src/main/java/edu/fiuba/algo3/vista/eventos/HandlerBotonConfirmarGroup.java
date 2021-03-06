package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.vista.ControladorOpciones;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class HandlerBotonConfirmarGroup implements EventHandler {


    private ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
    GridPane opcionesSinResponder;
    HBox grupo1;
    int elementosOptimos;
    private ControladorOpciones controladorOpciones;

    public HandlerBotonConfirmarGroup(GridPane grillaRespuestas, HBox grupo1, int elementosOptimos, ControladorOpciones controladorOpciones) {
        opcionesSinResponder=grillaRespuestas;
        this.grupo1=grupo1;
        this.elementosOptimos=elementosOptimos;
        this.controladorOpciones = controladorOpciones;
    }

    @Override
    public void handle(Event event) {
        if(opcionesSinResponder.getChildren().size() == elementosOptimos){
            for (Node unBoton: grupo1.getChildren()) {
                Button botonActual = (Button) unBoton;
                controladorOpciones.agregarOpcion(botonActual.getText());
            }
            controladorOpciones.pasarOpcionesElegidas();
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
