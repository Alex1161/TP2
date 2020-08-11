package edu.fiuba.algo3.modelo.ComodinTest;

import edu.fiuba.algo3.modelo.Comodin.ComodinVacio;
import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComodinVacioTest {

    @Test
    public void test01ComodinVacioEsComparadoConOtroComodinVacioDaTrue(){
        ComodinVacio comodinVacio = new ComodinVacio();

        assertTrue(comodinVacio.equals(new ComodinVacio()));
    }

    @Test
    public void test02ComodinVacioEsComparadoConOtroTipoDeComodinDaFalse(){
        ComodinVacio comodinVacio = new ComodinVacio();

        assertFalse(comodinVacio.equals(new Exclusividad()));
    }

    @Test
    public void test03ComodinVacioAlAplicarPuntajeEsteDevuelveElMismoSinModificar(){
        ComodinVacio comodinVacio = new ComodinVacio();
        Puntaje puntaje = new PuntoPositivo();

        assertEquals(1, comodinVacio.aplicar(puntaje).valorNumerico());
    }

}
