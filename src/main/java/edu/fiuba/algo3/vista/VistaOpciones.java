package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Collection;

public class VistaOpciones {

    private final String SRC_GRUPO_1 = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoDegradadoNaranjaPrueba.png";
    private final Collection<String> opciones;
    private ControladorOpciones controladorOpciones = new ControladorOpciones();

    private Juego panel = Juego.getInstancia();

    GridPane grillaRespuestas;

    public VistaOpciones(){
        grillaRespuestas = new GridPane();
        grillaRespuestas.setPadding(new Insets(5, 5, 5, 5));
        grillaRespuestas.setVgap(5);
        grillaRespuestas.setHgap(5);
        grillaRespuestas.setAlignment(Pos.CENTER);
        opciones = panel.obtenerOpciones();
        generarBotones();
    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }

    public void generarBotones(){
        String tipoPregunta = panel.tipoPreguntaActual();
        if(tipoPregunta.contains("MultipleChoice")){
            crearBotonesChoice();
        }
        else if(tipoPregunta.contains("GroupChoice")){
            crearBotonesGroupChoice();
        }
        else if(tipoPregunta.contains("OrderChoice")){
            crearBotonesOrdered();
        }
        else{
            crearBotonesNormales();
        }
    }

    private void crearBotonesChoice() {
        int i = 0;
        for (String opcion : opciones) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            HandlerBotonMultipleChoise botonVoF = new HandlerBotonMultipleChoise(opcion, btn, controladorOpciones);
            btn.setOnAction(botonVoF);
            grillaRespuestas.add(btn, 0, i);
            i++;

        }
        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmar botonConfirmar = new HandlerBotonConfirmar(controladorOpciones);
        btn.setOnAction(botonConfirmar);
        grillaRespuestas.add(btn, 30, 1);
    }

    private void crearBotonesNormales() {
        int i = 0;
        for (String opcion : opciones) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso(opcion, controladorOpciones);
            btn.setOnAction(botonVoF);
            grillaRespuestas.add(btn, 1, i);
            i++;
        }
    }

    private void crearBotonesGroupChoice(){
        HBox grupo1 = new HBox();
        HBox grupo2 = new HBox();

        int i = 0;
        for (String opcion: opciones) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            btn.setOnAction(new HandlerBotonGroupChoiceClick(btn,grupo1,grupo2, controladorOpciones));
            grillaRespuestas.add(btn, 0, i);
            i++;
        }

        Label nombreGrupo1 = new Label("G1");

        grupo1.setPadding(new Insets(10,10,10,10));

        Label nombreGrupo2 = new Label("G2");

        grupo2.setPadding(new Insets(10,10,10,10));


        grupo1.setPrefHeight(75);
        grupo1.setPrefWidth(200);
        setFondoDePantalla(grupo1, SRC_GRUPO_1);

        grupo2.setPrefHeight(75);
        grupo2.setPrefWidth(200);
        setFondoDePantalla(grupo2, SRC_GRUPO_1);


        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmarGroup botonConfirmar = new HandlerBotonConfirmarGroup(grillaRespuestas,grupo1,5, controladorOpciones);
        btn.setOnAction(botonConfirmar);
        grillaRespuestas.add(btn, 30, 0);

        grillaRespuestas.add(nombreGrupo1,5,0);
        grillaRespuestas.add(grupo1, 6,0);

        grillaRespuestas.add(nombreGrupo2, 5,1);
        grillaRespuestas.add(grupo2, 6,1);

    }

    private void crearBotonesOrdered(){
        int CORRECCION_A_LA_DERECHA_ORDERED = 1;
        HBox grupoOrdenado = new HBox();
        int i = 0;
        for (String opcion : opciones) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            btn.setOnAction(new HandlerBotonOrderedChoiceClick(btn,grupoOrdenado,grillaRespuestas, controladorOpciones));
            grillaRespuestas.add(btn, i+CORRECCION_A_LA_DERECHA_ORDERED, 10);
            i++;
        }

        Label nombreGrupoOrdenado = new Label("Grupo Ordenado");

        grupoOrdenado.setPadding(new Insets(10,10,10,10));




        grupoOrdenado.setPrefHeight(75);
        grupoOrdenado.setPrefWidth(200);
        setFondoDePantalla(grupoOrdenado, SRC_GRUPO_1);


        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmarGroup botonConfirmar = new HandlerBotonConfirmarGroup(grillaRespuestas,grupoOrdenado,3, controladorOpciones);
        btn.setOnAction(botonConfirmar);
        grillaRespuestas.add(btn, 20, 0);

        grillaRespuestas.add(nombreGrupoOrdenado,5,0);
        grillaRespuestas.add(grupoOrdenado, 6,0);

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
