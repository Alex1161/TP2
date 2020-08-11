package edu.fiuba.algo3.modelo.MultipleChoiceTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Penalidad.ExclusividadPreguntaConPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleChoicePenalizadoTest {

    @Test
    public void test01PreguntaMultipleChoicePenalizadoUnoTieneDosBienElOtroTieneDosMalRecibenDosPuntosPositivosYDosPuntosNegativosRespectivamente(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoicePenalizado("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si en verde");
        respuestaJugador1.agregarOpcion("si");


        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no en verde");
        respuestaJugador2.agregarOpcion("no");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 2,jugador1.puntajeValorNumerico());
        assertEquals( -2,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test02PreguntaMultipleChoicePenalizadoUnoRespondeDosBienElOtroRespondeUnaMalRecibenDosPositivosYUnNegativoRespectivamente(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoicePenalizado("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 2,jugador1.puntajeValorNumerico());
        assertEquals( -1,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test03PreguntaMultipleChoicePenalizadoUnJugadorContestaUnaBienYUnaMalYAsignaCorrectamente(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoicePenalizado("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("no");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test04PreguntaMultipleChoiceUnJugadorContestaDosMalYUnaBienYasignaCorrectamente(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoicePenalizado("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("no en verde");
        respuestaJugador1.agregarOpcion("no");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( -1, jugador1.puntajeValorNumerico());
    }

    @Test
    public void test05PreguntaMultipleChoiceAsignaCorrectamenteLosPuntajesConMultiplicadores2y3(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoicePenalizado("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("no en verde");

        preguntaMultipleChoice.agregarComodin(new MultiplicadorX2(), respuestaJugador1);
        preguntaMultipleChoice.agregarComodin(new MultiplicadorX3(), respuestaJugador2);

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 4,jugador1.puntajeValorNumerico());
        assertEquals( -6,jugador2.puntajeValorNumerico());
    }

    @Test
    public void test06PreguntaMultipleChoicePenalizadoSeAgregaExclusividadLanzaException(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoicePenalizado("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        assertThrows(ExclusividadPreguntaConPenalidadNoPermitidoException.class,
                () -> {
                    preguntaMultipleChoice.agregarComodin(new Exclusividad());
                });
    }
}
