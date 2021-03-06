package edu.fiuba.algo3.modelo.CalificadorTest;

import edu.fiuba.algo3.modelo.Calificador.CalificadorNoPenalizado;
import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Calificador.ComparadorConOrden;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalificadorConOrdenTest {

    @Test
    public void Test01SeCalificadoConOrdenNoPenalizadoCalificaDosOpcionesCon(){

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

        ComparadorConOrden comparador = new ComparadorConOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valorNumerico()), puntajeObtenido.valorNumerico());
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

        ComparadorConOrden comparador = new ComparadorConOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valorNumerico()), puntajeObtenido.valorNumerico());
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

        ComparadorConOrden comparador = new ComparadorConOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valorNumerico()), puntajeObtenido.valorNumerico());
    }


}
