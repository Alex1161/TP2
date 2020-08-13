package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.File;


public class AlgoHoot extends Application {

    private Jugador jugador1;
    private Jugador jugador2;
    private static final String NOMBRE_JUEGO = "AlgoHoot" ;
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;

    @Override
    public void start(Stage stage) {

        jugador1 = new Jugador();
        jugador2 = new Jugador();

        stage.setTitle(NOMBRE_JUEGO);

        VistaPreguntaEnCurso preguntaEnCurso = new VistaPreguntaEnCurso(jugador1, jugador2);
        Scene escenaPreguntaEnCurso = new Scene(preguntaEnCurso.obtenerVista(), ANCHO, ALTO);

        File f = new File("EstilosDeBotones.css");
        escenaPreguntaEnCurso.getStylesheets().clear();
        escenaPreguntaEnCurso.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        VistaIngresoDeJugadores ingresoDeJugadores = new VistaIngresoDeJugadores(stage, escenaPreguntaEnCurso, preguntaEnCurso.obtenerVistaInfoJugadores(), jugador1, jugador2);
        Scene escenaDeBienvenida = new Scene(ingresoDeJugadores.getVista(), ANCHO, ALTO);

        stage.setScene(escenaDeBienvenida);

        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }


}