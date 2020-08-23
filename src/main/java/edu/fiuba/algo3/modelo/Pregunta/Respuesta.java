package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.ComodinVacio;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class Respuesta {
    Opciones opcionesElegidas = new Opciones();
    Puntaje puntajeObtenido;
    Comodin comodin = new ComodinVacio();
    Jugador jugador;

    //Constructor
    public Respuesta(Jugador jugador){
        this.jugador = jugador;
    }

    //Setters y Getters
    public void setPuntajeObtenido(Puntaje puntaje){
        puntajeObtenido = puntaje;
    }

    public void setComodin(Comodin comodin){
        this.comodin = comodin;
    }

    public void setOpcionesElegidas(Opciones opciones) {
        this.opcionesElegidas = opciones;
    }

    public Puntaje puntaje() {
        return puntajeObtenido;
    }

    public Opciones obtenerOpciones(){
        return opcionesElegidas;
    }

    //Accion
    public void agregarOpcion(String opcion){
        opcionesElegidas.agregarOpcion(opcion);
    }

    public void aplicarPuntaje(){
        jugador.agregarPuntaje(comodin.aplicar(puntajeObtenido));
    }

    public void vs(Respuesta respuesta) {
        Puntaje puntajeOponente = respuesta.puntaje();
        Puntaje puntajeAuxiliar = puntajeObtenido;

        puntajeObtenido = puntajeOponente.vs(puntajeObtenido);
        puntajeOponente = puntajeAuxiliar.vs(puntajeOponente);

        respuesta.setPuntajeObtenido(puntajeOponente);
    }

    public void aplicarComodin(Comodin comodin) {
        puntajeObtenido = comodin.aplicar(puntajeObtenido);
    }
}
