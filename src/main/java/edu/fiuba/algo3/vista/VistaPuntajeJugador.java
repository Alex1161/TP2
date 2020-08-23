package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.eventos.HandlerSiguientePregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.List;

public class VistaPuntajeJugador{

    private static final String SRC_FONDO = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoPuntajesParciales.jpg";

    GridPane tablaDeInfo;
    VBox panel;
    Text j1Txt;
    Text j2Txt;
    Text nombre;
    Text puntos;
    Text puntosJ1txt;
    Text puntosJ2txt;
    Jugador jugador1, jugador2;

    Button botonSiguientePregunta = new Button();
    private static String ENCABEZADO_NOMBRE = "Nombre";
    private static String ENCABEZADO_PUNTOS = "Puntos";


    public VistaPuntajeJugador(){

        botonSiguientePregunta.setText("Siguiente Pregunta");
        List<Jugador> jugadores = Juego.getInstancia().getJugadores();
        jugador1 = jugadores.get(0);
        jugador2 = jugadores.get(1);

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
        this.j2Txt = new Text(jugador2.getNombre());
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
        panel.getChildren().addAll(tablaDeInfo, botonSiguientePregunta);

        HandlerSiguientePregunta siguiente = new HandlerSiguientePregunta();

        botonSiguientePregunta.getStyleClass().add("botonSiguientePregunta");
        botonSiguientePregunta.setOnAction(siguiente);

        setFondoDePantalla(panel, SRC_FONDO);

    }

    public VBox obtenerPanel() {
        return panel;
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