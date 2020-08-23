package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Errores.ExclusividadNoPermitida;

public class ConPenalidad extends Penalidad{

    @Override
    public void validarExclusividad() {
        throw new ExclusividadNoPermitida();
    }

    @Override
    public void validarMultiplicador() {

    }
}
