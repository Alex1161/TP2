package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.VistaPuntajeJugador;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class ControladorPrincipal {

    private static ControladorPrincipal instancia = new ControladorPrincipal();

       Stage ventana = StagePrincipal.getInstance();
       Panel panel = Panel.getInstancia();

       ControladorPrincipal(){
           Scene escenaDeJuego = new Scene((new VistaPreguntaEnCurso()).obtenerVista(), 1200, 680);
           File f = new File("EstilosDeBotones.css");
           escenaDeJuego.getStylesheets().clear();
           escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
           ventana.setScene(escenaDeJuego);
       }



       public void iniciarVistaPregunta(){
           Scene escenaDeJuego = new Scene((new VistaPreguntaEnCurso()).obtenerVista(), 1200, 680);
           File f = new File("EstilosDeBotones.css");
           escenaDeJuego.getStylesheets().clear();
           escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
           ventana.setScene(escenaDeJuego);
       }

       public void iniciarTurno(){
               iniciarVistaPregunta();
               Panel.getInstancia().cambiarJugador();
       }

       public void siguienteTurno(){
           if (panel.tieneSiguienteJugador()){
               iniciarTurno();
           }else{
               mostrarVistaPuntajes();
           }
       }

       public static ControladorPrincipal getInstancia(){
           return instancia;
       }

       public void mostrarVistaPuntajes(){
           Scene escenaDeJuego = new Scene((new edu.fiuba.algo3.VistaPuntajeJugador()).obtenerPanel(), 1200, 680);
           File f = new File("EstilosDeBotones.css");
           escenaDeJuego.getStylesheets().clear();
           escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

           ventana.setScene(escenaDeJuego);
       }


    public void iniciarSiguientePregunta() {
           if(Panel.getInstancia().tieneSiguientePregunta()){
               Panel.getInstancia().cambiarPregunta();
               iniciarTurno();
           }
    }
}
