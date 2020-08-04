package edu.fiuba.algo3.modelo.PuntajeTest;

import edu.fiuba.algo3.modelo.Puntaje.PuntoNegativo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntosTest {

    @Test
    public void Test01PuntosSeAgregaPuntoPositivosYdevuelveElValorEsperado(){
        Puntos puntos = new Puntos();
        puntos.aniadir(new PuntoPositivo());
        assertEquals(puntos.valor(),1);
    }

    @Test
    public void Test02PuntosSeAgregaPuntoNegativoYdevuelveElValorEsperado(){
        Puntos puntos = new Puntos();
        puntos.aniadir(new PuntoNegativo());
        assertEquals(puntos.valor(),-1);
    }
    @Test
    public void Test03PuntosSeAgregaPuntoNuloYdevuelveElValorEsperado(){
        Puntos puntos = new Puntos();
        puntos.aniadir(new PuntoNulo());
        assertEquals(puntos.valor(),0);
    }

    @Test
    public void Test04PuntosSeAgregaPuntosDiferentesYdevuelveElValorEsperado(){
        Puntos puntos = new Puntos();
        puntos.aniadir(new PuntoPositivo());
        puntos.aniadir(new PuntoPositivo());
        puntos.aniadir(new PuntoNulo());
        puntos.aniadir(new PuntoPositivo());
        puntos.aniadir(new PuntoNegativo());
        puntos.aniadir(new PuntoNulo());
        assertEquals(puntos.valor(),2);
    }
    @Test
    public void Test05PuntosSeAgregaPuntosDiferentesYdevuelveElValorEsperado(){
        Puntos puntos = new Puntos();
        puntos.aniadir(new PuntoPositivo());
        puntos.aniadir(new PuntoPositivo());
        puntos.aniadir(new PuntoNulo());
        puntos.aniadir(new PuntoPositivo());
        puntos.aniadir(new PuntoNegativo());
        puntos.aniadir(new PuntoNegativo());
        puntos.aniadir(new PuntoNegativo());
        puntos.aniadir(new PuntoNegativo());
        puntos.aniadir(new PuntoNegativo());
        puntos.aniadir(new PuntoNulo());
        assertEquals(puntos.valor(),-2);
    }


}
