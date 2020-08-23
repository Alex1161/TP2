package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaGanadorAlgohoot;
import edu.fiuba.algo3.vista.VistaPreguntaEnCurso;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class ControladorPrincipal {

    private static ControladorPrincipal instancia = new ControladorPrincipal();

    Stage ventana = StagePrincipal.getInstance();
    Juego panel = Juego.getInstancia();
    Cronometro cronometro;
    ControladorPrincipal(){   }

    public void iniciarVistaPregunta(){
        Scene escenaDeJuego = new Scene((new VistaPreguntaEnCurso()).obtenerVista(), 1200, 680);
        File f = new File("EstilosDeBotones.css");
        escenaDeJuego.getStylesheets().clear();
        escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        ventana.setScene(escenaDeJuego);
    }

    public void iniciarTurno(){
        cronometro=new Cronometro();
        iniciarVistaPregunta();
    }

    public void actualizarTurno(){
        cronometro.parar();
        iniciarTurno();
    }

    public static ControladorPrincipal getInstancia(){
        return instancia;
    }

    public void mostrarVistaPuntajes(){
        cronometro.parar();
        Scene escenaDeJuego = new Scene((new edu.fiuba.algo3.VistaPuntajeJugador()).obtenerPanel(), 1200, 680);
        File f = new File("EstilosDeBotones.css");
        escenaDeJuego.getStylesheets().clear();
        escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        ventana.setScene(escenaDeJuego);
    }

    public void vistaGanador() {
        Scene escenaDeJuego = new Scene(new VistaGanadorAlgohoot().obtenerVista(), 1200, 680);
        File f = new File("EstilosDeBotones.css");
        escenaDeJuego.getStylesheets().clear();
        escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        ventana.setScene(escenaDeJuego);
    }

    public int obtenerTiempoEnMilisegundos() {
        return cronometro.obtenerTiempoEnMilisegundos();
    }
}
