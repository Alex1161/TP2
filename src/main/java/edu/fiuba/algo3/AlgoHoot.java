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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


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
        List<Pregunta> listaPreguntas = null;

        Panel panelJuego = new Panel(jugador1,jugador2);

        try{
            listaPreguntas = panelJuego.cargarPreguntas();
        }catch (IOException e){
            e.getMessage();
        }

        stage.setTitle(NOMBRE_JUEGO);

        VistaPreguntaEnCurso preguntaEnCurso = new VistaPreguntaEnCurso(stage,jugador1, jugador2,listaPreguntas.get(0));
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