package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import edu.fiuba.algo3.vista.VistaTemporizador;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class AlgoHoot extends Application {

    private static final String NOMBRE_JUEGO = "AlgoHoot" ;
    public static final int ANCHO = 1024;
    public static final int ALTO = 768;

    @Override
    public void start(Stage stage) {

        stage = StagePrincipal.getInstance();
        stage.setTitle(NOMBRE_JUEGO);
        Panel panelJuego = Panel.getInstancia();




        //escenaPreguntaEnCurso.getStylesheets().clear();
        //escenaPreguntaEnCurso.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        VistaIngresoDeJugadores ingresoDeJugadores = new VistaIngresoDeJugadores(stage);
        Scene escenaDeBienvenida = new Scene(ingresoDeJugadores.getVista(), ANCHO, ALTO);

        File f = new File("EstilosDeBotones.css");
        escenaDeBienvenida.getStylesheets().clear();
        escenaDeBienvenida.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        stage.setScene(escenaDeBienvenida);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}