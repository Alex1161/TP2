package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.vista.eventos.HandlerBotonVerdaderoFalso;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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

        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso(opcion);
            btn.setOnAction(botonVoF);
            grillaRespuestas.add(btn, 1, i);
            i++;
        }

    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }
}
