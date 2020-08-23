package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonParaJugar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaIngresoDeJugadores{

    private static final String URL_FONDO = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/kahootEditar.png";

    BorderPane layoutInicial;

    public VistaIngresoDeJugadores(){

        this.layoutInicial = new BorderPane();

        TextField solicitudNombre1 = new TextField();
        solicitudNombre1.setPromptText("Ingrese Nombre De Jugador1");
        solicitudNombre1.setPadding(new Insets(10));

        TextField solicitudNombre2 = new TextField();
        solicitudNombre2.setPromptText("Ingrese Nombre De Jugador2");
        solicitudNombre2.setPadding(new Insets(10));

        VBox cuadro = new VBox(solicitudNombre1, solicitudNombre2);

        BotonParaJugar botonParaJugar = new BotonParaJugar(solicitudNombre1, solicitudNombre2, cuadro);
        botonParaJugar.getStyleClass().add("botonPrimarioGrande");
        cuadro.getChildren().addAll(botonParaJugar);

        cuadro.setSpacing(20);
        cuadro.setAlignment(Pos.CENTER);
        cuadro.setMaxWidth(400);

        setFondoDePantalla(layoutInicial, URL_FONDO);

        layoutInicial.setCenter(cuadro);
    }

    private void setFondoDePantalla(BorderPane miPanel, String src){
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


    public BorderPane getVista() {
        return layoutInicial;
    }
}
