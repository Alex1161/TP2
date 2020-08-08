package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application {
    private static final String NOMBRE_JUEGO = "AlgoHoot" ;
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;

    @Override
    public void start(Stage stage) {
        //var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();

        Label labelPreguntas = new Label("Hola Algohoot, Acá Pueden ir las Preguntas");


        Label labelComodines = new Label("Acá Pueden Ir Los comodines disponibles");


        Button eleccionRespuestasUsuario = new Button("Acá Pueden ir Las respuestas que puede seleccionar el usuario");


        BorderPane panelPrincipal = new BorderPane();
        //setFondoDePantalla(panelPrincipal);
        panelPrincipal.setCenter(labelPreguntas);
        panelPrincipal.setLeft(labelComodines);
        panelPrincipal.setBottom((eleccionRespuestasUsuario));


        Scene scene = new Scene(panelPrincipal, ANCHO, ALTO);


        stage.setTitle(NOMBRE_JUEGO);
        stage.setScene(scene);
        stage.show();
    }

    /*private void setFondoDePantalla(BorderPane miPanel) {
        ImageView fondo = new ImageView();
        fondo.setImage(new Image("kahootEditar.jpg"));
        fondo.setFitHeight(ALTO);
        fondo.setFitWidth(ANCHO);
        miPanel.getChildren().add(fondo);
    }
     */

    public static void main(String[] args) {
        launch();
    }


}