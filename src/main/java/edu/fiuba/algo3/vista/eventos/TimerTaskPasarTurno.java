package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.application.Platform;

import java.util.ArrayList;
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
            Juego.getInstancia().responder(new ArrayList<String>());
        });
    }
}
