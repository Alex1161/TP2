package edu.fiuba.algo3.modelo.ComodinTest;

import edu.fiuba.algo3.modelo.Comodin.ComodinVacio;
import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.ExclusividadPreguntaConPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExclusividadTest {

    @Test
    public void test01ExclusividadEsComparadoConOtraExclusividadDaTrue(){
        Exclusividad exclusividad = new Exclusividad();

        assertTrue(exclusividad.equals(new Exclusividad()));
    }

    @Test
    public void test02ExclusividadEsComparadoConOtroTipoDeComodinDaFalse(){
        Exclusividad exclusividad = new Exclusividad();

        assertFalse(exclusividad.equals(new ComodinVacio()));
    }

    @Test
    public void test03ExclusividadValidarConPenalidadLanzaException(){
        Exclusividad exclusividad = new Exclusividad();
        Penalidad conPenalidad = new ConPenalidad();

        assertThrows(ExclusividadPreguntaConPenalidadNoPermitidoException.class,
                ()->{
                    exclusividad.validar(conPenalidad);
                });
    }

    @Test
    public void test04ExclusividadAplicarConUnaRespuestaConCalificacionCeroYOtraConCalificacionUnoEstaSeLeDuplicaElPuntaje(){
        Respuesta respuesta1 = new Respuesta();
        respuesta1.agregarPuntajeObtenido(new PuntoPositivo());
        Respuesta respuesta2 = new Respuesta();
        respuesta2.agregarPuntajeObtenido(new PuntoNulo());

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Exclusividad exclusividad = new Exclusividad();

        exclusividad.aplicar(respuestas);

        assertEquals(2, respuesta1.calificacionValorNumerico());
        assertEquals(0, respuesta2.calificacionValorNumerico());
    }

    @Test
    public void test05ExclusividadAplicarConRespuestasConCalificacionDiferenteDeCeroAmbasRecibenCeroPuntos(){
        Respuesta respuesta1 = new Respuesta();
        respuesta1.agregarPuntajeObtenido(new PuntoPositivo());
        Respuesta respuesta2 = new Respuesta();
        respuesta2.agregarPuntajeObtenido(new PuntoPositivo());

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Exclusividad exclusividad = new Exclusividad();

        exclusividad.aplicar(respuestas);

        assertEquals(0, respuesta1.calificacionValorNumerico());
        assertEquals(0, respuesta2.calificacionValorNumerico());
    }

    @Test
    public void test06ExclusividadAplicarConRespuestasConCalificacionCeroAmbasRecibenCeroPuntos(){
        Respuesta respuesta1 = new Respuesta();
        respuesta1.agregarPuntajeObtenido(new PuntoNulo());
        Respuesta respuesta2 = new Respuesta();
        respuesta2.agregarPuntajeObtenido(new PuntoNulo());

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Exclusividad exclusividad = new Exclusividad();

        exclusividad.aplicar(respuestas);

        assertEquals(0, respuesta1.calificacionValorNumerico());
        assertEquals(0, respuesta2.calificacionValorNumerico());
    }

    @Test
    public void test07ExclusividadAplicarConPuntajeDevuelveElMismoSinModificar(){
        Exclusividad exclusividad = new Exclusividad();
        Puntaje puntaje = new PuntoPositivo();

        assertEquals(1, exclusividad.aplicar(puntaje).valorNumerico());
    }
}
