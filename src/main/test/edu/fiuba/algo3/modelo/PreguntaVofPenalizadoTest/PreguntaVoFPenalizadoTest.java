package edu.fiuba.algo3.modelo.PreguntaVofPenalizadoTest;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFPenalizadoTest {
    @Test
    public void Test01PreguntaVoFPenalizadaConEnunciadoVerdaderoSeCrea(){

    Pregunta pregunta = FabricaPreguntas.preguntaVoFVerdaderaPenalizado("Enunciado");
    Opciones opcion = new Opciones();
    opcion.agregarOpcion("V");
    assertTrue(pregunta.esCorrecta(opcion));
}

    @Test
    public void Test02PreguntaVoFPenalizadaConEnunciadoVerdaderoSeCreaYSeTesteaConUnFalso(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFVerdaderaPenalizado("Enunciado");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("F");
        assertFalse(pregunta.esCorrecta(opcion));
    }

    @Test
    public void Test03PreguntaVoFPenalizadaConEnunciadoFalsoSeCreaYVerificaConFalso(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFFalsaPenalizado("Enunciado");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("F");
        assertTrue(pregunta.esCorrecta(opcion));
    }

    @Test
    public void Test04PreguntaVoFPenalizadaConEnunciadoFalsoSeCreaYSeTesteaConUnVerdadero(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFFalsaPenalizado("Enunciado");
        Opciones opcion = new Opciones();
        opcion.agregarOpcion("V");
        assertFalse(pregunta.esCorrecta(opcion));
    }
    @Test
    public void Test05PreguntaVoFFalsaPenalizadaSePrubaInteraccionConJugadores(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFFalsaPenalizado("Enunciado");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");
        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("V");
        respuesta2.agregarOpcion("F");
        List<Respuesta> respuestas= new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(-1,jugador1.obtenerPuntaje().valor());
        assertEquals(1,jugador2.obtenerPuntaje().valor());
    }
    @Test
    public void Test06PreguntaVoFVerdaderaPenalizadaSePrubaInteraccionConJugadores(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFVerdaderaPenalizado("Enunciado");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");
        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("V");
        respuesta2.agregarOpcion("F");
        List<Respuesta> respuestas= new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(1,jugador1.obtenerPuntaje().valor());
        assertEquals(-1,jugador2.obtenerPuntaje().valor());
    }

    @Test
    public void Test07PreguntaVoFTruePenalizadoSeAgregaMultiplicadorx2YSeVeReflejadoEnLosPuntajes(){

        Pregunta pregunta = FabricaPreguntas.preguntaVoFVerdaderaPenalizado("Enunciado");
        Jugador jugador1 = new Jugador("carlos");
        Jugador jugador2 = new Jugador("juan");
        Respuesta respuesta1= new Respuesta(jugador1);
        Respuesta respuesta2= new Respuesta(jugador2);
        respuesta1.agregarOpcion("V");
        respuesta2.agregarOpcion("F");
        List<Respuesta> respuestas= new ArrayList<>();
        pregunta.agregarMultiplicador(new Multiplicador(2), respuesta1);
        pregunta.agregarMultiplicador(new Multiplicador(3), respuesta2);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.calificar(respuestas);
        assertEquals(2,jugador1.obtenerPuntaje().valor());
        assertEquals(-3,jugador2.obtenerPuntaje().valor());
    }
}
