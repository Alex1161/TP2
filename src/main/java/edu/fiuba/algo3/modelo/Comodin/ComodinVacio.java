package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Pregunta.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Pregunta.Respuesta;

import java.util.List;

public class ComodinVacio extends Comodin {
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

    @Override
    public String obtenerNombre() {
        return "";
    }
}
