package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.vista.eventos.HandlerBotonVerdaderoFalso;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class VistaOpciones {

    private Panel panel = Panel.getInstancia();
    GridPane grillaRespuestas;

    public VistaOpciones(){

        grillaRespuestas = new GridPane();
        grillaRespuestas.setPadding(new Insets(5, 5, 5, 5));
        int i = 0;
        grillaRespuestas.setVgap(5);
        grillaRespuestas.setHgap(5);
        grillaRespuestas.setAlignment(Pos.CENTER);
        List<Button> listaBotones = new ArrayList<Button>();
        VBox botones1 = new VBox();
        VBox botones2 = new VBox();


        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso(opcion);
            btn.setOnAction(botonVoF);
            listaBotones.add(btn);
            i++;

        }
        for (int posicionBoton = 0; posicionBoton < listaBotones.size(); posicionBoton++) {
            if (posicionBoton % 2 != 1) {
                botones1.getChildren().add(listaBotones.get(posicionBoton));
            } else {
                botones2.getChildren().add(listaBotones.get(posicionBoton));
            }

        }
        grillaRespuestas.add(botones1, 1, 0);
        grillaRespuestas.add(botones2, 2, 0);
        grillaRespuestas.setPadding(new Insets(10,10,10,10));

    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }
}
