package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Puntaje.IPunteable;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

import java.util.*;


public class Jugador {
    protected String nombre;
    protected IPunteable puntaje  ;
    protected Map<Integer,Multiplicador> multiplicadores;
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntos();
        this.multiplicadores = new HashMap<Integer,Multiplicador>();
        multiplicadores.put(2, new Multiplicador(2));
        multiplicadores.put(3, new Multiplicador(3));
    }
    public void agregarPuntaje(IPunteable puntaje){
        this.puntaje = puntaje;
    }

    public IPunteable obtenerPuntaje(){
        return puntaje;
    }
    public void removerMultiplicador(int factor){
        multiplicadores.remove(factor);
    }
    public Map<Integer,Multiplicador> obtenerMultiplicadores(){
        return multiplicadores;
    }


}

