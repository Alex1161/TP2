package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaInfoJugadores {

    GridPane tablaDeInfo;
    VBox panelIzquierdo;
    Text j1Txt;
    Text j2Txt;
    Text nombre;
    Text puntos;
    Text puntosJ1txt;
    Text puntosJ2txt;
    Jugador jugador1, jugador2;

    public VistaInfoJugadores(Jugador jugador1, Jugador jugador2) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.tablaDeInfo = new GridPane();
        tablaDeInfo.setPadding(new Insets(10, 10, 10, 10));
        tablaDeInfo.setVgap(10);
        tablaDeInfo.setHgap(10);
        tablaDeInfo.setAlignment(Pos.CENTER);

        this.nombre = new Text("Nombre");
        nombre.getStyleClass().add("otros-text");
        this.puntos = new Text("Puntos");
        puntos.getStyleClass().add("otros-text");
        this.j1Txt = new Text("Pepito");
        j1Txt.getStyleClass().add("otros-text");
        this.puntosJ1txt = new Text(String.valueOf(jugador1.puntajeValorNumerico()));
        puntosJ1txt.getStyleClass().add("otros-text");
        this.j2Txt = new Text("Jose");
        j2Txt.getStyleClass().add("otros-text");
        this.puntosJ2txt = new Text(String.valueOf(jugador2.puntajeValorNumerico()));
        puntosJ2txt.getStyleClass().add("otros-text");


        this.panelIzquierdo = new VBox();
        panelIzquierdo.setSpacing(30);
        panelIzquierdo.setAlignment(Pos.CENTER);

    }

    public void dibujar(){
        tablaDeInfo.add(nombre, 0, 0);
        tablaDeInfo.add(puntos, 1, 0);
        tablaDeInfo.add(j1Txt, 0, 1);
        tablaDeInfo.add(puntosJ1txt, 1, 1);
        tablaDeInfo.add(j2Txt, 0, 2);
        tablaDeInfo.add(puntosJ2txt, 1, 2);
        panelIzquierdo.getChildren().addAll(tablaDeInfo);
    }

    public void actualizar(){
        this.j1Txt.setText(jugador1.getNombre());
        this.puntosJ1txt.setText(String.valueOf(jugador1.puntajeValorNumerico()));
        this.j2Txt.setText(jugador2.getNombre());
        this.puntosJ2txt.setText(String.valueOf(jugador2.puntajeValorNumerico()));
        this.dibujar();
    }

    public VBox obtenerPanelInfoJugadores() {
        return panelIzquierdo;
    }

}

