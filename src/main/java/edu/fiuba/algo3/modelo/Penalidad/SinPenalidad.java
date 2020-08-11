package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Pregunta.MultiplicadorPreguntaSinPenalidadNoPermitidoException;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class SinPenalidad extends Penalidad {

    @Override
    public void agregarComodin(Multiplicador multiplicador, Respuesta respuesta) {

    }

    @Override
    public void validarExclusividad() {
        //No hace nada
    }

    @Override
    public void validarMultiplicador() {
        throw new MultiplicadorPreguntaSinPenalidadNoPermitidoException();
    }
}
