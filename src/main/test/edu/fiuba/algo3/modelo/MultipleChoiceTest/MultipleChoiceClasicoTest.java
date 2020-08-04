package edu.fiuba.algo3.modelo.MultipleChoiceTest;

import edu.fiuba.algo3.modelo.Calificador.AsignadorClasico;
import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MultipleChoiceClasicoTest {

    @Test
    public void Test01PreguntaMultipleChoiceSeCreaCorretamente(){

    Opciones opcionesPosibles = new Opciones();

    opcionesPosibles.agregarOpcion("1");
    opcionesPosibles.agregarOpcion("2");
    opcionesPosibles.agregarOpcion("3");
    opcionesPosibles.agregarOpcion("4");

    Opciones opcionesCorrectas = new Opciones();

    opcionesCorrectas.agregarOpcion("2");
    opcionesCorrectas.agregarOpcion("4");

    Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceClasico("mutiplo de dos: ", opcionesCorrectas, opcionesPosibles);

    Opciones opcion = new Opciones();

    opcion.agregarOpcion("2");
    opcion.agregarOpcion("4");

    assertTrue(preguntaMultipleChoice.esCorrecta(opcion));
}

    @Test
    public void Test02PreguntaMultipleChoiceAsignaCorrectamenteLosPuntajes01(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

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

        assertEquals( 1,jugador1.obtenerPuntaje().valor());
        assertEquals( 0,jugador2.obtenerPuntaje().valor());
    }

    @Test
    public void Test03PreguntaMultipleChoiceUnJugadorContestaUnaBienYUnaMalYNoLeAsignaPuntaje(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

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

        assertEquals( 0,jugador1.obtenerPuntaje().valor());
        assertEquals( 0,jugador2.obtenerPuntaje().valor());


    }

    @Test
    public void Test04PreguntaMultipleChoiceLosDosJugadoresContestanBienYSeLesasignaUnPunto(){

        Opciones opcionesCorrectas = new Opciones();

        opcionesCorrectas.agregarOpcion("si");
        opcionesCorrectas.agregarOpcion("si en verde");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("si");
        opcionesPosibles.agregarOpcion("si en verde");
        opcionesPosibles.agregarOpcion("no");
        opcionesPosibles.agregarOpcion("no en verde");

        Pregunta preguntaMultipleChoice = FabricaPreguntas.preguntaMultipleChoiceClasico("¿Hoy se sale?", opcionesCorrectas, opcionesPosibles);

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

        assertEquals( 1,jugador1.obtenerPuntaje().valor());
        assertEquals( 1,jugador2.obtenerPuntaje().valor());


    }
}