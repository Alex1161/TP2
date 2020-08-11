package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Comodin.*;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

import java.util.*;


public class Jugador {
    private String nombre;
    private Puntaje puntaje  ;
    private List<Comodin> comodines = new LinkedList<Comodin>();

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntos();
        comodines.add(new MultiplicadorX2());
        comodines.add(new MultiplicadorX3());
        comodines.add(new Exclusividad());
        comodines.add(new Exclusividad());
    }

    public void agregarPuntaje(Puntaje puntaje){
        this.puntaje = puntaje;
    }

    public int puntajeValorNumerico() {
        return puntaje.valorNumerico();
    }

    public void sacarComodin(Comodin comodin) throws ComodinYaUsadoException{
        boolean fueSacado = comodines.remove(comodin);

        if ( !fueSacado ){
            throw new ComodinYaUsadoException();
        }

    }

}

