package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

import java.util.*;


public class Jugador {
    protected String nombre;
    protected Puntaje puntaje  ;
    protected Map<Integer,Multiplicador> multiplicadores;
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntos();
        this.multiplicadores = new HashMap<Integer,Multiplicador>();
        multiplicadores.put(2, new Multiplicador(2));
        multiplicadores.put(3, new Multiplicador(3));
    }
    public void agregarPuntaje(Puntaje puntaje){
        this.puntaje.aniadir(puntaje);
    }

    public Puntaje obtenerPuntaje(){
        return puntaje;
    }
    public void removerMultiplicador(int factor){
        multiplicadores.remove(factor);
    }
    public Map<Integer,Multiplicador> obtenerMultiplicadores(){
        return multiplicadores;
    }


}

