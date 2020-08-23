package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HandlerBotonParaJugar implements EventHandler {

    private Juego paneljuego;
    private  TextField campoJugador1;
    private TextField campoJugador2;
    VBox cuadro;

    public HandlerBotonParaJugar(TextField nombreJug1, TextField nombreJug2, VBox cuadro){
        paneljuego = Juego.getInstancia();
        this.campoJugador1 = nombreJug1;
        this.campoJugador2 = nombreJug2;
        this.cuadro = cuadro;
    }

    @Override
    public void handle(Event event){
        if(campoJugador1.getText().isEmpty() || campoJugador2.getText().isEmpty()){

            Stage dialog=new Stage();

            Button botonSalir = new Button("Nombre de Usuario Incorrecto");
            botonSalir.setPrefSize(500,80);
            HandlerCerrarVentana manejadorSalir = new HandlerCerrarVentana(dialog);
            botonSalir.setOnAction(manejadorSalir);
            Scene scene= new Scene(new Group(botonSalir));
            dialog.setScene(scene);
            dialog.show();
            /*
            Label textoInfoError = new Label();
            textoInfoError.setText("Nombre de Usuario Incorrecto");
            textoInfoError.setTextFill(Color.RED);
            cuadro.getChildren().addAll(textoInfoError);

             */

        }else {
            Jugador jugador1 = new Jugador(campoJugador1.getText());
            Jugador jugador2 = new Jugador(campoJugador2.getText());
            List<Jugador> jugadores = new ArrayList<Jugador>();
            jugadores.add(jugador1);
            jugadores.add(jugador2);
            paneljuego.setJugadores(jugadores);

            ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
            controladorPrincipal.iniciarTurno();
        }

    }
}
