package edu.fiuba.algo3.modelo.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class Puntos implements IPunteable {

    List<IPunteable> listaDePuntos = new ArrayList<IPunteable>();


    public IPunteable agregar(IPunteable puntaje){
        listaDePuntos.add(puntaje);
        return this;
    }

    public int valor(){
        int valor = 0;
        for(IPunteable puntaje: listaDePuntos) {
            valor += puntaje.valor();
        }
        return valor;
    }

}
