package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.VistaPreguntaEnCurso;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.File;

public class HandlerBotonParaJugar implements EventHandler {

    /*private Stage ventana;
    private Scene escenaProxima;
    private VistaInfoJugadores vistaInfoJugadores;
    ;*/
    private Panel paneljuego;
    private  TextField campoJugador1;
    private TextField campoJugador2;
    VBox cuadro;

    public HandlerBotonParaJugar(Stage unaVentana, TextField nombreJug1, TextField nombreJug2, VBox cuadro){
        //this.ventana = unaVentana;
        paneljuego = Panel.getInstancia();
        this.campoJugador1 = nombreJug1;
        this.campoJugador2 = nombreJug2;
        this.cuadro = cuadro;

    }
    @Override
    public void handle(Event event){
        if(campoJugador1.getText().isEmpty() || campoJugador2.getText().isEmpty()){
            Label textoInfoError = new Label();
            textoInfoError.setText("Nombre de Usuario Incorrecto");
            textoInfoError.setTextFill(Color.RED);
            cuadro.getChildren().addAll(textoInfoError);

        }else {
            Jugador jugador1 = new Jugador(campoJugador1.getText());
            Jugador jugador2 = new Jugador(campoJugador2.getText());
            paneljuego.agregarJugador(jugador1);
            paneljuego.agregarJugador(jugador2);

            ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
            controladorPrincipal.iniciarTurno();
        }

    }
}
