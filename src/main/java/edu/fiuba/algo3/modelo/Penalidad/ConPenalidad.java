package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class ConPenalidad implements Penalidad{
    @Override
    public void agregarComodin(Multiplicador multiplicador, Respuesta respuesta) {
        respuesta.cambiarMultiplicador(multiplicador);
    }
}
