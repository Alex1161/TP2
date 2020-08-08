package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

import java.util.*;


public class Jugador {
    protected String nombre;
    protected Puntaje puntaje  ;
    private Multiplicador multiplicadorActual;
    int cantMultiplicadorX2;
    int cantMultiplicadorX3;

    //protected Map<Integer,Multiplicador> multiplicadores;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntos();
        this.multiplicadorActual = new Multiplicador(1);
        this.cantMultiplicadorX2 = 1;
        this.cantMultiplicadorX3 = 1;
        /*this.multiplicadores = new HashMap<Integer,Multiplicador>();
        multiplicadores.put(2, new Multiplicador(2));
        multiplicadores.put(3, new Multiplicador(3));

         */
    }
    public void agregarPuntaje(Puntaje puntaje){
        this.puntaje.aniadir(multiplicadorActual.aplicar(puntaje));
    }

    public void activarMultiplicadorX2() throws MultiplicadorYaUsadoException{
        if(cantMultiplicadorX2 == 0){
            throw new MultiplicadorYaUsadoException();
        }
        this.multiplicadorActual = new Multiplicador(2);
        cantMultiplicadorX2 --;

    }

    public void activarMultiplicadorX3() throws MultiplicadorYaUsadoException{
        if(cantMultiplicadorX3 == 0){
            throw new MultiplicadorYaUsadoException();
        }
        this.multiplicadorActual = new Multiplicador(3);
        cantMultiplicadorX3 --;
    }

    public Puntaje obtenerPuntaje(){
        return puntaje;
    }
    public void removerMultiplicador(int factor){

    }
    /*public Map<Integer,Multiplicador> obtenerMultiplicadores(){
        return multiplicadores;
    }

     */


}

