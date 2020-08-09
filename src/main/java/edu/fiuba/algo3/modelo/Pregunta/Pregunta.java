package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public class Pregunta {

    String enunciado;
    Opciones opcionesCorrectas, opcionesPosibles;
    Calificador calificador;
    Penalidad penalidad;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opcionesCorrectas = new Opciones();
        opcionesPosibles = new Opciones();
        penalidad = new SinPenalidad();
    }

    public void conPenalidad(){
        penalidad = new ConPenalidad();
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
        /*
         * Aca vamos a hacer doble dispatch entre IPunteable
         * siempre y cuando sea una pregunta no penalizada.
         */

        for (Respuesta resp: respuestas){
            resp.aplicarPuntaje();
        }
    }

    public boolean esCorrecta(Opciones opciones){
        return calificador.sonCorrectas(opcionesCorrectas, opciones);
    }

    public void agregarComodin(Multiplicador multiplicador, Respuesta respuesta){
        penalidad.agregarComodin(multiplicador, respuesta);
    }
}
