package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.AlgoHoot;
import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.StagePrincipal;
import edu.fiuba.algo3.vista.VistaGanadorAlgohoot;
import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class HandlerBotonRevancha implements EventHandler {

    Stage ventana = StagePrincipal.getInstance();
    VistaIngresoDeJugadores nuevaVista = new VistaIngresoDeJugadores(ventana);
    Panel panelJuego = Panel.getInstancia();


    @Override
    public void handle(Event event) {
        //panelJuego.reiniciar();

        AlgoHoot juegoNuevo = new AlgoHoot();
        juegoNuevo.restart(ventana);



        //juegoNuevo.main();
        //Scene escenaDeJuego = new Scene(nuevaVista.getVista(), 1200, 680);
        //ventana.setScene(escenaDeJuego);
    }
}
