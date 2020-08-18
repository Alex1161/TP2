package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.vista.eventos.HandlerBotonMultipleChoise;
import edu.fiuba.algo3.vista.eventos.HandlerBotonVerdaderoFalso;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.beans.EventHandler;

public class VistaOpciones {

    private Panel panel = Panel.getInstancia();
    GridPane grillaRespuestas;

    public VistaOpciones(){

        grillaRespuestas = new GridPane();
        grillaRespuestas.setPadding(new Insets(5, 5, 5, 5));
        grillaRespuestas.setVgap(5);
        grillaRespuestas.setHgap(5);
        grillaRespuestas.setAlignment(Pos.CENTER);
        generarBotones();
    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }

    public void generarBotones(){
        if(Panel.getInstancia().preguntaActual().getTipo() == "MultipleChoiceClasico"
        || Panel.getInstancia().preguntaActual().getTipo() == "MultipleChoiceParcial"){
            crearBotonesChoise();
        }else{
            crearBotonesNormales();
        }

    }

    private void crearBotonesChoise() {
        int i = 0;
        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            HandlerBotonMultipleChoise botonVoF = new HandlerBotonMultipleChoise(opcion, btn);
            btn.setOnAction(botonVoF);
            grillaRespuestas.add(btn, 1, i);
            i++;
        }
        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("button"+(i+1));
        HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso("CONFIRMAR");
        btn.setOnAction(botonVoF);
        i++;
        grillaRespuestas.add(btn, 2, 1);
    }

    private void crearBotonesNormales() {
        int i = 0;
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
}
