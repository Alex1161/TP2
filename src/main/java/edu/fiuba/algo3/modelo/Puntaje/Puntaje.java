package edu.fiuba.algo3.modelo.Puntaje;

public abstract class Puntaje {


    public abstract Puntaje agregar(Puntaje puntaje);

    public abstract int valor();

    public Puntaje multiplicarPor(int factor){
        Puntaje puntosMultiplicados = new Puntos();

        for (int i = 0; i < factor; i++){
            puntosMultiplicados.agregar(this);
        }

        return puntosMultiplicados;
    }
}
