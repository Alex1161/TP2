package edu.fiuba.algo3.modelo.PreguntaVoFTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Penalidad.MultiplicadorNoPermitido;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaVoFClasicoTest {
    @Test
    public void test00VerifivoTipoYEnunciado() {
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("4 + 2 = 6","Verdadero");

        assertEquals("VoFClasico", pregunta.getTipo());

    }

    @Test
    public void Test01PreguntaVoFClasicoConOpcionCorrectaVerdaderoSeLePasaUnaOpcionVerdaderoDaTrue(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");

        assertTrue(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void Test02PreguntaVoFClasicoConOpcionCorrectaVerdaderoSeLePasaUnaOpcionFalsoDaFalse(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");

        assertFalse(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void Test03PreguntaVoFClasicoConOpcionCorrectaFalsoSeLePasaUnaOpcionFalsoDaTrue(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 1 = 4","Falso");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");

        assertTrue(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void Test04PreguntaVoFClasicoConOpcionCorrectaFalsoSeLePasaUnaOpcionVerdaderoDaFalse(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("Enunciado","Falso");

        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");

        assertFalse(pregunta.sonCorrectas(opcion));
    }

    @Test
    public void Test05PreguntaVoFClasicoJugadorUnoContestaMalJugadorDosBienRecibenCeroYUnoPuntosRespectivamente(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 3","Falso");
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

        assertEquals(0,jugador1.puntajeValorNumerico());
        assertEquals(1,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test06PreguntaVoFClasicoJugadorUnoContestaBienJugadorDosMalRecibenUnoYCeroPuntosRespectivamente(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("Enunciado","Verdadero");
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
        assertEquals(0,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test07PreguntaVoFClasicoSeAgregaMultiplicadorX2LanzaException(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");

        assertThrows(MultiplicadorNoPermitido.class,
                () -> {
                    Respuesta respuesta = new Respuesta(new Jugador("Carlos"));
                    pregunta.agregarComodin(new MultiplicadorX2(), respuesta);
                });
    }

    @Test
    public void Test08PreguntaVoFClasicoSeAgregaMultiplicadorX3LanzaException(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");

            assertThrows(MultiplicadorNoPermitido.class,
                    () -> {
                        Respuesta respuesta = new Respuesta(new Jugador("Carlos"));
                        pregunta.agregarComodin(new MultiplicadorX3(), respuesta);
                    });
    }

    @Test
    public void Test09PreguntaVoFSeAgregaExclusividadUnoRespondeMalElOtroBienEsteRecibePutajeDoble(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad(), respuesta1);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(2, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test10PreguntaVoFSeAgregaExclusividadUnoRespondeMalElOtroTambienAmbosTienenCeroDePuntaje(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Falso");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad(), respuesta2);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test11PreguntaVoFSeAgregaExclusividadUnoRespondeBienElOtroTambienAmbosTienenCeroDePuntaje(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Verdadero");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad(), respuesta1);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test12PreguntaVoFSeAgregaDosExclusividadUnoRespondeBienElOtroTambienAmbosTienenCeroDePuntaje(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Verdadero");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad(), respuesta1);
        pregunta.agregarComodin(new Exclusividad(), respuesta2);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test13PreguntaVoFSeAgregaDosExclusividadUnoRespondeBienElOtroMalElPrimeroRecibeCuatroPuntos(){
        Pregunta pregunta = CreadorDePreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad(), respuesta1);
        pregunta.agregarComodin(new Exclusividad(), respuesta2);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(4, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

}
