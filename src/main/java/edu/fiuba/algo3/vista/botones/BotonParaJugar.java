package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.eventos.HandlerBotonParaJugar;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotonParaJugar extends Button {
    private static String DESCRIPCION = "Comenzar Juego";

    public BotonParaJugar(TextField campoJug1, TextField campoJug2, VBox cuadro){
        super();
        setText(DESCRIPCION);
        setOnMouseClicked(new HandlerBotonParaJugar(campoJug1, campoJug2, cuadro));
    }

}
