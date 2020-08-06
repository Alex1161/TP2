package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

import java.util.*;


public class Jugador {
    protected String nombre;
    protected Puntaje puntaje  ;
    protected Map<String,Multiplicador> multiplicadores = new HashMap<String,Multiplicador>();

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntos();
        multiplicadores.put("MultiplicadorX2", new Multiplicador(2));
        multiplicadores.put("MultiplicadorX3", new Multiplicador(3));
    }

    public void agregarPuntaje(Puntaje puntaje){
        this.puntaje = puntaje;
    }

    public int puntajeValorNumerico() {
        return puntaje.valor();
    }

    public Multiplicador sacarMultiplicador(String nombreMultiplicador) throws MultiplicadorYaUsadoException {
        Multiplicador multiplicador = multiplicadores.remove(nombreMultiplicador);
        if (multiplicador == null){
            throw new MultiplicadorYaUsadoException();
        }

        return multiplicador;
    }
}

