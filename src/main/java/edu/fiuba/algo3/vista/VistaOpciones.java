package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.VistaInfoJugadores;
import edu.fiuba.algo3.vista.eventos.HandlerBotonVerdaderoFalso;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso();
            btn.setOnAction(botonVoF);
            grillaRespuestas.add(btn, 0, i);
            i++;
        }

    }


    public VistaOpciones(Stage stage, VistaTemporizador vistaT, VistaInfoJugadores unaVistaInfoJugadores){
        //Button respuesta1 = new BotonProbarCambio();
        //respuesta1.setOnAction(new HandlerCronometro(vistaT));
        //respuesta1.getStyleClass().add(".button");
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
            HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso(btn,stage,unaVistaInfoJugadores);
            btn.setOnAction(botonVoF);
            grillaRespuestas.add(btn, 0, i);
            i++;
        }


    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }
}
