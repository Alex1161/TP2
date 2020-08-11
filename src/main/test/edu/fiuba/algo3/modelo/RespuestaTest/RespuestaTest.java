package edu.fiuba.algo3.modelo.RespuestaTest;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
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
        assertEquals(1,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test03creoRespuestaYasignoPuntajeNegativo(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        respuesta.agregarPuntajeObtenido(new PuntoNegativo());
        respuesta.aplicarPuntaje();
        assertEquals(-1,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test04seLePasaUnMultiplicadorx2ARespuestaYAplicaPuntajeAJugador(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        Multiplicador multiplicador = new MultiplicadorX2();
        respuesta.agregarPuntajeObtenido(new PuntoPositivo());
        respuesta.cambiarMultiplicador(multiplicador);
        respuesta.aplicarPuntaje();
        assertEquals(2,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test05seLePasaUnMultiplicadorx3ARespuestaYAplicaPuntajeAJugador(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        Multiplicador multiplicador = new MultiplicadorX3();
        respuesta.agregarPuntajeObtenido(new PuntoPositivo());
        respuesta.cambiarMultiplicador(multiplicador);
        respuesta.aplicarPuntaje();
        assertEquals(3,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test06seLePasaUnMultiplicadorx3APuntoNegativoRespuestaYAplicaPuntajeAJugador(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        Multiplicador multiplicador = new MultiplicadorX3();
        respuesta.agregarPuntajeObtenido(new PuntoNegativo());
        respuesta.cambiarMultiplicador(multiplicador);
        respuesta.aplicarPuntaje();
        assertEquals(-3,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test07seLePasaUnMultiplicadorx2APuntoNegativoRespuestaYAplicaPuntajeAJugador(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        Multiplicador multiplicador = new MultiplicadorX2();
        respuesta.agregarPuntajeObtenido(new PuntoNegativo());
        respuesta.cambiarMultiplicador(multiplicador);
        respuesta.aplicarPuntaje();
        assertEquals(-2,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test08seLePasaUnMultiplicadorx2APuntoNuloRespuestaYAplicaPuntajeAJugador(){
        Jugador jugador1= new Jugador("carl");
        Respuesta respuesta= new Respuesta(jugador1);
        Multiplicador multiplicador = new MultiplicadorX2();
        respuesta.agregarPuntajeObtenido(new PuntoNulo());
        respuesta.cambiarMultiplicador(multiplicador);
        respuesta.aplicarPuntaje();
        assertEquals(0,jugador1.puntajeValorNumerico());
    }
}
