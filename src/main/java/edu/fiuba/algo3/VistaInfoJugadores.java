package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class VistaInfoJugadores {

    VBox panelIzquierdo;

    public VistaInfoJugadores(){
        GridPane tablaDeInfo = new GridPane();
        tablaDeInfo.setPadding(new Insets(10, 10, 10, 10));
        tablaDeInfo.setVgap(10);
        tablaDeInfo.setHgap(10);
        tablaDeInfo.setAlignment(Pos.CENTER);

        Text nombre = new Text("Nombre");
        nombre.getStyleClass().add("otros-text");
        Text puntos = new Text("Puntos");
        puntos.getStyleClass().add("otros-text");
        Text j1Txt = new Text("Pepito");
        j1Txt.getStyleClass().add("otros-text");
        Text puntosJ1txt = new Text("1000");
        puntosJ1txt.getStyleClass().add("otros-text");
        Text j2Txt = new Text("Jose");
        j2Txt.getStyleClass().add("otros-text");
        Text puntosJ2txt = new Text("1000");
        puntosJ2txt.getStyleClass().add("otros-text");

        tablaDeInfo.add(nombre, 0, 0);
        tablaDeInfo.add(puntos, 1, 0);
        tablaDeInfo.add(j1Txt, 0, 1);
        tablaDeInfo.add(puntosJ1txt, 1, 1);
        tablaDeInfo.add(j2Txt, 0,2);
        tablaDeInfo.add(puntosJ2txt, 1, 2);

        panelIzquierdo= new VBox();
        panelIzquierdo.getChildren().addAll(tablaDeInfo);
        panelIzquierdo.setSpacing(30);
        panelIzquierdo.setAlignment(Pos.CENTER);

    }

    public VBox obtenerPanelInfoJugadores(){
        return panelIzquierdo;
    }
}
