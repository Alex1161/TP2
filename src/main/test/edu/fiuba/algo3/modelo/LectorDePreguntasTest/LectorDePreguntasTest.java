package edu.fiuba.algo3.modelo.LectorDePreguntasTest;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LectorDePreguntasTest {
    @Test
    public void prueboPreguntaFactory(){
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Falso");

        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("Verdadero");
        opcionesPosibles.agregarOpcion("Falso");

        CreadorDePreguntas preguntaFabrica = new CreadorDePreguntas();
        Pregunta pregunta= preguntaFabrica.crearPregunta("VoFPenalizado","2 + 2 = 3", opcionCorrecta, opcionesPosibles);
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


        pregunta = preguntaFabrica.crearPregunta("VoFClasico", "enunciado", opcionCorrecta, opcionesPosibles);
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
        LectorDePreguntas fabrica = new LectorDePreguntas();
        Pregunta pregunta = fabrica.recuperarPregunta("Pregunta.json");
    }

    @Test
    public void prueboPreguntaJson() throws IOException{
        LectorDePreguntas fabrica = new LectorDePreguntas();
        Pregunta pregunta = fabrica.recuperarPregunta("Pregunta.json");

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
        LectorDePreguntas fabrica= new LectorDePreguntas();
        List<Pregunta>  preguntas = fabrica.recuperarPreguntas("Preguntas.json");
    }

    @Test
    public void prueboLectorDePreguntas() throws IOException {
        LectorDePreguntas fabrica=new LectorDePreguntas();
        List<Pregunta>  preguntas = fabrica.recuperarPreguntas("Preguntas.json");
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
        respuesta1.agregarOpcion("Rojo");
        respuesta1.agregarOpcion("Verde");
        respuesta2.agregarOpcion("Azul");
        respuesta2.agregarOpcion("Naranja");
        respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(-2, jugador1.puntajeValorNumerico());
        assertEquals(2, jugador2.puntajeValorNumerico());

        pregunta = preguntas.get(4);
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

    @Test
    public void prueboLectorDePreguntasYSuContenido() throws IOException {
        String Verdadero="Verdadero";
        String Falso= "Falso";
        String Tomate="Tomate";
        String Pera= "Pera";
        String Perro="Perro";
        String Gato="Gato";

        LectorDePreguntas fabrica=new LectorDePreguntas();
        List<Pregunta>  preguntas = fabrica.recuperarPreguntas("Preguntas.json");
        Pregunta pregunta = preguntas.get(0);

        assertTrue(pregunta.obtenerOpciones().esta(Verdadero));
        assertTrue(pregunta.obtenerOpciones().esta(Falso));

        pregunta = preguntas.get(1);

        assertTrue(pregunta.obtenerOpciones().esta(Verdadero));
        assertTrue(pregunta.obtenerOpciones().esta(Falso));

        pregunta = preguntas.get(2);

        assertTrue(pregunta.obtenerOpciones().esta(Pera));
        assertTrue(pregunta.obtenerOpciones().esta(Perro));
        assertTrue(pregunta.obtenerOpciones().esta(Tomate));
        assertTrue(pregunta.obtenerOpciones().esta(Gato));

        pregunta = preguntas.get(3);

        assertTrue(pregunta.obtenerOpciones().esta("Rojo"));
        assertTrue(pregunta.obtenerOpciones().esta("Verde"));
        assertTrue(pregunta.obtenerOpciones().esta("Negro"));
        assertTrue(pregunta.obtenerOpciones().esta("Azul"));
        assertTrue(pregunta.obtenerOpciones().esta("Naranja"));

        pregunta = preguntas.get(4);

        assertTrue(pregunta.obtenerOpciones().esta(Pera));
        assertTrue(pregunta.obtenerOpciones().esta(Perro));
        assertTrue(pregunta.obtenerOpciones().esta(Tomate));
        assertTrue(pregunta.obtenerOpciones().esta(Gato));


    }
}
