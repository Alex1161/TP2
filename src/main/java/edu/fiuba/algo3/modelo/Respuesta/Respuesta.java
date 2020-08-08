package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

import java.util.ArrayList;
import java.util.HashMap;

public class Respuesta {
    Opciones grupo2 = new Opciones();
    Opciones opcionesElegidas=new Opciones();
    Puntaje puntajeObtenido;
    Multiplicador multiplicador;
    Jugador jugador;

    public Respuesta(Jugador jugador){
        this.multiplicador = new Multiplicador(1);
        this.jugador=jugador;
    }

    public void setMultiplicador(Multiplicador unMultiplicador){
        multiplicador = unMultiplicador;
    }

    public Respuesta(Jugador jugador, Multiplicador multiplicador ){
        this.multiplicador=multiplicador;
        this.jugador=jugador;
    }

    public void agregarOpcion(String opcion){
        opcionesElegidas.agregarOpcion(opcion);
    }

    public void agregarOpcionEnGrupo1(String opcion){
        this.agregarOpcion(opcion);
    }

    public void agregarOpcionEnGrupo2(String opcion){
        grupo2.agregarOpcion(opcion);
    }

    public void aplicarPuntaje(){
        jugador.agregarPuntaje(puntajeObtenido);
    }

    public void agregarPuntajeObtenido(Puntaje puntaje){
        puntajeObtenido=puntaje;
    }

    public Opciones obtenerOpciones(){
        return opcionesElegidas;
    }

}
