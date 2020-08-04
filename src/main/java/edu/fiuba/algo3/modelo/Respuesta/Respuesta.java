package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class Respuesta {
    Opciones opcionesElegidas=new Opciones();
    Puntaje puntajeObtenido;
    Multiplicador multiplicador;
    Jugador jugador;
    public Respuesta(Jugador jugador){
        this.jugador=jugador;
    }
    public Respuesta(Jugador jugador, Multiplicador multiplicador ){
        this.multiplicador=multiplicador;
        this.jugador=jugador;
    }
    public void agregarOpcion(String opcion){
        opcionesElegidas.agregarOpcion(opcion);
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
