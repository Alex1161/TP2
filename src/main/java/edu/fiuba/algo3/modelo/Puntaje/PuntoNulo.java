package edu.fiuba.algo3.modelo.Puntaje;

public class PuntoNulo implements Puntaje {

    @Override
    public void aniadir(Puntaje puntaje){}

    @Override
    public int valor(){
        return 0;
    }
}
