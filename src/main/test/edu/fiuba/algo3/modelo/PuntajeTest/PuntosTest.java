package edu.fiuba.algo3.modelo.PuntajeTest;

import edu.fiuba.algo3.modelo.Puntaje.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntosTest {

    @Test
    public void Test01PuntosSeAgregaPuntoPositivosYdevuelveElValorEsperado(){
        Puntaje puntos = new Puntos();
        puntos = puntos.agregar(new PuntoPositivo());
        assertEquals(puntos.valor(),1);
    }

    @Test
    public void Test02PuntosSeAgregaPuntoNegativoYdevuelveElValorEsperado(){
        Puntaje puntos = new Puntos();
        puntos = puntos.agregar(new PuntoNegativo());
        assertEquals(puntos.valor(),-1);
    }
    @Test
    public void Test03PuntosSeAgregaPuntoNuloYdevuelveElValorEsperado(){
        Puntaje puntos = new Puntos();
        puntos.agregar(new PuntoNulo());
        assertEquals(puntos.valor(),0);
    }

    @Test
    public void Test04PuntosSeAgregaPuntosDiferentesYdevuelveElValorEsperado(){
        Puntaje puntos = new Puntos();
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
        Puntaje puntos = new Puntos();
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

    @Test
    public void puntosMultiplicarX2FuncionaCorrectamente(){
        Puntos puntos = new Puntos();
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

        Puntaje puntajeMultiplicado = puntos.multiplicarPor(2);

        assertEquals(-4, puntajeMultiplicado.valor());
    }

    @Test
    public void puntosMultiplicarX3FuncionaCorrectamente(){
        Puntos puntos = new Puntos();
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

        Puntaje puntajeMultiplicado = puntos.multiplicarPor(3);

        assertEquals(-6, puntajeMultiplicado.valor());
    }


}
