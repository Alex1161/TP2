package edu.fiuba.algo3.modelo.PuntajeTest;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuntoNuloTest {

    @Test
    public void inicializarUnPuntoPositivoNoDevuelveErrores(){
        PuntoNulo nuevoPunto = new PuntoNulo();
        assertEquals(nuevoPunto.valorNumerico(),0);
    }

    @Test
    public void puntoNuloMultiplicarX2FuncionaCorrectamente(){
        PuntoNulo nuevoPunto = new PuntoNulo();
        Puntaje puntajeMultiplicado = nuevoPunto.multiplicarPor(2);

        assertEquals(0, puntajeMultiplicado.valorNumerico());
    }

    @Test
    public void puntoNuloMultiplicarX3FuncionaCorrectamente(){
        PuntoNulo nuevoPunto = new PuntoNulo();
        Puntaje puntajeMultiplicado = nuevoPunto.multiplicarPor(3);

        assertEquals(0, puntajeMultiplicado.valorNumerico());
    }

}

