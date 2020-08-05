package edu.fiuba.algo3.modelo.CalificadorTest;

import edu.fiuba.algo3.modelo.Calificador.AsignadorClasico;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.IPunteable;
import edu.fiuba.algo3.modelo.Calificador.ComparadorConOrden;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparadorConOrdenTest {

    @Test
    public void Test01SeEvaluanDosOpcionesIdenticasEnOrdenYSeObtieneUnPuntoPositivo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");
        opcionesElegidas.agregarOpcion("2");
        opcionesElegidas.agregarOpcion("3");
        opcionesElegidas.agregarOpcion("4");

        ComparadorConOrden comparador = new ComparadorConOrden(new AsignadorClasico());
        IPunteable puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valor()), puntajeObtenido.valor());
    }

    @Test
    public void Test02SeEvaluanDosOpcionesDesordenadasYSeObtieneUnPuntoNulo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");
        opcionesElegidas.agregarOpcion("3");
        opcionesElegidas.agregarOpcion("2");
        opcionesElegidas.agregarOpcion("4");

        ComparadorConOrden comparador = new ComparadorConOrden(new AsignadorClasico());
        IPunteable puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valor()), puntajeObtenido.valor());
    }

    @Test
    public void Test03SeEvaluanDosOpcionesAUnaLeFaltaUnaOpcionSeDevuelveUnPuntoNulo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");
        opcionesElegidas.agregarOpcion("2");
        opcionesElegidas.agregarOpcion("3");

        ComparadorConOrden comparador = new ComparadorConOrden(new AsignadorClasico());
        IPunteable puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valor()), puntajeObtenido.valor());
    }


}
