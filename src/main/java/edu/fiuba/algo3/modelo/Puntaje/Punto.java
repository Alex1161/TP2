package edu.fiuba.algo3.modelo.Puntaje;

public class Punto implements Puntaje {

    @Override
    public Puntaje agregar(Puntaje puntaje) {
        Puntaje puntos = new Puntos();
        puntos.agregar(this);
        puntos.agregar(puntaje);
        return puntos;
    }

    @Override
    public int valor() {
        return 0;
    }
}
