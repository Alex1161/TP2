package edu.fiuba.algo3.modelo.JugadorTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.ComodinYaUsado;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
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
    public void test05JugadorSacoMultiplicadorX2LuegoSacarMultiplicadorX2LanzaComodinYaUsadoExeption(){
        Jugador jugador = new Jugador("carlos");
        jugador.sacarComodin(new MultiplicadorX2());

        assertThrows(ComodinYaUsado.class,
                () -> {
                    jugador.sacarComodin(new MultiplicadorX2());
                });
    }

    @Test
    public void test06JugadorSacoMultiplicadorX3LuegoSacarMultplicadorX3LanzaComodinYaUsadoExeption(){
        Jugador jugador = new Jugador("carlos");
        jugador.sacarComodin(new MultiplicadorX3());

        assertThrows(ComodinYaUsado.class,
                () -> {
                    jugador.sacarComodin(new MultiplicadorX3());
                });
    }

    @Test
    public void test07JugadorSacoExclusividadDosVecesLuegoSacarExclusividadLanzaComodinYaUsadoExeption(){
        Jugador jugador = new Jugador("carlos");
        jugador.sacarComodin(new Exclusividad());
        jugador.sacarComodin(new Exclusividad());

        assertThrows(ComodinYaUsado.class,
                () -> {
                    jugador.sacarComodin(new Exclusividad());
                });
    }

}

