package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class MultiplicadorX2 extends Multiplicador {

    public static String NOMBRE_MULTIPLICADORX2 = "MultiplicadorX2";

    public String obtenerNombre(){
        return NOMBRE_MULTIPLICADORX2;
    }

    @Override
    public Puntaje aplicar(Puntaje puntaje) {
        return puntaje.multiplicarPor(2);
    }

}
