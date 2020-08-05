package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Puntaje.IPunteable;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

public class Multiplicador {
    private int factor;

    public Multiplicador(int factor){
        this.factor=factor;
    }

    public IPunteable aplicar(IPunteable puntaje){
        IPunteable puntosMultiplicados = new Puntos();
        for (int j = 0; j < factor; j++){
            puntosMultiplicados= puntosMultiplicados.agregar(puntaje);
        }
        return puntosMultiplicados;
    }

}
