package edu.fiuba.algo3.vista;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonParaJugar extends Button {
    private static String DESCRIPCION = "Comenzar Juego";
    private HandlerBotonParaJugar manejadorBoton;


    public BotonParaJugar(Stage ventana, Scene proximaEscena){
        super();
        setText(DESCRIPCION);
        setOnMouseClicked(new HandlerBotonParaJugar(ventana, proximaEscena));
    }

}
