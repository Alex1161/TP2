package edu.fiuba.algo3.modelo.Entrega0;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaVoFTest {
    @Test
    public void preguntaVoFPuedeCrearsePasandoRespuestaCorrecta() {
        Respuesta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        Respuesta respuestaIncorrecta = new RespuestaIncorrecta("Falso");
        PreguntaVoF pregunta = new PreguntaVoF("1 + 1 = 2 ", respuestaCorrecta, respuestaIncorrecta);

       assertTrue(pregunta.esCorrecta(respuestaCorrecta));
    }


    @Test
    public void preguntaVoFPuedeCrearsePasandoRespuestaCorrectaSinOrden() {
        Respuesta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        Respuesta respuestaIncorrecta = new RespuestaIncorrecta("Falso");
        PreguntaVoF pregunta = new PreguntaVoF("1 + 1 = 2 ", respuestaIncorrecta, respuestaCorrecta);

        assertTrue(pregunta.esCorrecta(respuestaCorrecta));
    }

    @Test
    public void preguntaVoFRecibeRespuestasAsignaCorrectamentePuntajes(){
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuestaJugador1 = new RespuestaIncorrecta("Verdadero");
        Respuesta respuestaJugador2 = new RespuestaCorrecta("Falso");

        Seleccion eleccionJugador1 = new Seleccion(jugador1);
        eleccionJugador1.agregarRespuesta(respuestaJugador1);

        Seleccion eleccionJugador2 = new Seleccion(jugador2);
        eleccionJugador2.agregarRespuesta(respuestaJugador2);

        List<Seleccion> listaRespuestas = new ArrayList<Seleccion>();
        listaRespuestas.add(eleccionJugador1);
        listaRespuestas.add(eleccionJugador2);

        PreguntaVoF pregunta = new PreguntaVoF("1 + 1 = 2 ", respuestaJugador2, respuestaJugador1);
        pregunta.clasificarRespuesta(listaRespuestas);

        assertEquals(1, jugador2.obtenerPuntaje() );
        assertEquals(0, jugador1.obtenerPuntaje() );
    }

}