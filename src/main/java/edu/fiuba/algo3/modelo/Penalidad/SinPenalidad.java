package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Errores.MultiplicadorNoPermitido;

public class SinPenalidad extends Penalidad {

    @Override
    public void validarExclusividad() {
        //No hace nada
    }

    @Override
    public void validarMultiplicador() {
        throw new MultiplicadorNoPermitido();
    }
}
