package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Pregunta.Respuesta;

import java.util.List;

public abstract class Comodin {

    public abstract String obtenerNombre();

    public abstract void validar(Penalidad penalidad);

    public abstract void aplicar(List<Respuesta> respuestas);

    public abstract Puntaje aplicar(Puntaje puntaje);

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
