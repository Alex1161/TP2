package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.puntaje.Puntos;

public class Multiplicador {
    private int factor;
    public Multiplicador(int factor){
        this.factor=factor;
    }
    public Puntaje aplicar(Puntaje puntos){
        Puntaje puntosMultiplicados= new Puntos();
        for (int j = 0; j < factor; j++){
            puntosMultiplicados.aniadir(puntos);
        }
        return puntosMultiplicados;
    }
}
