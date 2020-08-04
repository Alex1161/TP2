package edu.fiuba.algo3.modelo.PuntajeTest;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuntoPositivoTest {

    @Test
    public void inicializarUnPuntoPositivoNoDevuelveErrores(){
        PuntoPositivo nuevoPunto = new PuntoPositivo();
        assertEquals(nuevoPunto.valor(),1);
    }

}
