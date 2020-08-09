package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

public class Multiplicador {
    private int factor;

    public Multiplicador(int factor){
        this.factor = factor;
    }

    public Puntaje aplicar(Puntaje puntaje){

        return puntaje.multiplicarPor(factor);
    }

}
