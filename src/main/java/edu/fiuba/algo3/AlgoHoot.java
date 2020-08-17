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

    private static final String NOMBRE_JUEGO = "AlgoHoot" ;
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;

    @Override
    public void start(Stage stage) {

        Panel panelJuego = Panel.getInstancia();

        /*try{
            listaPreguntas = panelJuego.cargarPreguntas();
        }catch (IOException e){
            e.getMessage();
        }
         */

        stage.setTitle(NOMBRE_JUEGO);

        //VistaPreguntaEnCurso preguntaEnCurso = new VistaPreguntaEnCurso(stage);
        //Scene escenaPreguntaEnCurso = new Scene(preguntaEnCurso.obtenerVista(), ANCHO, ALTO);

        File f = new File("EstilosDeBotones.css");
        //escenaPreguntaEnCurso.getStylesheets().clear();
        //escenaPreguntaEnCurso.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        VistaIngresoDeJugadores ingresoDeJugadores = new VistaIngresoDeJugadores(stage);
        Scene escenaDeBienvenida = new Scene(ingresoDeJugadores.getVista(), ANCHO, ALTO);

        escenaDeBienvenida.getStylesheets().clear();
        escenaDeBienvenida.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        stage.setScene(escenaDeBienvenida);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


}