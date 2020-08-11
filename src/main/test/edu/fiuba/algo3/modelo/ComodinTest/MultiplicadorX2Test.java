package edu.fiuba.algo3.modelo.ComodinTest;

import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import org.junit.jupiter.api.Test;

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
}
