package edu.fiuba.algo3.modelo.Corrector;

import edu.fiuba.algo3.modelo.Opciones.Opciones;

public class CorrectorSinOrden implements Corrector {

    @Override
    public boolean sonCorrectas(Opciones opcionesCorrectas, Opciones opcionesElegidas) {
        return opcionesCorrectas.compararSinOrden(opcionesElegidas);
    }
}
