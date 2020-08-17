package edu.fiuba.algo3.modelo.OpcionesTest;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpcionesTest {

    @Test
    public void test01OpcionesSonCreadasYAgregoUnElemento(){
        Opciones opciones = new Opciones();
        opciones.agregarOpcion("1");

        assertTrue(opciones.esta("1"));
    }

    @Test
    public void test02OpcionesSonCreadasYAgregoMuchosElmentos(){
        Opciones opciones = new Opciones();
        opciones.agregarOpcion("1");
        opciones.agregarOpcion("2");
        opciones.agregarOpcion("3");

        assertTrue(opciones.esta("1"));
        assertTrue(opciones.esta("2"));
        assertTrue(opciones.esta("3"));
    }

    @Test
    public void test03ComparoOpcionesIgualesSinImportarELOrdenDevuelveTrue(){
        Opciones opciones1 = new Opciones();
        opciones1.agregarOpcion("1");
        opciones1.agregarOpcion("2");
        opciones1.agregarOpcion("3");

        Opciones opciones2 = new Opciones();
        opciones2.agregarOpcion("3");
        opciones2.agregarOpcion("2");
        opciones2.agregarOpcion("1");

        assertTrue(opciones1.compararSinOrden(opciones2));
    }

    @Test
    public void test04ComparoOpcionesDiferentesSinImportarELOrdenDevuelveFalse(){
        Opciones opciones1 = new Opciones();
        opciones1.agregarOpcion("1");
        opciones1.agregarOpcion("2");
        opciones1.agregarOpcion("3");

        Opciones opciones2 = new Opciones();
        opciones2.agregarOpcion("4");
        opciones2.agregarOpcion("2");
        opciones2.agregarOpcion("1");

        assertFalse(opciones1.compararSinOrden(opciones2));
    }

    @Test
    public void test05ComparoOpcionesIgualesPeroDiferenteOrdenImportandoElOrdenDevuelveFalse(){
        Opciones opciones1 = new Opciones();
        opciones1.agregarOpcion("1");
        opciones1.agregarOpcion("2");
        opciones1.agregarOpcion("3");

        Opciones opciones2 = new Opciones();
        opciones2.agregarOpcion("3");
        opciones2.agregarOpcion("2");
        opciones2.agregarOpcion("1");

        assertFalse(opciones1.compararConOrden(opciones2));
    }

    @Test
    public void test06ComparoOpcionesIgualesConMismoOrdenImportandoElOrdenDevuelveTrue(){
        Opciones opciones1 = new Opciones();
        opciones1.agregarOpcion("3");
        opciones1.agregarOpcion("2");
        opciones1.agregarOpcion("1");

        Opciones opciones2 = new Opciones();
        opciones2.agregarOpcion("3");
        opciones2.agregarOpcion("2");
        opciones2.agregarOpcion("1");

        assertTrue(opciones1.compararConOrden(opciones2));
    }
    @Test
    public void test06PreguntoCantidadDeOpciones(){
        Opciones opciones1 = new Opciones();
        opciones1.agregarOpcion("3");
        opciones1.agregarOpcion("2");
        opciones1.agregarOpcion("1");


        assertEquals(3,opciones1.cantidadDeOpciones());
    }

}
