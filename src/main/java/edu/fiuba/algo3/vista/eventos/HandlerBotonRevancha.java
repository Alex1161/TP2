package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.AlgoHoot;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.StagePrincipal;
import edu.fiuba.algo3.vista.VistaIngresoDeJugadores;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonRevancha implements EventHandler {

    Stage ventana = StagePrincipal.getInstance();
    VistaIngresoDeJugadores nuevaVista = new VistaIngresoDeJugadores(ventana);
    Juego panelJuego = Juego.getInstancia();


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
