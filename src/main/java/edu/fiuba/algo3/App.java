package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URISyntaxException;


public class App extends Application {
    private static final String NOMBRE_JUEGO = "AlgoHoot" ;
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;

    @Override
    public void start(Stage stage) {

        Label labelPreguntas = new Label("Hola Algohoot, Acá Pueden ir las Preguntas");


        Label labelComodines = new Label("Acá Pueden Ir Los comodines disponibles");
        TextField solicitudNombre = new TextField();
        solicitudNombre.setPromptText("Ingrese Nombre De Jugador:");
        Button eleccionRespuestasUsuario = new Button("Acá Pueden ir Las respuestas que puede seleccionar el usuario");


        BorderPane panelPrincipal = new BorderPane();

        this.setFondoDePantalla(panelPrincipal);
        panelPrincipal.setCenter(eleccionRespuestasUsuario);
        //panelPrincipal.setLeft(labelComodines);

        Scene scene = new Scene(panelPrincipal, ANCHO, ALTO);


        stage.setTitle(NOMBRE_JUEGO);

        stage.setScene(scene);
        stage.show();
    }

    private void setFondoDePantalla(BorderPane miPanel){
        Image fondoPantallaInicial = new Image("file:kahootEditar.png");
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        miPanel.setBackground(new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }


    public static void main(String[] args) {
        launch();
    }


}