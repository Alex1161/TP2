package edu.fiuba.algo3.modelo.OrderedChoice;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Jugador.MultiplicadorYaUsadoException;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedChoiceTest {

    @Test
    public void Test01PreguntaOrderedChoiceSeCreaCorretamente(){

        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("4");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("3");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderedChoice("de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Opciones opcion = new Opciones();

        opcion.agregarOpcion("1");
        opcion.agregarOpcion("2");
        opcion.agregarOpcion("3");
        opcion.agregarOpcion("4");

        assertTrue(preguntaOrderedChoice.esCorrecta(opcion));
    }

    @Test
    public void Test02PreguntaOrderedChoiceUnJugadorContestaBienYElOtroMalYSeAsignaCorrectamenteLosPuntajes01() {

        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("4");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("3");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderedChoice("de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");
        respuestaJugador1.agregarOpcion("3");
        respuestaJugador1.agregarOpcion("4");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("3");
        respuestaJugador2.agregarOpcion("4");
        respuestaJugador2.agregarOpcion("1");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaOrderedChoice.calificar((listaDeRespuestas));

        assertEquals( 1,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());

    }


    @Test
    public void Test03PreguntaOrderedChoiceLosJugadoresRespondenAmbosIncorrectamente() {

        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("4");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("3");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderedChoice("de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        respuestaJugador1.agregarOpcion("3");
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("4");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("1");
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("4");
        respuestaJugador2.agregarOpcion("3");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaOrderedChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.puntajeValorNumerico());
        assertEquals( 0,jugador2.puntajeValorNumerico());

    }

    @Test
    public void Test04PreguntaOrderedChoiceUnJugadorContestaBienYElOtroMalSeAgreganMultiplicadoresYSeAsignaCorrectamenteLosPuntajesNoAfectaElMultiplicadorAlSerUnaPreguntaSinPenalidad() {

        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("4");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("3");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderedChoice("de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");
        respuestaJugador1.agregarOpcion("3");
        respuestaJugador1.agregarOpcion("4");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("3");
        respuestaJugador2.agregarOpcion("4");
        respuestaJugador2.agregarOpcion("1");


        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    preguntaOrderedChoice.agregarComodin(new MultiplicadorX2(), respuestaJugador1);
                });
        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    preguntaOrderedChoice.agregarComodin(new MultiplicadorX3(), respuestaJugador1);
                });


    }
}
