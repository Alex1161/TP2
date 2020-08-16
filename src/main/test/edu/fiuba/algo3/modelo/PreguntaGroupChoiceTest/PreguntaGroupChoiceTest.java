package edu.fiuba.algo3.modelo.PreguntaGroupChoiceTest;

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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaGroupChoiceTest {

    @Test
    public void test01PreguntaGroupChoiceSeLePasaOpcionesCorrectasDevulveTrue(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        assertTrue(preguntaGroupChoice.sonCorrectas(opcionesCorrectasGrupo1));
    }

    @Test
    public void test02PreguntaGroupChoiceSeLePasaOpcionesIncorrectasDevulveFalse(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Opciones opcionesIncorrectas = new Opciones();
        opcionesIncorrectas.agregarOpcion("3");
        opcionesIncorrectas.agregarOpcion("2");
        opcionesIncorrectas.agregarOpcion("1");

        assertFalse(preguntaGroupChoice.sonCorrectas(opcionesIncorrectas));
    }

    @Test
    public void test03PreguntaGroupChoiceJugadorUnoColocaLasRespuestasEnElGrupoCorrectoJugadorDosNoRecibenUnoYCeroPuntosRespectivamente(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("4");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("1");
        respuestaJugador2.agregarOpcion("2");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 1, jugador1.puntajeValorNumerico());
        assertEquals( 0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test04PreguntaGroupChoiceJugadorDosColocaLasRespuestasEnElGrupoCorrectoJugadorUnoNoRecibenUnoYCeroPuntosRespectivamente(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("4");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 1, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test05PreguntaGroupChoiceAmbosJugadoresColocanRespuestasEnElGrupoIncorrectoAmbosRecibenCeroPuntos(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("1");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test06PreguntaGroupChoiceRespuestaJugador1YJugador2RespondenCorrectamenteSumanPuntoPositivoAmbos(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("4");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("4");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 1, jugador1.puntajeValorNumerico());
        assertEquals( 1, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test07PreguntaGroupChoiceSeLeAgregaMultiplicadorX2LanzaException(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    Respuesta respuesta = new Respuesta(new Jugador("Carlos"));
                    preguntaGroupChoice.agregarComodin(new MultiplicadorX2(), respuesta);
                });
    }

    @Test
    public void test08PreguntaGroupChoiceSeLeAgregaMultiplicadorX3LanzaException(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                () -> {
                    Respuesta respuesta = new Respuesta(new Jugador("Carlos"));
                    preguntaGroupChoice.agregarComodin(new MultiplicadorX3(), respuesta);
                });
    }

    @Test
    public void test09PreguntaGroupChoiceSeLeAgregaExclusividadAmbosRespondenBienTienenCeroPuntos(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("4");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("4");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test10PreguntaGroupChoiceSeLeAgregaExclusividadAmbosRespondenMalTienenCeroPuntos(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("2");
        respuestaJugador2.agregarOpcion("3");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.agregarComodin(new Exclusividad(), respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 0, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test11PreguntaGroupChoiceSeLeAgregaExclusividadJugadorUnoRespondeMalJugadorDosBienEsteRecibeDoblePuntaje(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("4");
        respuestaJugador2.agregarOpcion("2");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.agregarComodin(new Exclusividad(), respuestaJugador1);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 2, jugador2.puntajeValorNumerico());
    }

    @Test
    public void test12PreguntaGroupChoiceSeLeAgregaDobleExclusividadJugadorUnoRespondeMalJugadorDosBienEsteRecibeCuadruplePuntaje(){
        Opciones opcionesCorrectasGrupo1 = new Opciones();

        opcionesCorrectasGrupo1.agregarOpcion("2");
        opcionesCorrectasGrupo1.agregarOpcion("4");

        Opciones opcionesPosibles = new Opciones();

        opcionesPosibles.agregarOpcion("1");
        opcionesPosibles.agregarOpcion("2");
        opcionesPosibles.agregarOpcion("3");
        opcionesPosibles.agregarOpcion("4");

        String enunciado = "Poner en el grupo 1 los numeros pares y en el grupo 2 los impares";
        Pregunta preguntaGroupChoice = CreadorDePreguntas.preguntaGroupChoice(enunciado, opcionesCorrectasGrupo1, opcionesPosibles);

        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion("1");
        respuestaJugador1.agregarOpcion("2");

        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion("4");
        respuestaJugador2.agregarOpcion("2");

        List<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
        listaDeRespuestas.add(respuestaJugador1);
        listaDeRespuestas.add(respuestaJugador2);

        preguntaGroupChoice.agregarComodin(new Exclusividad(), respuestaJugador1);
        preguntaGroupChoice.agregarComodin(new Exclusividad(), respuestaJugador2);

        preguntaGroupChoice.calificar((listaDeRespuestas));

        assertEquals( 0, jugador1.puntajeValorNumerico());
        assertEquals( 4, jugador2.puntajeValorNumerico());
    }
}
