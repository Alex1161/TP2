package edu.fiuba.algo3.modelo.PuntajeTest;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNegativo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoNegativoTest {

    @Test
    public void inicializarUnPuntoPositivoNoDevuelveErrores() {
        PuntoNegativo nuevoPunto = new PuntoNegativo();
        assertEquals (nuevoPunto.valor(),-1);
    }

}
