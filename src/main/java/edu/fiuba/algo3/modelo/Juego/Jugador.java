package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Comodin.*;
import edu.fiuba.algo3.modelo.Errores.ComodinYaUsado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

import java.util.*;


public class Jugador {
    private String nombre;
    private Puntaje puntaje;
    private List<Comodin> comodines = new LinkedList<Comodin>();

    //Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntos();
        comodines.add(new MultiplicadorX2());
        comodines.add(new MultiplicadorX3());
        comodines.add(new Exclusividad());
        comodines.add(new Exclusividad());
    }

    //Setters y Getters
    public int puntajeValorNumerico() {
        return puntaje.valorNumerico();
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Comodin> obtenerComodines() {
        return comodines;
    }

    //Acciones
    public void agregarPuntaje(Puntaje puntaje){
        this.puntaje.agregar(puntaje);
    }

    public void sacarComodin(Comodin comodin) throws ComodinYaUsado {
        boolean fueSacado = comodines.remove(comodin);

        if ( !fueSacado ){
            throw new ComodinYaUsado();
        }

    }
}

