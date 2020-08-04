package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public class Pregunta {

    String enunciado;
    Opciones opcionesCorrectas, opcionesPosibles;
    Calificador calificador;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opcionesCorrectas = new Opciones();
        opcionesPosibles = new Opciones();
    }
    public void asignarOpcionCorrecta(Opciones opciones){
        opcionesCorrectas.agregarOpciones(opciones);
    }

    public void asignarOpcionCorrecta(String opcion){
        opcionesCorrectas.agregarOpcion(opcion);
    }

    public void asignarOpcionPosible(String opcion){
        opcionesPosibles.agregarOpcion(opcion);
    }

    public void asignarOpcionPosible(Opciones opciones){
        opcionesPosibles.agregarOpciones(opciones);
    }

    public void asignarCalificador(Calificador calificador){
        this.calificador = calificador;
    }

    public void calificar(List<Respuesta> respuestas){

        for (Respuesta resp: respuestas){
            resp.agregarPuntajeObtenido(calificador.calificar(opcionesCorrectas, resp.obtenerOpciones()));
        }

        for (Respuesta resp: respuestas){
            resp.aplicarPuntaje();
        }
    }

    public boolean esCorrecta(Opciones opcion){
        return opcionesCorrectas.compararConOrden(opcion);
    }

}
