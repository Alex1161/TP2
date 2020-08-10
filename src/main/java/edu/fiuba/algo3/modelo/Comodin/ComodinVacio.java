package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public class ComodinVacio implements Comodin {
    @Override
    public void validar(Penalidad penalidad) {

    }

    @Override
    public void aplicar(List<Respuesta> respuestas) {

    }

    @Override
    public Puntaje aplicar(Puntaje puntaje) {
        return puntaje;
    }
}
