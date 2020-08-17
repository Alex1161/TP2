package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
/* Debería implementarse a partir de aquí una vista para mostrar los botones de los multiplicadores y exclusividades.
 Además del Nombre Del Jugador Que Actualemente Le Toca.
public class VistaInfoJugadores {

    GridPane tablaDeInfo;
    VBox panel;
    Text j1Txt;
    Text j2Txt;
    Text nombre;
    Text puntos;
    Text puntosJ1txt;
    Text puntosJ2txt;
    Panel panelJuego = Panel.getInstancia();

    public VistaInfoJugadores() {

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
        this.puntosJ1txt = new Text(String.valueOf(panelJuego.obtenerJugador(0).puntajeValorNumerico()));
        puntosJ1txt.getStyleClass().add("otros-text");
        this.j2Txt = new Text("Jose");
        j2Txt.getStyleClass().add("otros-text");
        this.puntosJ2txt = new Text(String.valueOf(panelJuego.obtenerJugador(1).puntajeValorNumerico()));
        puntosJ2txt.getStyleClass().add("otros-text");


        this.panel = new VBox();
        panel.setSpacing(30);
        panel.setAlignment(Pos.CENTER);
        dibujar();

    }

    public void dibujar(){
        tablaDeInfo = new GridPane();
        tablaDeInfo.add(nombre, 0, 0);
        tablaDeInfo.add(puntos, 1, 0);
        tablaDeInfo.add(j1Txt, 0, 1);
        tablaDeInfo.add(puntosJ1txt, 1, 1);
        tablaDeInfo.add(j2Txt, 0, 2);
        tablaDeInfo.add(puntosJ2txt, 1, 2);
        panel.getChildren().removeAll();
        panel.getChildren().addAll(tablaDeInfo);
    }

    public void actualizar(){
        this.j1Txt.setText(panelJuego.obtenerJugador(0).getNombre());
        this.puntosJ1txt.setText(String.valueOf(panelJuego.obtenerJugador(0).puntajeValorNumerico()));
        this.j2Txt.setText(panelJuego.obtenerJugador(1).getNombre());
        this.puntosJ2txt.setText(String.valueOf(panelJuego.obtenerJugador(1).puntajeValorNumerico()));

        this.dibujar();
    }

    public VBox obtenerPanelInfoJugadores() {
        return panel;
    }

}

 */

