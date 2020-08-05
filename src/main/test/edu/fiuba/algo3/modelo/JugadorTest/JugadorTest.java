package edu.fiuba.algo3.modelo.JugadorTest;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Puntaje.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void creoJugadorYObtengoSuPuntaje() {
        Jugador jugador = new Jugador("carlos");
        IPunteable puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), 0);
    }
    @Test
    public void jugadorRecibePuntoPositivo(){
        IPunteable puntos= new PuntoPositivo();
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntos);
        IPunteable puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), 1);
    }
    @Test
    public void jugadorRecibePuntoNulo(){
        IPunteable puntos= new PuntoNulo();
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntos);
        IPunteable puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), 0);
    }
    @Test
    public void jugadorRecibePuntosNegativos(){
        IPunteable puntos= new PuntoNegativo();
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntos);
        IPunteable puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), -1);
    }

    @Test
    public void jugadorRecibePuntajePusitivo(){
        IPunteable puntoPositivo= new PuntoPositivo();
        IPunteable puntaje= new Puntos();
        puntaje.agregar(puntoPositivo);
        puntaje.agregar(puntoPositivo);
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntaje);
        IPunteable puntaje1 = jugador.obtenerPuntaje();
        assertEquals(puntaje1.valor(), 2);
    }
    @Test
    public void obtengoMultiplicadorX2YLoAplico(){

        Jugador jugador = new Jugador("carlos");
        Map<Integer,Multiplicador> multiplicadores=jugador.obtenerMultiplicadores();
        Multiplicador  multiplicador= multiplicadores.get(2);
        IPunteable puntoPositivo= new PuntoPositivo();
        puntoPositivo=multiplicador.aplicar(puntoPositivo);
        assertEquals(puntoPositivo.valor(), 2);
    }
    @Test
    public void testQuitoUnMultiplicadorX2AJugador(){

        Jugador jugador = new Jugador("carlos");
        Map<Integer,Multiplicador> multiplicadores=jugador.obtenerMultiplicadores();
        assertEquals(multiplicadores.size(), 2);
        Multiplicador  multiplicador= multiplicadores.get(2);
        jugador.removerMultiplicador(2);
        Map<Integer,Multiplicador>multiplicadores2=jugador.obtenerMultiplicadores();
        assertFalse(multiplicadores2.containsValue(multiplicador));
    }

}

