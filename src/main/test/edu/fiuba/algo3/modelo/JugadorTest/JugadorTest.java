package edu.fiuba.algo3.modelo.JugadorTest;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.MultiplicadorYaUsadoException;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Puntaje.*;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    /*
    @Test
    public void creoJugadorYObtengoSuPuntaje() {
        Jugador jugador = new Jugador("carlos");
        Puntaje puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), 0);
    }
    @Test
    public void jugadorRecibePuntoPositivo(){
        Puntaje puntos= new PuntoPositivo();
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntos);
        Puntaje puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), 1);
    }
    @Test
    public void jugadorRecibePuntoNulo(){
        Puntaje puntos= new PuntoNulo();
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntos);
        Puntaje puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), 0);
    }
    @Test
    public void jugadorRecibePuntosNegativos(){
        Puntaje puntos= new PuntoNegativo();
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntos);
        Puntaje puntaje = jugador.obtenerPuntaje();
        assertEquals(puntaje.valor(), -1);
    }

    @Test
    public void jugadorRecibePuntajePusitivo(){
        Puntaje puntoPositivo= new PuntoPositivo();
        Puntaje puntaje= new Puntos();
        puntaje.aniadir(puntoPositivo);
        puntaje.aniadir(puntoPositivo);
        Jugador jugador = new Jugador("carlos");
        jugador.agregarPuntaje(puntaje);
        Puntaje puntaje1 = jugador.obtenerPuntaje();
        assertEquals(puntaje1.valor(), 2);
    }
    @Test
    public void obtengoMultiplicadorX2YLoAplico(){

        Jugador jugador = new Jugador("carlos");
        Map<Integer,Multiplicador> multiplicadores=jugador.obtenerMultiplicadores();
        Multiplicador  multiplicador= multiplicadores.get(2);
        Puntaje puntoPositivo= new PuntoPositivo();
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

     */
    @Test
    public void test001JugadorCreadoIntentaAplicarMultiplicadorPorSegundaVezLanzaMultiplicadorYaUsadoException(){
        try{
            Jugador jugador = new Jugador("carlos");
            jugador.activarMultiplicadorX2();
            jugador.activarMultiplicadorX2();
        } catch (MultiplicadorYaUsadoException error){

            Assertions.assertEquals("LanzaError", error.getmessage());
        }

    }

    @Test
    public void test002JugadorCreadoAplicarMultiplicadorPorPrimeraVezMultiplicaElPuntajeObtenidoEnUnaRonda(){
        Jugador jugador1 = new Jugador("carlos");
        try {
            jugador1.activarMultiplicadorX2();
        } catch (MultiplicadorYaUsadoException e) {
            System.out.println("entré a excepción");
        }

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("4");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("2");
        respuestaJugador1.agregarOpcion("4");

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);


        //creoRespuesta
        Pregunta unaPregunta = FabricaPreguntas.preguntaMultipleChoiceClasico("LALA", opcionesCorrectas, opcionesPosibles);
        unaPregunta.calificar(respuestas);

        respuestaJugador1.aplicarPuntaje();

        Assertions.assertEquals(4, jugador1.obtenerPuntaje().valor());
        }

    /*
    @Test
    public void test003JugadorCreadoAplicarMultiplicadorX3PorPrimeraVezMultiplicaElPuntajeObtenidoEnUnaRonda(){
        Jugador jugador1 = new Jugador("carlos");
        try {
            jugador1.activarMultiplicadorX3();
        } catch (MultiplicadorYaUsadoException e) {
            System.out.println("entré a excepción");
        }

        Opciones opcionesCorrectas = new Opciones();
        Opciones opcionesPosibles = new Opciones();
        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("4");
        opcionesCorrectas.agregarOpcion("1");

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");


        respuestaJugador1.agregarOpcion("2");
        respuestaJugador1.agregarOpcion("4");
        respuestaJugador1.agregarOpcion("1");

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);


        Pregunta unaPregunta = FabricaPreguntas.preguntaMultipleChoiceClasico("LALA", opcionesCorrectas, opcionesPosibles);
        unaPregunta.calificar(respuestas);

        respuestaJugador1.aplicarPuntaje();

        Assertions.assertEquals(9, jugador1.obtenerPuntaje().valor());
    }

     */

    }

