package edu.fiuba.algo3.modelo.Puntaje;

public abstract class Punto implements Puntaje {

    @Override
    public Puntaje agregar(Puntaje puntaje) {
        Puntaje puntos = new Puntos();
        puntos.agregar(this);
        puntos.agregar(puntaje);
        return puntos;
    }

    @Override
    public abstract int valor();
}
