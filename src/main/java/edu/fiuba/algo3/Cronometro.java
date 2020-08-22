package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.eventos.TimerTaskPasarTurno;

import java.util.Timer;
import java.util.TimerTask;


public class Cronometro {
    Timer timer=new Timer();
    int tiempoPorTurnoEnMilisegundos=30000;
    public Cronometro() {

        TimerTask cambiarTurno=new TimerTaskPasarTurno(timer);
        timer.schedule(cambiarTurno,tiempoPorTurnoEnMilisegundos);

    }
    public int obtenerTiempoEnMilisegundos(){
        return tiempoPorTurnoEnMilisegundos;
    }

}
