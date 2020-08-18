package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;

public class VistaPuntajeJugador {
    GridPane tablaDeInfo;
    VBox panel;
    Text j1Txt;
    Text j2Txt;
    Text nombre;
    Text puntos;
    Text puntosJ1txt;
    Text puntosJ2txt;
    Jugador jugador1, jugador2;
    private static String ENCABEZADO_NOMBRE = "Nombre";
    private static String ENCABEZADO_PUNTOS = "Puntos";


    public VistaPuntajeJugador(){

        jugador1 = Panel.getInstancia().obtenerJugador(0);
        jugador2 = Panel.getInstancia().obtenerJugador(1);

        this.tablaDeInfo = new GridPane();
        tablaDeInfo.setPadding(new Insets(10, 10, 10, 10));
        tablaDeInfo.setVgap(10);
        tablaDeInfo.setHgap(10);
        tablaDeInfo.setAlignment(Pos.CENTER);

        //ENCABEZADO
        this.nombre = new Text(ENCABEZADO_NOMBRE);
        nombre.getStyleClass().add("otros-text");
        this.puntos = new Text(ENCABEZADO_PUNTOS);
        puntos.getStyleClass().add("otros-text");


        this.j1Txt = new Text(jugador1.getNombre());
        j1Txt.getStyleClass().add("otros-text");
        this.puntosJ1txt = new Text(String.valueOf(jugador1.puntajeValorNumerico()));
        puntosJ1txt.getStyleClass().add("otros-text");
        this.j2Txt = new Text(jugador1.getNombre());
        j2Txt.getStyleClass().add("otros-text");
        this.puntosJ2txt = new Text(String.valueOf(jugador2.puntajeValorNumerico()));
        puntosJ2txt.getStyleClass().add("otros-text");

        this.panel = new VBox();
        panel.setSpacing(30);
        panel.setAlignment(Pos.CENTER);

        tablaDeInfo.add(nombre, 0, 0);
        tablaDeInfo.add(puntos, 1, 0);
        tablaDeInfo.add(j1Txt, 0, 1);
        tablaDeInfo.add(puntosJ1txt, 1, 1);
        tablaDeInfo.add(j2Txt, 0, 2);
        tablaDeInfo.add(puntosJ2txt, 1, 2);
        panel.getChildren().addAll(tablaDeInfo);
    }

    public void dibujarTablaDeInfo(){
        tablaDeInfo.add(nombre, 0, 0);
        tablaDeInfo.add(puntos, 1, 0);
        tablaDeInfo.add(j1Txt, 0, 1);
        tablaDeInfo.add(puntosJ1txt, 1, 1);
        tablaDeInfo.add(j2Txt, 0, 2);
        tablaDeInfo.add(puntosJ2txt, 1, 2);
    }

    public void actualizar(){
        this.j1Txt.setText(jugador1.getNombre());
        this.puntosJ1txt.setText(String.valueOf(jugador1.puntajeValorNumerico()));
        this.j2Txt.setText(jugador2.getNombre());
        this.puntosJ2txt.setText(String.valueOf(jugador2.puntajeValorNumerico()));
        //this.panel.getChildren().remove(tablaDeInfo);
        //this.dibujarTablaDeInfo();
        //this.panel.getChildren().addAll(tablaDeInfo);
    }

    public VBox obtenerPanel() {
        return panel;
    }
}