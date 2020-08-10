package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public class Multiplicador implements Comodin {
    private int factor;

    public Multiplicador(int factor){
        this.factor = factor;
    }

    @Override
    public Puntaje aplicar(Puntaje puntaje){

        return puntaje.multiplicarPor(factor);
    }

    @Override
    public void validar(Penalidad penalidad) {
        penalidad.validarMultiplicador();
    }

    @Override
    public void aplicar(List<Respuesta> respuestas) {

    }
}
