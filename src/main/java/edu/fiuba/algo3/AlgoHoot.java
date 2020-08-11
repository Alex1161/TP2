package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class AlgoHoot extends Application {
    Controlador control;
    private static final String NOMBRE_JUEGO = "AlgoHoot" ;
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;

    @Override
    public void start(Stage stage) {

        /*


        this.setFondoDePantalla(panelPrincipal);
        panelPrincipal.setCenter(eleccionRespuestasUsuario);
        //panelPrincipal.setLeft(labelComodines);

        Scene scene = new Scene(panelPrincipal, ANCHO, ALTO);


        stage.setTitle(NOMBRE_JUEGO);

        stage.setScene(scene);
        stage.show();
        */

        this.control = new Controlador();
        this.control.comienzo(stage);
        VistaPreguntaEnCurso vista = new VistaPreguntaEnCurso(new Pregunta("hola"));
    }


    public static void main(String[] args) {
        launch();
    }


}