package edu.fiuba.algo3.modelo.CalificadorTest;

import edu.fiuba.algo3.modelo.Calificador.CalificadorNoPenalizado;
import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Calificador.ComparadorParcial;
import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparadorParcialTest {
    @Test
    public void test01ComparadorParcialEvalua2opcionesIgualesYSumaTodosAcumulaElPuntaje(){

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

        Calificador comparador = new ComparadorParcial(new CalificadorNoPenalizado());

        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals(4, puntajeObtenido.valorNumerico());
    }

    @Test
    public void test02ComparadorParcialEvalua2opcionesCon3opcionesCorrectasYUnaIncorrectaDevuelvePuntajeNulo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");
        opcionesElegidas.agregarOpcion("2");
        opcionesElegidas.agregarOpcion("3");
        opcionesElegidas.agregarOpcion("8");

        Calificador comparador = new ComparadorParcial(new CalificadorNoPenalizado());

        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals(0, puntajeObtenido.valorNumerico());
    }

    @Test
    public void test03ComparadorParcialEvaluaOpcionesCon1opciónCorrectaParcialDevuelvePuntajePositivo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");


        Calificador comparador = new ComparadorParcial(new CalificadorNoPenalizado());

        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals(1, puntajeObtenido.valorNumerico());
    }
}
