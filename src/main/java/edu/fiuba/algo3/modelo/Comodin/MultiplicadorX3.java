package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class MultiplicadorX3 extends Multiplicador {

    public static String NOMBRE_MULTIPLICADORX3 = "MultiplicadorX3";

    public String obtenerNombre(){
        return NOMBRE_MULTIPLICADORX3;
    }

    @Override
    public Puntaje aplicar(Puntaje puntaje) {
        return puntaje.multiplicarPor(3);
    }

}
