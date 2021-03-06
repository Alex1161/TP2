package edu.fiuba.algo3.modelo.PreguntaVofPenalizadoTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Errores.ExclusividadNoPermitida;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFPenalizadoTest {
    @Test
    public void test00VerifivoTipoYEnunciado() {
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("4 + 2 = 6",opcionCorrecta);

        assertEquals("VoFPenalizado", pregunta.getTipo());

}

    @Test
    public void test01PreguntaVoFPenalizadaConOpcionCorrectaVerdaderoSeLePasaOpcionVerdaderoDaTrue(){
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("4 + 2 = 6",opcionCorrecta);

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");

        assertTrue(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void test02PreguntaVoFPenalizadaConOpcionCorrectaVerdaderoSeLePasaOpcionFalsoDaFalse(){
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4",opcionCorrecta);

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");

        assertFalse(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void test03PreguntaVoFPenalizadaConOpcionCorrectaFalsoSeLePasaOpcionFalsoDaTrue(){
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Falso");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 3",opcionCorrecta);

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");

        assertTrue(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void test04PreguntaVoFPenalizadaConOpcionCorrectaFalsoSeLePasaOpcionVerdaderoDaFalse(){
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Falso");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 3",opcionCorrecta);

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");

        assertFalse(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void Test05PreguntaVoFPenalizadoJugadorUnoContestaMalJugadorDosBienRecibenMenosUnoYUnoPuntosRespectivamente(){
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Falso");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 3",opcionCorrecta);
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
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4",opcionCorrecta);
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
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4",opcionCorrecta);
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
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4",opcionCorrecta);
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
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4",opcionCorrecta);
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
        Opciones opcionCorrecta = new Opciones();
        opcionCorrecta.agregarOpcion("Verdadero");
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFPenalizado("2 + 2 = 4",opcionCorrecta);

        Respuesta respuesta = new Respuesta(new Jugador("Carlos"));

        assertThrows(ExclusividadNoPermitida.class,
                () -> {
                    pregunta.agregarComodin(new Exclusividad(), respuesta);
                });
    }

}
