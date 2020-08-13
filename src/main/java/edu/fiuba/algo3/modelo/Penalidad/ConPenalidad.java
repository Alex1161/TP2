package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class ConPenalidad extends Penalidad{

    @Override
    public void validarExclusividad() {
        throw new ExclusividadPreguntaConPenalidadNoPermitidoException();
    }

    @Override
    public void validarMultiplicador() {

    }
}
