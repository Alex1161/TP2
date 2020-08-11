package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.ComodinVacio;
import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class Respuesta {
    Opciones grupo2 = new Opciones();
    Opciones opcionesElegidas=new Opciones();
    Puntaje puntajeObtenido;
    Comodin multiplicador = new ComodinVacio();
    Jugador jugador;

    public Respuesta(Jugador jugador){
        this.jugador=jugador;
        this.multiplicador = new ComodinVacio();
    }

    public Respuesta(Jugador jugador, Multiplicador multiplicador ){
        this.multiplicador=multiplicador;
        this.jugador=jugador;
    }

    public Respuesta() {

    }

    public void agregarOpcion(String opcion){
        opcionesElegidas.agregarOpcion(opcion);
    }

    public void aplicarPuntaje(){
        jugador.agregarPuntaje(multiplicador.aplicar(puntajeObtenido));
    }

    public void agregarPuntajeObtenido(Puntaje puntaje){
        puntajeObtenido=puntaje;
    }

    public Opciones obtenerOpciones(){
        return opcionesElegidas;
    }

    public void cambiarMultiplicador(Multiplicador multiplicador){
        this.multiplicador = multiplicador;
    }

    public void vs(Respuesta respuesta) {
        Puntaje puntajeOponente = respuesta.puntaje();
        Puntaje puntajeAuxiliar = puntajeObtenido;

        puntajeObtenido = puntajeOponente.vs(puntajeObtenido);
        puntajeOponente = puntajeAuxiliar.vs(puntajeOponente);

        respuesta.agregarPuntajeObtenido(puntajeOponente);
    }

    private Puntaje puntaje() {
        return puntajeObtenido;
    }

    public void agregarComodin(Comodin multiplicador) {
        this.multiplicador = multiplicador;
    }

    public void aplicarComodin(Comodin comodin) {
        puntajeObtenido = comodin.aplicar(puntajeObtenido);
    }

    public int calificacionValorNumerico() {
        return puntajeObtenido.valorNumerico();
    }
}
