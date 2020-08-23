package edu.fiuba.algo3.modelo.ComodinTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Errores.MultiplicadorNoPermitido;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.Pregunta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorX3Test {

    @Test
    public void test01MultiplicadorX3EsComparadoConOtroMultiplicadorX3DaTrue(){
        MultiplicadorX3 multiplicadorX3 = new MultiplicadorX3();

        assertTrue(multiplicadorX3.equals(new MultiplicadorX3()));
    }

    @Test
    public void test02MultiplicadorX3EsComparadoConOtroTipoDeComodinDaFalse(){
        MultiplicadorX3 multiplicadorX3 = new MultiplicadorX3();

        assertFalse(multiplicadorX3.equals(new Exclusividad()));
    }

    @Test
    public void test03MultiplicadorX3ValidarSinPenalidadLanzaException(){
        MultiplicadorX3 multiplicadorX3 = new MultiplicadorX3();
        Penalidad sinPenalidad = new SinPenalidad();

        assertThrows(MultiplicadorNoPermitido.class,
                ()->{
                    multiplicadorX3.validar(sinPenalidad);
                });
    }

    @Test
    public void test04MultiplicadorX3SeAplicaAPuntoPositivoYDevuelveElTripleDeEste(){
        MultiplicadorX3 multiplicadorX3 = new MultiplicadorX3();
        Puntaje puntaje = new PuntoPositivo();

        assertEquals(3, multiplicadorX3.aplicar(puntaje).valorNumerico());
    }

    @Test
    public void test05MultiplicadorX3SeAplicaADosPuntosYDevuelveElTripleDeEste(){
        MultiplicadorX3 multiplicadorX3 = new MultiplicadorX3();
        Puntaje puntaje = new PuntoPositivo().agregar(new PuntoPositivo());

        assertEquals(6, multiplicadorX3.aplicar(puntaje).valorNumerico());
    }

    @Test
    public void test06MultiplicadorX3SeAplicaAListaRespuestasEstasNoSonModificadas(){
        MultiplicadorX3 multiplicadorX3 = new MultiplicadorX3();
        Respuesta respuesta1 = new Respuesta(new Jugador("Carlos"));
        Respuesta respuesta2 = new Respuesta(new Jugador("Luis"));

        respuesta1.setPuntajeObtenido(new PuntoPositivo());
        respuesta2.setPuntajeObtenido(new PuntoPositivo());

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        multiplicadorX3.aplicar(respuestas);

        assertEquals(1, respuesta1.puntaje().valorNumerico());
        assertEquals(1, respuesta2.puntaje().valorNumerico());
    }

}
