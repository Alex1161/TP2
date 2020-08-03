package edu.fiuba.algo3.modelo.CalificadorTest;

import edu.fiuba.algo3.modelo.Calificador.AsignadorClasico;
import edu.fiuba.algo3.modelo.Calificador.AsignadorPenalizado;
import edu.fiuba.algo3.modelo.Calificador.ComparadorSinOrden;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.puntaje.PuntoNegativo;
import edu.fiuba.algo3.modelo.puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.puntaje.PuntoPositivo;
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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new AsignadorClasico());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valor()), puntajeObtenido.valor());
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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new AsignadorClasico());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoPositivo().valor()), puntajeObtenido.valor());
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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new AsignadorClasico());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valor()), puntajeObtenido.valor());
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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new AsignadorClasico());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNulo().valor()), puntajeObtenido.valor());
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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new AsignadorPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNegativo().valor()), puntajeObtenido.valor());
    }

    @Test
    public void Test04SeEvaluanDosOpcionesSinPenalidadVerificaOpcionesDiferentesDevuelveUnPuntoNegativo(){

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

        ComparadorSinOrden comparador = new ComparadorSinOrden(new AsignadorPenalizado());
        Puntaje puntajeObtenido = comparador.calificar(opcionesCorrectas, opcionesElegidas);

        assertEquals((new PuntoNegativo().valor()), puntajeObtenido.valor());
    }


}
