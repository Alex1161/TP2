
package edu.fiuba.algo3.modelo.Ronda;




import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;


import java.util.ArrayList;
import java.util.List;

public class Ronda {
    public void jugarRonda(Respuesta respuestaJugador1, Respuesta respuestaJugador2, Pregunta unaPregunta){
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        unaPregunta.calificar(respuestas);

        respuestaJugador1.aplicarPuntaje();
        respuestaJugador2.aplicarPuntaje();

    }
/*
    public void aplicarBonus(Jugador jugador, IBonus unBonus, Pregunta unaPregunta);

    public calificarEn(Jugadores jugadores,Pregunta pregunta){
        Puntaje puntaje=pregunta.calificar(jugador.respuestas());
        jugador.sumarTemporalemente(puntaje);


    }
    private boolean comprobarImplementacionExclusividad() {
        Puntajes puntajesTemporales= new Puntajes();
        for (Jugador jugador: jugadores) {
             puntajesTemporales.add(jugador.puntajeTemporal());
        }
        return puntajesTemporales.contains(new PuntoNulo);
    }

    */
}

