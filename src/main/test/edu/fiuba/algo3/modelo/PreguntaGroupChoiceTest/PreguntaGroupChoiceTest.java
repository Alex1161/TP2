package edu.fiuba.algo3.modelo.PreguntaGroupChoiceTest;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    @Test
    public void test01PreguntaGroupChoiceRespuestaUnJugadorColocaTodasLasOpcionesEnElGrupoCorrectoDevuelvePuntajePositivo(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();


        opcionesCorrectasGrupo1.agregarOpcion("1978");
        opcionesCorrectasGrupo1.agregarOpcion("1986");


        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1978");
        opcionesPosibles.agregarOpcion("1986");


        Pregunta preguntaGroupChoice = FabricaPreguntas.preguntaGroupChoice("Elegir Las Opciones En el grupo Correcto",opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcionEnGrupo1("1978");
        respuestaJugador1.agregarOpcionEnGrupo1("1986");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 1,jugador1.obtenerPuntaje().valor());
    }

    @Test
    public void test02PreguntaGroupChoiceRespuestaJugadorEligeOpcionesEnGrupoIncorrectoDevuelvePuntajeNulo(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();


        opcionesCorrectasGrupo1.agregarOpcion("1978");
        opcionesCorrectasGrupo1.agregarOpcion("1986");


        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1978");


        Pregunta groupChoice = FabricaPreguntas.preguntaGroupChoice("Elegir Las Opciones En el grupo Correcto",opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcionEnGrupo2("1978");
        respuestaJugador1.agregarOpcionEnGrupo2("1986");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        groupChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.obtenerPuntaje().valor());
    }

    @Test
    public void test03PreguntaGroupChoiceRespuestaJugador1ContestaCorrectasEnGrupo1DevuelvePuntajePositivoJugador2LeFaltaUnaDevuelvePuntajeNulo(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();


        opcionesCorrectasGrupo1.agregarOpcion("gato");
        opcionesCorrectasGrupo1.agregarOpcion("perro");


        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("perro");
        opcionesPosibles.agregarOpcion("gato");
        opcionesPosibles.agregarOpcion("tomate");
        opcionesPosibles.agregarOpcion("pera");


        Pregunta preguntaGroupChoice = FabricaPreguntas.preguntaGroupChoice("Elegir Las Opciones En el grupo Correcto",opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Alberto");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcionEnGrupo1("perro");
        respuestaJugador1.agregarOpcionEnGrupo1("gato");
        respuestaJugador1.agregarOpcionEnGrupo2("pato");
        respuestaJugador1.agregarOpcionEnGrupo2("pera");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcionEnGrupo2("perro");
        respuestaJugador2.agregarOpcionEnGrupo2("gato");
        respuestaJugador2.agregarOpcionEnGrupo2("perro");
        respuestaJugador2.agregarOpcionEnGrupo1("gato");


        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 1,jugador1.obtenerPuntaje().valor());
        assertEquals( 0,jugador2.obtenerPuntaje().valor());
    }

    @Test
    public void test04PreguntaGroupChoiceRespuestaJugador1YJugador2RespondenCorrectamenteSumanPuntoPositivoAmbos(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();


        opcionesCorrectasGrupo1.agregarOpcion("gato");
        opcionesCorrectasGrupo1.agregarOpcion("perro");


        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("perro");
        opcionesPosibles.agregarOpcion("gato");
        opcionesPosibles.agregarOpcion("tomate");
        opcionesPosibles.agregarOpcion("pera");


        Pregunta preguntaGroupChoice = FabricaPreguntas.preguntaGroupChoice("Elegir Las Opciones En el grupo Correcto",opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Juan");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        respuestaJugador1.agregarOpcionEnGrupo1("gato");
        respuestaJugador1.agregarOpcionEnGrupo1("perro");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador2.agregarOpcionEnGrupo1("gato");
        respuestaJugador2.agregarOpcionEnGrupo1("perro");



        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 1,jugador1.obtenerPuntaje().valor());
        assertEquals( 1,jugador2.obtenerPuntaje().valor());
    }
/*
    @Test
    public void test05PreguntaGroupChoiceRespuestaJugador1SumaPuntoNuloYJugador2SumanPuntoPositivo(){
        Opciones opcionesCorrectasGrupo2 = new Opciones();


        opcionesCorrectasGrupo2.agregarOpcion("gato");
        opcionesCorrectasGrupo2.agregarOpcion("perro");


        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("perro");
        opcionesPosibles.agregarOpcion("gato");
        opcionesPosibles.agregarOpcion("tomate");
        opcionesPosibles.agregarOpcion("pera");


        Pregunta preguntaGroupChoice = FabricaPreguntas.preguntaGroupChoice("Elegir Las Opciones En el grupo Correcto",opcionesCorrectasGrupo2, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Juan");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        respuestaJugador1.agregarOpcionEnGrupo1("gato");
        respuestaJugador1.agregarOpcionEnGrupo1("perro");
        respuestaJugador1.agregarOpcionEnGrupo1("tomate");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador2.agregarOpcionEnGrupo2("gato");
        respuestaJugador2.agregarOpcionEnGrupo2("perro");



        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.obtenerPuntaje().valor());
        assertEquals( 1,jugador2.obtenerPuntaje().valor());
    }

 */

    @Test
    public void test06PreguntaGroupChoiceRespuestaJugador1SumaPuntoNuloYJugador2SumaPuntoNulo(){
        Opciones opcionesCorrectasGrupo2 = new Opciones();


        opcionesCorrectasGrupo2.agregarOpcion("gato");
        opcionesCorrectasGrupo2.agregarOpcion("perro");


        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("perro");
        opcionesPosibles.agregarOpcion("gato");
        opcionesPosibles.agregarOpcion("tomate");
        opcionesPosibles.agregarOpcion("pera");


        Pregunta preguntaGroupChoice = FabricaPreguntas.preguntaGroupChoice("Elegir Las Opciones En el grupo Correcto",opcionesCorrectasGrupo2, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Juan");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        respuestaJugador1.agregarOpcionEnGrupo1("gato");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador2.agregarOpcionEnGrupo2("perro");



        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0,jugador1.obtenerPuntaje().valor());
        assertEquals( 0,jugador2.obtenerPuntaje().valor());
    }
}
