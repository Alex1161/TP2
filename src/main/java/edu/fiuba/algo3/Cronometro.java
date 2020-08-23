package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.eventos.TimerTaskPasarTurno;

import java.util.Timer;
import java.util.TimerTask;


public class Cronometro {
    private Timer timer = new Timer();
    private int tiempoPorTurnoEnMilisegundos = 20000;
    public Cronometro() {;
        TimerTask cambiarTurno = new TimerTaskPasarTurno(timer);
        timer.schedule(cambiarTurno,tiempoPorTurnoEnMilisegundos);

    }
    public int obtenerTiempoEnMilisegundos(){
        return tiempoPorTurnoEnMilisegundos;
    }
    public void parar(){
        if (!(this==null)){
            this.timer.cancel();
        }
    }
}
