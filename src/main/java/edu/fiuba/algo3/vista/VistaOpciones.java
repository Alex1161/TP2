package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.vista.eventos.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.concurrent.Flow;

public class VistaOpciones {


    private final String SRC_GRUPO_1 = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoDegradadoNaranjaPrueba.png";

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
        if(Panel.getInstancia().preguntaActual().getTipo().contains("MultipleChoice")){
            crearBotonesChoise();
        }
        if(Panel.getInstancia().preguntaActual().getTipo().contains("GroupChoice")){
            crearBotonesGroupChoice();
        }
        else{
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
            grillaRespuestas.add(btn, 0, i);
            i++;

        }
        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmar botonConfirmar = new HandlerBotonConfirmar();
        btn.setOnAction(botonConfirmar);
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

    private void crearBotonesGroupChoice(){
        int i = 0;
        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            btn.setOnDragDetected(new HandlerBotonGroupChoice(btn));
            btn.setOnDragDone(new HandlerBotonGroupChoiceDone(grillaRespuestas, btn));
            grillaRespuestas.add(btn, i, 0);
            i++;
        }

        FlowPane grupo1 = new FlowPane();
        FlowPane grupo2 = new FlowPane();

        grupo1.setOnDragOver(new HandlerBotonGroupChoiceGrupoOver(grupo1));
        grupo1.setOnDragDropped(new HandlerBotonGroupChoiceGrupoDropped(grupo1));

        grupo2.setOnDragOver(new HandlerBotonGroupChoiceGrupoOver(grupo2));
        grupo2.setOnDragDropped(new HandlerBotonGroupChoiceGrupoDropped(grupo2));

        grupo1.setPrefHeight(100);
        grupo1.setPrefWidth(200);
        setFondoDePantalla(grupo1, SRC_GRUPO_1);

        grupo2.setPrefHeight(100);
        grupo2.setPrefWidth(200);
        setFondoDePantalla(grupo2, SRC_GRUPO_1);


        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmar botonConfirmar = new HandlerBotonConfirmar();
        btn.setOnAction(botonConfirmar);
        grillaRespuestas.add(btn, 10, 4);

        grillaRespuestas.add(grupo1, 6,6);
        grillaRespuestas.add(grupo2, 8,8);
    }

    private void setFondoDePantalla(Pane miPanel, String src){
        Image fondoPantallaInicial = new Image(src);
        BackgroundSize bSize =
                new BackgroundSize(1.0,
                        1.0,
                        true,
                        true,
                        false, false);

        miPanel.setBackground(new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }
}
