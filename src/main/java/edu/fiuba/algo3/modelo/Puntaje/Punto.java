package edu.fiuba.algo3.modelo.Puntaje;

public abstract class Punto extends Puntaje {

    @Override
    public Puntaje agregar(Puntaje puntaje) {
        Puntaje puntos = new Puntos();
        puntos.agregar(this);
        puntos.agregar(puntaje);
        return puntos;
    }

    @Override
    public abstract int valorNumerico();

    @Override
    public abstract Puntaje vs(Puntaje puntajeOponente);
}
