package edu.fiuba.algo3.modelo.Puntaje;

public class PuntoPositivo extends Punto {

    @Override
    public int valorNumerico(){
        return 1;
    }

    @Override
    public Puntaje vs(Puntaje puntajeOponente) {
        return new PuntoNulo();
    }

}
