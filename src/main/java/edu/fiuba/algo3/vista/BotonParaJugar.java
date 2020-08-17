package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.eventos.HandlerBotonParaJugar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonParaJugar extends Button {
    private static String DESCRIPCION = "Comenzar Juego";
    //private HandlerBotonParaJugar manejadorBoton;


    public BotonParaJugar(Stage ventana, Scene proximaEscena, VistaInfoJugadores unaVistaIngresoJugadores, Jugador j1, Jugador j2, TextField campoJug1, TextField campoJug2, VBox cuadro){
        super();
        setText(DESCRIPCION);
        setOnMouseClicked(new HandlerBotonParaJugar(ventana, proximaEscena,unaVistaIngresoJugadores, j1, j2, campoJug1, campoJug2,cuadro));
    }

}
