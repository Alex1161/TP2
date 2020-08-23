package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.eventos.HandlerBotonRevancha;
import edu.fiuba.algo3.vista.eventos.HandlerBotonSalir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaGanadorAlgohoot extends BorderPane{

    Juego panelJuego = Juego.getInstancia();
    Label labelGanador = new Label();

    private static final String URL_FONDOGANADOR = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/ganador.jpg";
    private static final String URL_FONDOEMPATE = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/empate.jpg";
    String jugadorGanador;
    int puntajeGanador;
    Button botonReiniciar =  new Button("Jugar de nuevo");
    Button botonSalir = new Button("Salir");

    public VistaGanadorAlgohoot(){

        VBox botonesFinales = new VBox();
        VBox ganador = new VBox();

        botonSalir.setPadding(new Insets(10,10,10,10));
        botonReiniciar.setPadding(new Insets(10,10,10,10));

        jugadorGanador = panelJuego.ganadorAlgohoot();
        puntajeGanador = panelJuego.puntajeGanadorAlgohoot();
        labelGanador.setText(jugadorGanador + " con " + puntajeGanador+" puntos!");
        labelGanador.getStyleClass().add("ganadorAlgohoot");
        ganador.getChildren().add(labelGanador);
        ganador.setAlignment(Pos.CENTER);
        this.setTop(ganador);


        botonReiniciar.getStyleClass().add("botonPrimarioGrande");
        botonSalir.getStyleClass().add("botonPrimarioGrande");


        HandlerBotonSalir manejadorSalir = new HandlerBotonSalir();
        botonSalir.setOnAction(manejadorSalir);

        HandlerBotonRevancha manejadorRevancha = new HandlerBotonRevancha();
        botonReiniciar.setOnAction(manejadorRevancha);

        botonesFinales.getChildren().addAll(botonSalir,botonReiniciar);
        botonesFinales.setSpacing(20);
        botonesFinales.setAlignment(Pos.CENTER);

        this.setBottom(botonesFinales);
        this.setPadding(new Insets(10,10,10,10));

        if (jugadorGanador == "Empate") {
            setFondoDePantalla(this, URL_FONDOEMPATE);
        }
        else {
            setFondoDePantalla(this, URL_FONDOGANADOR);

        }

    }


    private void setFondoDePantalla(BorderPane miPanel, String src){
        Image fondoPantallaInicial = new Image(src);
        BackgroundSize bSize =
                new BackgroundSize(0.95,
                        0.95,
                        true,
                        true,
                        false, false);

        miPanel.setBackground((new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize))));
    }
    public BorderPane obtenerVista() {
        return this;
    }
}
