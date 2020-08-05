package edu.fiuba.algo3.modelo.Puntaje;

public class Punto implements IPunteable {

    @Override
    public IPunteable agregar(IPunteable puntaje) {
        IPunteable puntos = new Puntos();
        puntos.agregar(this);
        puntos.agregar(puntaje);
        return puntos;
    }

    @Override
    public int valor() {
        return 0;
    }
}
