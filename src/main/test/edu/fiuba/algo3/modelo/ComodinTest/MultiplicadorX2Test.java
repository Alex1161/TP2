package edu.fiuba.algo3.modelo.ComodinTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicadorX2Test {

    @Test
    public void test01MultiplicadorX2EsComparadoConOtroMultiplicadorX2DaTrue(){
        MultiplicadorX2 multiplicadorX2 = new MultiplicadorX2();

        assertTrue(multiplicadorX2.equals(new MultiplicadorX2()));
    }

    @Test
    public void test02MultiplicadorX2EsComparadoConOtroTipoDeComodinDaFalse(){
        MultiplicadorX2 multiplicadorX2 = new MultiplicadorX2();

        assertFalse(multiplicadorX2.equals(new Exclusividad()));
    }

    @Test
    public void test03MultiplicadorX2ValidarSinPenalidadLanzaException(){
        MultiplicadorX2 multiplicadorX2 = new MultiplicadorX2();
        Penalidad sinPenalidad = new SinPenalidad();

        assertThrows(MultiplicadorPreguntaSinPenalidadNoPermitidoException.class,
                ()->{
                    multiplicadorX2.validar(sinPenalidad);
                });
    }

    @Test
    public void test04MultiplicadorX2SeAplicaAPuntoPositivoYDevuelveElDobleDeEste(){
        MultiplicadorX2 multiplicadorX2 = new MultiplicadorX2();
        Puntaje puntaje = new PuntoPositivo();

        assertEquals(2, multiplicadorX2.aplicar(puntaje).valorNumerico());
    }

    @Test
    public void test05MultiplicadorX2SeAplicaADosPuntosYDevuelveElDobleDeEste(){
        MultiplicadorX2 multiplicadorX2 = new MultiplicadorX2();
        Puntaje puntaje = new PuntoPositivo().agregar(new PuntoPositivo());

        assertEquals(4, multiplicadorX2.aplicar(puntaje).valorNumerico());
    }

    @Test
    public void test06MultiplicadorX2SeAplicaAListaRespuestasEstasNoSonModificadas(){
        MultiplicadorX2 multiplicadorX2 = new MultiplicadorX2();
        Respuesta respuesta1 = new Respuesta(new Jugador("Carlos"));
        Respuesta respuesta2 = new Respuesta(new Jugador("Luis"));

        respuesta1.setPuntajeObtenido(new PuntoPositivo());
        respuesta2.setPuntajeObtenido(new PuntoPositivo());

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        multiplicadorX2.aplicar(respuestas);

        assertEquals(1, respuesta1.calificacionValorNumerico());
        assertEquals(1, respuesta2.calificacionValorNumerico());
    }

}
