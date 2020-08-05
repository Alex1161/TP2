package edu.fiuba.algo3.modelo.PuntajeTest;

import edu.fiuba.algo3.modelo.Puntaje.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntosTest {

    @Test
    public void Test01PuntosSeAgregaPuntoPositivosYdevuelveElValorEsperado(){
        IPunteable puntos = new Puntos();
        puntos = puntos.agregar(new PuntoPositivo());
        assertEquals(puntos.valor(),1);
    }

    @Test
    public void Test02PuntosSeAgregaPuntoNegativoYdevuelveElValorEsperado(){
        IPunteable puntos = new Puntos();
        puntos = puntos.agregar(new PuntoNegativo());
        assertEquals(puntos.valor(),-1);
    }
    @Test
    public void Test03PuntosSeAgregaPuntoNuloYdevuelveElValorEsperado(){
        IPunteable puntos = new Puntos();
        puntos.agregar(new PuntoNulo());
        assertEquals(puntos.valor(),0);
    }

    @Test
    public void Test04PuntosSeAgregaPuntosDiferentesYdevuelveElValorEsperado(){
        IPunteable puntos = new Puntos();
        puntos.agregar(new PuntoPositivo());
        puntos.agregar(new PuntoPositivo());
        puntos.agregar(new PuntoNulo());
        puntos.agregar(new PuntoPositivo());
        puntos.agregar(new PuntoNegativo());
        puntos.agregar(new PuntoNulo());
        assertEquals(puntos.valor(),2);
    }
    @Test
    public void Test05PuntosSeAgregaPuntosDiferentesYdevuelveElValorEsperado(){
        IPunteable puntos = new Puntos();
        puntos.agregar(new PuntoPositivo());
        puntos.agregar(new PuntoPositivo());
        puntos.agregar(new PuntoNulo());
        puntos.agregar(new PuntoPositivo());
        puntos.agregar(new PuntoNegativo());
        puntos.agregar(new PuntoNegativo());
        puntos.agregar(new PuntoNegativo());
        puntos.agregar(new PuntoNegativo());
        puntos.agregar(new PuntoNegativo());
        puntos.agregar(new PuntoNulo());
        assertEquals(puntos.valor(),-2);
    }


}
