package edu.fiuba.algo3.modelo.JugadorTest;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.MultiplicadorYaUsadoException;
import edu.fiuba.algo3.modelo.Puntaje.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void test01JugadorEsCreadoConPuntajeDeValorNumericoEsCero() {
        Jugador jugador = new Jugador("carlos");

        assertEquals(jugador.puntajeValorNumerico(), 0);
    }

    @Test
    public void test02JugadorSeLeAgregaPuntoPositivoPuntajeValorNumericoEsUno(){
        Jugador jugador = new Jugador("carlos");

        jugador.agregarPuntaje(new PuntoPositivo());

        assertEquals(jugador.puntajeValorNumerico(), 1);
    }

    @Test
    public void test03JugadorSeLeAgregaPuntoNuloPuntajeValorNumericoEsCero(){
        Jugador jugador = new Jugador("carlos");

        jugador.agregarPuntaje(new PuntoNulo());

        assertEquals(jugador.puntajeValorNumerico(), 0);
    }

    @Test
    public void test03JugadorSeLeAgregaPuntoNegativoPuntajeValorNumericoEsMenosUno(){
        Jugador jugador = new Jugador("carlos");

        jugador.agregarPuntaje(new PuntoNegativo());

        assertEquals(jugador.puntajeValorNumerico(), -1);
    }

    @Test
    public void test04JugadorSeLeAgregaPuntosDeValorNumericoDosPuntajeValorNumericoEsDos(){
        Puntaje puntaje= new Puntos();
        puntaje.agregar(new PuntoPositivo());
        puntaje.agregar(new PuntoPositivo());
        Jugador jugador = new Jugador("carlos");

        jugador.agregarPuntaje(puntaje);

        assertEquals(jugador.puntajeValorNumerico(), 2);
    }

    @Test
    public void test05JugadorSacoMultiplicadorX2LuegoEsteYaNoSeEncuentraEnJugador(){
        Jugador jugador = new Jugador("carlos");
        jugador.sacarMultiplicador("MultiplicadorX2");

        assertThrows(MultiplicadorYaUsadoException.class,
                () -> {
                    jugador.sacarMultiplicador("MultiplicadorX2");
                });
    }

    @Test
    public void test06JugadorSacoMultiplicadorX3LuegoEsteYaNoSeEncuentraEnJugador(){
        Jugador jugador = new Jugador("carlos");
        jugador.sacarMultiplicador("MultiplicadorX3");

        assertThrows(MultiplicadorYaUsadoException.class,
                () -> {
                    jugador.sacarMultiplicador("MultiplicadorX3");
                });
    }

}

