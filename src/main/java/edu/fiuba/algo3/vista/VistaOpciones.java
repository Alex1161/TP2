package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.vista.eventos.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        else if(Panel.getInstancia().preguntaActual().getTipo().contains("GroupChoice")){
            crearBotonesGroupChoice();
        } else if(Panel.getInstancia().preguntaActual().getTipo().contains("OrderChoice")){
            crearBotonesOrdered();
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
        HBox grupo1 = new HBox();
        HBox grupo2 = new HBox();

        int i = 0;
        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            btn.setOnAction(new HandlerBotonGroupChoiceClick(btn,grupo1,grupo2));
            grillaRespuestas.add(btn, 0, i);
            i++;
        }

        Label nombreGrupo1 = new Label("G1");

        grupo1.setPadding(new Insets(10,10,10,10));

        Label nombreGrupo2 = new Label("G2");

        grupo2.setPadding(new Insets(10,10,10,10));


        grupo1.setPrefHeight(100);
        grupo1.setPrefWidth(200);
        setFondoDePantalla(grupo1, SRC_GRUPO_1);

        grupo2.setPrefHeight(100);
        grupo2.setPrefWidth(200);
        setFondoDePantalla(grupo2, SRC_GRUPO_1);


        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmarGroup botonConfirmar = new HandlerBotonConfirmarGroup(grillaRespuestas,grupo1,5);
        btn.setOnAction(botonConfirmar);
        grillaRespuestas.add(btn, 8, 4);

        grillaRespuestas.add(nombreGrupo1,5,0);
        grillaRespuestas.add(grupo1, 6,0);

        grillaRespuestas.add(nombreGrupo2, 5,1);
        grillaRespuestas.add(grupo2, 6,1);

        /*En el Handler de Confirmar Order Choice.
        for (Node unBoton : grupo1.getChildren()) {
            Button botonActual = (Button) unBoton;
            String respuestaPosible = botonActual.getText();
            System.out.println(respuestaPosible);
        }
         */
    }
    private void crearBotonesOrdered(){
        HBox grupoOrdenado = new HBox();
        int i = 0;
        for (String opcion: panel.preguntaActual().obtenerOpciones().obtenerOpciones()
        ) {
            Button btn = new Button(opcion);
            btn.getStyleClass().add("button"+(i+1));
            btn.setOnAction(new HandlerBotonOrderedChoiceClick(btn,grupoOrdenado,grillaRespuestas));
            grillaRespuestas.add(btn, i, 1);
            i++;
        }

        Label nombreGrupoOrdenado = new Label("Grupo Ordenado");

        grupoOrdenado.setPadding(new Insets(10,10,10,10));

        Label grupoAORdenar = new Label("Grupo Sin Ordenar");



        grupoOrdenado.setPrefHeight(100);
        grupoOrdenado.setPrefWidth(200);
        setFondoDePantalla(grupoOrdenado, SRC_GRUPO_1);


        Button btn = new Button("CONFIRMAR");
        btn.getStyleClass().add("botonConfirmarSeleccion");
        HandlerBotonConfirmarGroup botonConfirmar = new HandlerBotonConfirmarGroup(grillaRespuestas,grupoOrdenado,3);
        btn.setOnAction(botonConfirmar);
        grillaRespuestas.add(btn, 8, 4);

        grillaRespuestas.add(nombreGrupoOrdenado,5,0);
        grillaRespuestas.add(grupoOrdenado, 6,0);


        /*En el Handler de Confirmar Order Choice.
        for (Node unBoton : grupo1.getChildren()) {
            Button botonActual = (Button) unBoton;
            String respuestaPosible = botonActual.getText();
            System.out.println(respuestaPosible);
        }
         */
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
