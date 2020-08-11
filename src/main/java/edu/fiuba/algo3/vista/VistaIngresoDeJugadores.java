package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Controlador;
import edu.fiuba.algo3.vista.BotonParaJugar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaIngresoDeJugadores{
    VBox ingresoJugadores;
    BotonParaJugar unBoton;

    Stage ventana;
    Controlador controlador;
    Scene IngresoNombres, Juego;

    public VistaIngresoDeJugadores(Stage stage, Controlador controlador){
        this.ventana = stage;
        this.controlador = controlador;
        stage.setTitle("algoHoot");
    }

    public void comienzoDelJuego(){
        BorderPane layoutInicial = new BorderPane();

        StackPane layoutSiguiente = new StackPane();
        Scene proximaEscena = new Scene(layoutSiguiente, 1024, 768);

        this.unBoton = new BotonParaJugar(ventana, proximaEscena);

        Label textoInfo = new Label("Ingrese el nombre del primer jugador e ingrese 'ENTER' ");

        TextField solicitudNombre = new TextField();
        solicitudNombre.setPromptText("Ingrese Nombre De Jugador y presione: 'Enter' ");
        solicitudNombre.setPadding(new Insets(20));


        VBox cuadro = new VBox(textoInfo,solicitudNombre, unBoton);
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

    private void setFondoDePantalla(Pane miPanel){
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


}
