package edu.fiuba.algo3.modelo.Puntaje;

public abstract class Punto implements IPunteable {

    @Override
    public IPunteable agregar(IPunteable puntaje) {
        IPunteable puntos = new Puntos();
        puntos.agregar(this);
        puntos.agregar(puntaje);
        return puntos;
    }

    @Override
    public abstract int valor();
}
