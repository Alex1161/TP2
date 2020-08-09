package edu.fiuba.algo3.modelo.PuntajeTest;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNegativo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoNegativoTest {

    @Test
    public void inicializarUnPuntoPositivoNoDevuelveErrores() {
        PuntoNegativo nuevoPunto = new PuntoNegativo();
        assertEquals (nuevoPunto.valor(),-1);
    }

    @Test
    public void puntoNegativoMultiplicarX2FuncionaCorrectamente(){
        PuntoNegativo nuevoPunto = new PuntoNegativo();
        Puntaje puntajeMultiplicado = nuevoPunto.multiplicarPor(2);

        assertEquals(-2, puntajeMultiplicado.valor());
    }

    @Test
    public void puntoNegativoMultiplicarX3FuncionaCorrectamente(){
        PuntoNegativo nuevoPunto = new PuntoNegativo();
        Puntaje puntajeMultiplicado = nuevoPunto.multiplicarPor(3);

        assertEquals(-3, puntajeMultiplicado.valor());
    }

}
