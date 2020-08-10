package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public interface Comodin {

    void validar(Penalidad penalidad);

    void aplicar(List<Respuesta> respuestas);

    Puntaje aplicar(Puntaje puntaje);
}
