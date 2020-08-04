package edu.fiuba.algo3.modelo.PuntajeTest;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuntoNuloTest {

    @Test
    public void inicializarUnPuntoPositivoNoDevuelveErrores(){
        PuntoNulo nuevoPunto = new PuntoNulo();
        assertEquals(nuevoPunto.valor(),0);
    }

}

