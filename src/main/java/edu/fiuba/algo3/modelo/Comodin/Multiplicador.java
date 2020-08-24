package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Pregunta.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Pregunta.Respuesta;

import java.util.List;

public abstract class Multiplicador extends Comodin {

    @Override
    public abstract Puntaje aplicar(Puntaje puntaje);

    @Override
    public void validar(Penalidad penalidad) {
        penalidad.validarMultiplicador();
    }

    @Override
    public void aplicar(List<Respuesta> respuestas) {

    }
}
