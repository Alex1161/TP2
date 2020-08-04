package edu.fiuba.algo3.modelo.RespuestaTest;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNegativo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RespuestaTest {
    @Test
    public void test01creoRespuestaYagregoOpcionYSeLAPido(){
        String opcion="1";
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        respuesta.agregarOpcion(opcion);
        assertTrue(respuesta.obtenerOpciones().esta("1"));
    }
    @Test
    public void test02creoRespuestaYasignoPuntajePositivo(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        respuesta.agregarPuntajeObtenido(new PuntoPositivo());
        respuesta.aplicarPuntaje();
        assertEquals(1,jugador1.obtenerPuntaje().valor());
    }

    @Test
    public void test03creoRespuestaYasignoPuntajeNegativo(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        respuesta.agregarPuntajeObtenido(new PuntoNegativo());
        respuesta.aplicarPuntaje();
        assertEquals(-1,jugador1.obtenerPuntaje().valor());
    }
}
