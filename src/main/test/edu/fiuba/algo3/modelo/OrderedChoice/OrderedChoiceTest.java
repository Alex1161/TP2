package edu.fiuba.algo3.modelo.OrderedChoice;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Penalidad.MultiplicadorNoPermitido;
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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Opciones opcion = new Opciones();

        opcion.agregarOpcion("1");
        opcion.agregarOpcion("2");
        opcion.agregarOpcion("3");
        opcion.agregarOpcion("4");

        assertTrue(preguntaOrderedChoice.sonCorrectas(opcion));
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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

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
    public void Test04PreguntaOrderedChoiceSeAgregaMultiplicadoresYSeLanzaException() {

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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Respuesta respuesta = new Respuesta(new Jugador("Carlos"));

        assertThrows(MultiplicadorNoPermitido.class,
                () -> {
                    preguntaOrderedChoice.agregarComodin(new MultiplicadorX2(), respuesta);
                });

        assertThrows(MultiplicadorNoPermitido.class,
                () -> {
                    preguntaOrderedChoice.agregarComodin(new MultiplicadorX3(), respuesta);
                });
    }

    @Test
    public void Test05PreguntaOrderedChoiceSeAgregaExclusividadJugadorRespondeMalElOtroBienEsteRecibeDoblePuntaje() {

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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

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
        respuestaJugador2.agregarOpcion("3");
        respuestaJugador2.agregarOpcion("4");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaOrderedChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaOrderedChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.puntajeValorNumerico());
        assertEquals( 2,jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test06PreguntaOrderedChoiceSeAgregaExclusividadJugadorRespondeMalElOtroTambienAmbosRecibenCeroPuntos() {

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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

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

        preguntaOrderedChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaOrderedChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test07PreguntaOrderedChoiceSeAgregaExclusividadJugadorRespondeBienElOtroTambienAmbosRecibenCeroPuntos() {

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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");
        respuestaJugador1.agregarOpcion("3");
        respuestaJugador1.agregarOpcion("4");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("1");
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("3");
        respuestaJugador2.agregarOpcion("4");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaOrderedChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaOrderedChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void Test08PreguntaOrderedChoiceSeAgregaDobleExclusividadUnoRespondeMalElOtroBienEsteRecibeElDuadruplePuntaje() {

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

        Pregunta preguntaOrderedChoice = CreadorDePreguntas.preguntaOrderedChoice("Ordenar de menor a mayor ", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");
        respuestaJugador1.agregarOpcion("4");
        respuestaJugador1.agregarOpcion("3");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("1");
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("3");
        respuestaJugador2.agregarOpcion("4");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaOrderedChoice.agregarComodin(new Exclusividad(), respuestaJugador1);
        preguntaOrderedChoice.agregarComodin(new Exclusividad(), respuestaJugador2);

        preguntaOrderedChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 4, jugador2.puntajeValorNumerico());
    }
}
