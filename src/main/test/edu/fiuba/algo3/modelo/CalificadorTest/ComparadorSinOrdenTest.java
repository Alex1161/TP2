package edu.fiuba.algo3.modelo.CalificadorTest;

import edu.fiuba.algo3.modelo.Calificador.CalificadorNoPenalizado;
import edu.fiuba.algo3.modelo.Calificador.CalificadorPenalizado;
import edu.fiuba.algo3.modelo.Calificador.ComparadorSinOrden;
import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparadorSinOrdenTest {

    @Test
    public void Test01SeEvaluanDosOpcionesIdenticasYSeObtieneUnPuntoPositivo(){

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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valorNumerico()), puntajeObtenido.valorNumerico());
    }

    @Test
    public void Test02SeEvaluanDosOpcionesDesordenadasYSeObtieneUnPuntoPositivo(){

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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valorNumerico()), puntajeObtenido.valorNumerico());
    }

    @Test
    public void Test03SeEvaluanDosOpcionesSinPenalidadAUnaLeFaltaUnaOpcionSeDevuelveUnPuntoNulo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");
        opcionesElegidas.agregarOpcion("2");
        opcionesElegidas.agregarOpcion("3");

        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valorNumerico()), puntajeObtenido.valorNumerico());
    }

    @Test
    public void Test04SeEvaluanDosOpcionesSinPenalidadVerificaOpcionesDiferentesDevuelveUnPuntoNulo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("4");
        opcionesElegidas.agregarOpcion("8");
        opcionesElegidas.agregarOpcion("9");
        opcionesElegidas.agregarOpcion("7");

        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valorNumerico()), puntajeObtenido.valorNumerico());
    }

    @Test
    public void Test05SeEvaluanDosOpcionesConPenalidadAUnaLeFaltaUnaOpcionSeDevuelveUnPuntoNegativo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");
        opcionesElegidas.agregarOpcion("2");
        opcionesElegidas.agregarOpcion("3");

        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals(3, puntajeObtenido.valorNumerico());
    }

    @Test
    public void Test06SeEvaluanDosOpcionesConPenalidadVerificaOpcionesDiferentesDevuelveUnPuntoNegativo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");
        opcionesCorrectas.agregarOpcion("2");
        opcionesCorrectas.agregarOpcion("3");
        opcionesCorrectas.agregarOpcion("4");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("4");
        opcionesElegidas.agregarOpcion("8");
        opcionesElegidas.agregarOpcion("9");
        opcionesElegidas.agregarOpcion("7");

        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals(-2, puntajeObtenido.valorNumerico());
    }


    @Test
    public void Test07ComparadorSinOrdenEvaluanOpcionCorrectaYSeObtieneUnPuntoPositivo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("1");


        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valorNumerico()), puntajeObtenido.valorNumerico());
    }

    @Test
    public void Test08ComparadorSinOrdenEvaluanOpcionCorrectaYSeObtieneUnPuntoNulo(){

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion("1");

        Opciones opcionesElegidas = new Opciones();
        opcionesElegidas.agregarOpcion("4");


        ComparadorSinOrden comparador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valorNumerico()), puntajeObtenido.valorNumerico());
    }

}
