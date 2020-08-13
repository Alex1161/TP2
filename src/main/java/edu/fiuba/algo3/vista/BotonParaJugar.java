package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class BotonParaJugar extends Button {
    private static String DESCRIPCION = "Comenzar Juego";
    //private HandlerBotonParaJugar manejadorBoton;


    public BotonParaJugar(Stage ventana, Scene proximaEscena, VistaInfoJugadores unaVistaIngresoJugadores, Jugador j1, Jugador j2, TextField campoJug1, TextField campoJug2){
        super();
        setText(DESCRIPCION);
        setOnMouseClicked(new HandlerBotonParaJugar(ventana, proximaEscena,unaVistaIngresoJugadores, j1, j2, campoJug1, campoJug2));
    }

}
