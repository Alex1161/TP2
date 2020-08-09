package edu.fiuba.algo3.modelo.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class Puntos extends Puntaje {

    List<Puntaje> listaDePuntos = new ArrayList<Puntaje>();


    public Puntaje agregar(Puntaje puntaje){
        listaDePuntos.add(puntaje);
        return this;
    }

    public int valor(){
        int valor = 0;
        for(Puntaje puntaje: listaDePuntos) {
            valor += puntaje.valor();
        }
        return valor;
    }

}
