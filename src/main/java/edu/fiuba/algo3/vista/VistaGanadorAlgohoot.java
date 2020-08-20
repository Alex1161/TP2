package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.eventos.HandlerBotonAccionarComodin;
import edu.fiuba.algo3.vista.eventos.HandlerBotonRevancha;
import edu.fiuba.algo3.vista.eventos.HandlerBotonSalir;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class VistaGanadorAlgohoot extends VBox{

    Panel panelJuego = Panel.getInstancia();
    Label labelGanador = new Label();

    private static final String URL_FONDO = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/ganador.jpg";
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;
    Jugador jugadorGanador;
    Button botonReiniciar =  new Button("Jugar de nuevo.");
    Button botonSalir = new Button("Salir.");
    VBox botones = new VBox();

    public VistaGanadorAlgohoot(){
        jugadorGanador = panelJuego.ganadorAlgohoot();
        labelGanador.setText(jugadorGanador.getNombre() + " con " + jugadorGanador.puntajeValorNumerico()+" puntos!");
        labelGanador.getStyleClass().add("ganadorAlgohoot");


        botonReiniciar.getStyleClass().add("botonPrimario");
        botonSalir.getStyleClass().add("botonPrimario");


        HandlerBotonSalir manejadorSalir = new HandlerBotonSalir();
        botonSalir.setOnAction(manejadorSalir);

        HandlerBotonRevancha manejadorRevancha = new HandlerBotonRevancha();
        botonReiniciar.setOnAction(manejadorRevancha);


        botones.getChildren().addAll(botonReiniciar,botonSalir);

        this.getChildren().add(labelGanador);
        this.setAlignment(Pos.BASELINE_CENTER);

        this.getChildren().addAll(botonSalir,botonReiniciar);




        setFondoDePantalla(this, URL_FONDO);

    }


    private void setFondoDePantalla(VBox miPanel, String src){
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
    public VBox obtenerVista() {
        return this;
    }
}
