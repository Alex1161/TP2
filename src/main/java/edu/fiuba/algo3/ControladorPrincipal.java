package edu.fiuba.algo3;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ControladorPrincipal {

       Stage ventana = StagePrincipal.getInstance();

       public ControladorPrincipal(){
           Scene escenaDeJuego = new Scene((new VistaPreguntaEnCurso()).obtenerVista(), 1200, 680);
           File f = new File("EstilosDeBotones.css");
           escenaDeJuego.getStylesheets().clear();
           escenaDeJuego.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
           ventana.setScene(escenaDeJuego);
       }



}
