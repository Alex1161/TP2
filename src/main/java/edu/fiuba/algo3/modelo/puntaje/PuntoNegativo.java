package edu.fiuba.algo3.modelo.puntaje;

public class PuntoNegativo implements Puntaje {

    @Override
    public void aniadir(Puntaje puntaje){}

    @Override
    public int valor(){
        return -1;
    }
}
