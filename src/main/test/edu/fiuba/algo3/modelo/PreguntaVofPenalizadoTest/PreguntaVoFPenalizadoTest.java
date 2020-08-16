package edu.fiuba.algo3.modelo.PreguntaVofPenalizadoTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Penalidad.ExclusividadPreguntaConPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFPenalizadoTest {

    @Test
    public void test01PreguntaVoFPenalizadaConOpcionCorrectaVerdaderoSeLePasaOpcionVerdaderoDaTrue(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("4 + 2 = 6","Verdadero");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");

        assertTrue(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void test02PreguntaVoFPenalizadaConOpcionCorrectaVerdaderoSeLePasaOpcionFalsoDaFalse(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4","Verdadero");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");

        assertFalse(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void test03PreguntaVoFPenalizadaConOpcionCorrectaFalsoSeLePasaOpcionFalsoDaTrue(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 3","Falso");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");

        assertTrue(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void test04PreguntaVoFPenalizadaConOpcionCorrectaFalsoSeLePasaOpcionVerdaderoDaFalse(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 3","Falso");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");

        assertFalse(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void Test05PreguntaVoFPenalizadoJugadorUnoContestaMalJugadorDosBienRecibenMenosUnoYUnoPuntosRespectivamente(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 3","Falso");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(-1,jugador1.puntajeValorNumerico());
        assertEquals(1,jugador2.puntajeValorNumerico());
    }
    @Test
    public void test06PreguntaVoFPenalizadoJugadorUnoContestaBienJugadorDosMalRecibenUnoYMenosUnoPuntosRespectivamente(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(1,jugador1.puntajeValorNumerico());
        assertEquals(-1,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test07PreguntaVoFPenalizadoSeAgregaMultiplicadorX2YSeVeReflejadoEnLosPuntajes(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new MultiplicadorX2(), respuesta1);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(2,jugador1.puntajeValorNumerico());
        assertEquals(-1,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test08PreguntaVoFPenalizadoSeAgregaMultiplicadorx3YSeVeReflejadoEnLosPuntajes(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new MultiplicadorX3(), respuesta1);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(3,jugador1.puntajeValorNumerico());
        assertEquals(-1,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test09PreguntaVoFPenalizadoSeAgregaMultiplicadorx2YX3SeVeReflejadoEnLosPuntajes(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new MultiplicadorX2(), respuesta1);
        pregunta.agregarComodin(new MultiplicadorX3(), respuesta2);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(2, jugador1.puntajeValorNumerico());
        assertEquals(-3, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test10PreguntaVoFPenalizadoSeAgregaExclusividadLanzaException(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4","Verdadero");

        Respuesta respuesta = new Respuesta(new Jugador("Carlos"));

        assertThrows(ExclusividadPreguntaConPenalidadNoPermitidoException.class,
                () -> {
                    pregunta.agregarComodin(new Exclusividad(), respuesta);
                });
    }

}
