package edu.fiuba.algo3.modelo.Penalidad;

public class ConPenalidad extends Penalidad{

    @Override
    public void validarExclusividad() {
        throw new ExclusividadNoPermitida();
    }

    @Override
    public void validarMultiplicador() {

    }
}
