package edu.fiuba.algo3.modelo.TipoDePreguntaInvalidaTest;

import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.TipoDePreguntaInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TipoDePreguntaInvalidaTest {
    @Test
    public void intentoCrearUnaPreguntaDeTipoInvalida(){
        String tipoInvalido= "tipoX";
        Opciones opciones= new Opciones();
        String enunciado= "unEnunciado";
        CreadorDePreguntas creadorDePreguntas= new CreadorDePreguntas();
        assertThrows(TipoDePreguntaInvalidaException.class,
                () -> {
                    creadorDePreguntas.crearPregunta(tipoInvalido,enunciado,opciones,opciones);
                });

    }
}
