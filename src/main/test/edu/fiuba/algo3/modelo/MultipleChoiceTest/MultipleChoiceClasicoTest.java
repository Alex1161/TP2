package edu.fiuba.algo3.modelo.MultipleChoiceTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MultipleChoiceClasicoTest {

    @Test
    public void test01PreguntaMultipleChoiceClasicoSeCreaYSePasaOpcionesCorrectasEnDiferenteOrdenDaTrue(){

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("Mútiplo de dos: ", opcionesCorrectas, opcionesPosibles);

        Opciones opcion = new Opciones();

        opcion.agregarOpcion("4");
        opcion.agregarOpcion("2");

        assertTrue(preguntaMultipleChoice.sonCorrectas(opcion));
    }

    @Test
    public void test02PreguntaMultipleChoiceClasicoSeCreaYSePasaOpcionesCorrectasEnMismoOrdenDaTrue(){

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("Mútiplo de dos: ", opcionesCorrectas, opcionesPosibles);

        Opciones opcion = new Opciones();

        opcion.agregarOpcion("2");
        opcion.agregarOpcion("4");

        assertTrue(preguntaMultipleChoice.sonCorrectas(opcion));
    }

    @Test
    public void test03PreguntaMultipleChoiceClasicoSeCreaYSePasaOpcionesIncorrectasDaFalse(){

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("Mútiplo de dos: ", opcionesCorrectas, opcionesPosibles);

        Opciones opcion = new Opciones();

        opcion.agregarOpcion("1");
        opcion.agregarOpcion("4");

        assertFalse(preguntaMultipleChoice.sonCorrectas(opcion));
    }

    @Test
    public void test04PreguntaMultipleChoiceClasicoUnJugadorRespondeMalOtroBienEsteRecibeUnPuntoPositivo(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("no en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 1,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test05PreguntaMultipleChoiceClasicoAmbosJugadoresContestanMalRecibenCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("no");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("no en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test06PreguntaMultipleChoiceClasicoAmbosJugadoresContestanBienYSeLesAsignaUnPunto(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("si en verde");
        respuestaJugador2.agregarOpcion("si");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 1,jugador1.puntajeValorNumerico());
        assertEquals( 1,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test07PreguntaMultipleChoiceClasicoSeAgregaMultiplicadorX2LanzaExcepcion(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Respuesta respuesta = new Respuesta(new Jugador("Carlos"));

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    preguntaMultipleChoice.agregarComodin(new MultiplicadorX2(), respuesta);
                });
    }

    @Test
    public void Test08PreguntaMultipleChoiceClasicoSeAgregaMultiplicadorX3LanzaExcepcion(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Respuesta respuesta = new Respuesta(new Jugador("Carlos"));

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    preguntaMultipleChoice.agregarComodin(new MultiplicadorX3(), respuesta);
                });
    }

    @Test
    public void Test09PreguntaMultipleChoiceClasicoSeAgregaExclusividadUnoContestaMalElOtroBienEsteRecibeDoblePuntaje(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("no en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 2,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test10PreguntaMultipleChoiceClasicoSeAgregaExclusividadUnoContestaMalElOtroTambienAmbosRecibenCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("no");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("no en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test11PreguntaMultipleChoiceClasicoSeAgregaExclusividadUnoContestaBienElOtroTambienAmbosRecibenCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("si en verde");
        respuestaJugador2.agregarOpcion("si");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test12PreguntaMultipleChoiceClasicoSeAgregaDobleExclusividadUnoContestaMalElOtroBienEsteRecibeCuadruplePuntaje(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = CreadorDePreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("si en verde");
        respuestaJugador2.agregarOpcion("no");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.agregarComodin(new Exclusividad(), respuestaJugador1);
        preguntaMultipleChoice.agregarComodin(new Exclusividad(), respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 4,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());
    }

}
