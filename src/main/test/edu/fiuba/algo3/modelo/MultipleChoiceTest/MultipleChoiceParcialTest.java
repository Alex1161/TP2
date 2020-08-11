package edu.fiuba.algo3.modelo.MultipleChoiceTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleChoiceParcialTest {
    @Test
    public void test01PreguntaMultipleChoiceParcialJugadorRespondeDosBienUnaMalRecibeCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si en verde");
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("no");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
    }

    @Test
    public void test02PreguntaMultipleChoiceParcialJugadorRespondeDosBienRecibeDosPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 2,jugador1.puntajeValorNumerico());
    }

    @Test
    public void test03PreguntaMultipleChoiceParcialJugadorContestaUnaBienRecibeUnPunto(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals( 1, jugador1.puntajeValorNumerico());
    }

    @Test
    public void test04PreguntaMultipleChoiceParcialAmbosJugadoresTienenUnaOpcionIncorrectaAmbosRecibenCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("no");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("si en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test05PreguntaMultipleChoiceParcialSeAgregaMultiplicadorLanzaException(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("perro");
        opcionesCorrectas.agregarOpcion("gato");
        opcionesCorrectas.agregarOpcion("loro");
        opcionesCorrectas.agregarOpcion("oso");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("perro");
        opcionesPosibles.agregarOpcion("gato");
        opcionesPosibles.agregarOpcion("loro");
        opcionesPosibles.agregarOpcion("oso");
        opcionesPosibles.agregarOpcion("lapiz");
        opcionesPosibles.agregarOpcion("computadora");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("mamiferos", opcionesCorrectas, opcionesPosibles);

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    preguntaMultipleChoice.agregarComodin(new MultiplicadorX3());
                });
    }

    @Test
    public void test06PreguntaMultipleChoiceParcialSeAgregaExclusividadUnoRespondeMalOtroBienEsteRecibeDoblePuntaje(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        preguntaMultipleChoice.agregarComodin(new Exclusividad());

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("si en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals(4, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test07PreguntaMultipleChoiceParcialSeAgregaExclusividadUnoRespondeMalOtroTambienAmbosRecibenCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        preguntaMultipleChoice.agregarComodin(new Exclusividad());

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("no");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no");
        respuestaJugador2.agregarOpcion("si en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test08PreguntaMultipleChoiceParcialSeAgregaExclusividadUnoRespondeBienOtroTambienAmbosRecibenCeroPuntos(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        preguntaMultipleChoice.agregarComodin(new Exclusividad());

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("si");
        respuestaJugador2.agregarOpcion("si en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals(0, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test09PreguntaMultipleChoiceParcialSeDobleAgregaExclusividadUnoRespondeMalOtroBienEsteRecibeCuadruplePuntaje(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceParcial("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

        preguntaMultipleChoice.agregarComodin(new Exclusividad());
        preguntaMultipleChoice.agregarComodin(new Exclusividad());

        Jugador jugador1 = new Jugador("pedrito");
        Jugador jugador2 = new Jugador("juanito");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("si");
        respuestaJugador1.agregarOpcion("si en verde");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("no en verde");
        respuestaJugador2.agregarOpcion("si en verde");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaMultipleChoice.calificar((listaDeRespuestas));

        assertEquals(8, jugador1.puntajeValorNumerico());
        assertEquals(0, jugador2.puntajeValorNumerico());
    }
}