package edu.fiuba.algo3.modelo.OrderedChoice;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderedChoiceTest {

    @Test
    public void Test01PreguntaOrderedChoiceSeCreaCorretamente(){

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderecChoice("de menor a mayor ", opcionesPosibles);

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

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderecChoice("de menor a mayor ", opcionesPosibles);

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

        assertEquals( 1,jugador1.obtenerPuntaje().valor());
        assertEquals( 0,jugador2.obtenerPuntaje().valor());

    }


    @Test
    public void Test03PreguntaOrderedChoiceLosJugadoresRespondenAmbosIncorrectamente() {

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        Pregunta preguntaOrderedChoice = FabricaPreguntas.preguntaOrderecChoice("de menor a mayor ", opcionesPosibles);

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

        assertEquals( 0,jugador1.obtenerPuntaje().valor());
        assertEquals( 0,jugador2.obtenerPuntaje().valor());

    }
}
