package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class MultiplicadorX3 extends Multiplicador {

    @Override
    public Puntaje aplicar(Puntaje puntaje) {
        return puntaje.multiplicarPor(3);
    }

}
