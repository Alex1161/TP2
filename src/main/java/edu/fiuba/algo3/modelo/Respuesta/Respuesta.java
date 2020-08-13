package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.ComodinVacio;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class Respuesta {
    Opciones opcionesElegidas = new Opciones();
    Puntaje puntajeObtenido;
    Comodin comodin = new ComodinVacio();
    Jugador jugador;

    public Respuesta(Jugador jugador){
        this.jugador = jugador;
    }

    private Puntaje puntaje() {
        return puntajeObtenido;
    }

    public void agregarOpcion(String opcion){
        opcionesElegidas.agregarOpcion(opcion);
    }

    public void setPuntajeObtenido(Puntaje puntaje){
        puntajeObtenido = puntaje;
    }

    public void setComodin(Comodin comodin){
        this.comodin = comodin;
    }

    public Opciones obtenerOpciones(){
        return opcionesElegidas;
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

    public int calificacionValorNumerico() {
        return puntajeObtenido.valorNumerico();
    }

}
