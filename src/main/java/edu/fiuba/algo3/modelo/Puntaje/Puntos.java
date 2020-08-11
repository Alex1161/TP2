package edu.fiuba.algo3.modelo.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class Puntos extends Puntaje {

    List<Puntaje> listaDePuntos = new ArrayList<Puntaje>();


    public Puntaje agregar(Puntaje puntaje){
        listaDePuntos.add(puntaje);
        return this;
    }

    public int valorNumerico(){
        int valor = 0;
        for(Puntaje puntaje: listaDePuntos) {
            valor += puntaje.valorNumerico();
        }
        return valor;
    }

    @Override
    public Puntaje vs(Puntaje puntajeOponente) {
        return new PuntoNulo();
    }

}
