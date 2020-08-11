package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Vista {

    Stage ventana;
    Controlador controlador;
    Scene IngresoNombres, Juego;

    public Vista(Stage stage, Controlador controlador){
        this.ventana = stage;
        this.controlador = controlador;
        stage.setTitle("algoHoot");
    }

    public void comienzoDelJuego(){
        BorderPane layoutInicial = new BorderPane();

        Button botonComenzarJuego = new Button( "Jugar!");
        Label textoInfo = new Label("Ingrese el nombre del primer jugador e ingrese 'ENTER' ");
        TextField solicitudNombre = new TextField();
        solicitudNombre.setPromptText("Ingrese Nombre De Jugador y presione: 'Enter' ");
        solicitudNombre.setPadding(new Insets(20));


        VBox cuadro = new VBox(textoInfo,solicitudNombre,botonComenzarJuego);
        cuadro.setSpacing(20);
        cuadro.setAlignment(Pos.CENTER);
        cuadro.setMaxWidth(400);

        setFondoDePantalla(layoutInicial);

        layoutInicial.setCenter(cuadro);


        controlador.teclaEnter(solicitudNombre, textoInfo);

        IngresoNombres = new Scene(layoutInicial, 1024, 768);

        this.ventana.setScene(IngresoNombres);
        this.ventana.show();
    }

    private void setFondoDePantalla(BorderPane miPanel){
        Image fondoPantallaInicial = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/kahootEditar.png");
        BackgroundSize bSize =
                new BackgroundSize(BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true, false);

        miPanel.setBackground(new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }
    //public String mostrarJugador();
}
