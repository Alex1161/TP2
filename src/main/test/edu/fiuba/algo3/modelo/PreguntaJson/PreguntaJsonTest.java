package edu.fiuba.algo3.modelo.PreguntaJson;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaJsonTest {
    @Test
    public void prueboPreguntaFactory(){
        Opciones o=new Opciones();
        o.agregarOpcion("Falso");
        FabricaPreguntas preguntaFabrica= new FabricaPreguntas();
        Pregunta pregunta= preguntaFabrica.crearPregunta("VoFPenalizado","enunciado",o,new Opciones());
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(-1, jugador1.puntajeValorNumerico());
        assertEquals(1, jugador2.puntajeValorNumerico());
        pregunta= preguntaFabrica.crearPregunta("VoFClasico","enunciado",o,new Opciones());
        jugador1 = new Jugador("carlos");
        jugador2 = new Jugador("juan");
        respuesta1 = new Respuesta(jugador1);
        respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");
        respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(1, jugador2.puntajeValorNumerico());


    }
    @Test
    public void pruebaDePreguntaJson() throws IOException {
        JsonFabrica fabrica =new JsonFabrica();
        Pregunta pregunta= fabrica.recuperar();
    }
    @Test
    public void prueboPreguntaJson()throws IOException {
        JsonFabrica fabrica=new JsonFabrica();
        Pregunta pregunta = fabrica.recuperar();

        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(-1, jugador1.puntajeValorNumerico());
        assertEquals(1, jugador2.puntajeValorNumerico());
    }
    @Test
    public void pruebaDePreguntasJson() throws IOException {
        JsonFabrica fabrica= new JsonFabrica();
        List<Pregunta>  preguntas= fabrica.recuperarPreguntas();
    }

    @Test
    public void prueboPreguntasJson()throws IOException {
        JsonFabrica fabrica=new JsonFabrica();
        List<Pregunta>  preguntas = fabrica.recuperarPreguntas();
        Pregunta pregunta = preguntas.get(0);
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(1, jugador2.puntajeValorNumerico());

        pregunta=preguntas.get(1);
        jugador1 = new Jugador("carlos");
        jugador2 = new Jugador("juan");
        respuesta1 = new Respuesta(jugador1);
        respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");
        respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(-1, jugador1.puntajeValorNumerico());
        assertEquals(1, jugador2.puntajeValorNumerico());

        pregunta=preguntas.get(2);
        jugador1 = new Jugador("carlos");
        jugador2 = new Jugador("juan");
        respuesta1 = new Respuesta(jugador1);
        respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Perro");
        respuesta1.agregarOpcion("Gato");
        respuesta2.agregarOpcion("Tomate");
        respuesta2.agregarOpcion("Pera");
        respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(1, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());

        pregunta=preguntas.get(3);
        jugador1 = new Jugador("carlos");
        jugador2 = new Jugador("juan");
        respuesta1 = new Respuesta(jugador1);
        respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Perro");
        respuesta1.agregarOpcion("Gato");
        respuesta2.agregarOpcion("Tomate");
        respuesta2.agregarOpcion("Pera");
        respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(2, jugador1.puntajeValorNumerico());
        assertEquals(-2, jugador2.puntajeValorNumerico());

        pregunta=preguntas.get(4);
        jugador1 = new Jugador("carlos");
        jugador2 = new Jugador("juan");
        respuesta1 = new Respuesta(jugador1);
        respuesta2 = new Respuesta(jugador2);
        respuesta1.agregarOpcion("Perro");
        respuesta1.agregarOpcion("Gato");
        respuesta2.agregarOpcion("Tomate");
        respuesta2.agregarOpcion("Pera");
        respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(2, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());


    }
}