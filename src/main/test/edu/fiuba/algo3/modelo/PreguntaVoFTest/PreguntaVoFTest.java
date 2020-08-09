package edu.fiuba.algo3.modelo.PreguntaVoFTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaVoFTest {

     @Test
    public void Test01PreguntaVoFConEnunciadoVerdaderoSeCrea(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("Enunciado","Verdadero");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");
        assertTrue(pregunta.esCorrecta(opcion));
    }

    @Test
    public void Test02PreguntaVoFConEnunciadoVerdaderoSeCreaYSeTesteaConUnFalso(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("Enunciado","Verdadero");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");
        assertFalse(pregunta.esCorrecta(opcion));
    }

    @Test
    public void Test03PreguntaVoFConEnunciadoFalsoSeCreaYVerificaConFalso(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("Enunciado","Falso");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Falso");
        assertTrue(pregunta.esCorrecta(opcion));
    }

    @Test
    public void Test04PreguntaVoFConEnunciadoFalsoSeCreaYSeTesteaConUnVerdadero(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("Enunciado","Falso");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("Verdadero");
        assertFalse(pregunta.esCorrecta(opcion));
    }
    @Test
    public void Test05PreguntaVoFFalsaSePrubaInteraccionConJugadores(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("Enunciado","Falso");
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
    public void Test06PreguntaVoFTrueSePrubaInteraccionConJugadores(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("Enunciado","Verdadero");
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
        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    pregunta.agregarComodin(new MultiplicadorX2());
                });
    }

    @Test
    public void Test08PreguntaVoFClasicoSeAgregaMultiplicadorX3LanzaException(){
        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    pregunta.agregarComodin(new MultiplicadorX3());
                });
    }

    @Test
    public void Test09PreguntaVoFSeAgregaExclusividadUnoRespondeMalElOtroBienEsteRecibePutajeDoble(){
        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad());
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(2, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test10PreguntaVoFSeAgregaExclusividadUnoRespondeMalElOtroTambienAmbosTienenCeroDePuntaje(){
        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Falso");
        respuesta2.agregarOpcion("Falso");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad());
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test11PreguntaVoFSeAgregaExclusividadUnoRespondeBienElOtroTambienAmbosTienenCeroDePuntaje(){
        Pregunta pregunta = FabricaPreguntas.preguntaVoFClasico("2 + 2 = 4","Verdadero");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");

        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("Verdadero");
        respuesta2.agregarOpcion("Verdadero");

        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarComodin(new Exclusividad());
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.calificar(respuestas);

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }


}
