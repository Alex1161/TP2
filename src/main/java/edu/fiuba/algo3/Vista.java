package edu.fiuba.algo3;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista {

    Stage ventana;
    Controlador controlador;
    Scene IngresoNombres, Juego;

    public Vista(Stage stage, Controlador controlador){
        this.ventana = stage;
        this.controlador = controlador;
        stage.setTitle("algoHoot");
    }

    public void comienzoDelJuego(){

        VBox cuadro = new VBox();
        BorderPane layoutInicial = new BorderPane();

        Label textoInfo = new Label("Ingrese el nombre del primer jugador e ingrese 'ENTER' ");
        TextField textField = new TextField();

        cuadro.getChildren().add(textoInfo);
        cuadro.getChildren().add(textField);

        layoutInicial.setCenter(cuadro);


        controlador.teclaEnter(textField, textoInfo);

        IngresoNombres = new Scene(layoutInicial, 1024, 768);

        this.ventana.setScene(IngresoNombres);
        this.ventana.show();
    }
    //public String mostrarJugador();
}
