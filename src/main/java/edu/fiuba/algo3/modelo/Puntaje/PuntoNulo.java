package edu.fiuba.algo3.modelo.Puntaje;

public class PuntoNulo extends Punto {

    @Override
    public int valor(){
        return 0;
    }

    @Override
    public Puntaje vs(Puntaje puntajeOponente) {
        return puntajeOponente;
    }
}
