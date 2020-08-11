package edu.fiuba.algo3.modelo.PuntajeTest;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuntoPositivoTest {

    @Test
    public void inicializarUnPuntoPositivoNoDevuelveErrores(){
        PuntoPositivo nuevoPunto = new PuntoPositivo();
        assertEquals(nuevoPunto.valorNumerico(),1);
    }

    @Test
    public void puntoPositivoMultiplicarX2FuncionaCorrectamente(){
        PuntoPositivo nuevoPunto = new PuntoPositivo();
        Puntaje puntajeMultiplicado = nuevoPunto.multiplicarPor(2);

        assertEquals(2, puntajeMultiplicado.valorNumerico());
    }

    @Test
    public void puntoPositivoMultiplicarX3FuncionaCorrectamente(){
        PuntoPositivo nuevoPunto = new PuntoPositivo();
        Puntaje puntajeMultiplicado = nuevoPunto.multiplicarPor(3);

        assertEquals(3, puntajeMultiplicado.valorNumerico());
    }

}
