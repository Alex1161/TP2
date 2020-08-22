package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.ControladorPrincipal;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskPasarTurno extends TimerTask {
    Timer esteTimer;
    public TimerTaskPasarTurno(Timer timer) {
    esteTimer=timer;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {

        ControladorPrincipal controlador = ControladorPrincipal.getInstancia();
        controlador.siguienteTurno();
     });
    }
}
