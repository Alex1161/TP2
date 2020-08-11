package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.LinkedList;
import java.util.List;

public class Pregunta {

    private String enunciado;
    private Opciones opcionesCorrectas, opcionesPosibles;
    private Calificador calificador;
    private Penalidad penalidad;
    private List<Comodin> exclusividades = new LinkedList<Comodin>();

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opcionesCorrectas = new Opciones();
        opcionesPosibles = new Opciones();
        penalidad = new SinPenalidad();
    }

    public void asignarOpcionesCorrectas(Opciones opciones){
        opcionesCorrectas.agregarOpciones(opciones);
    }

    public void asignarOpcionesPosibles(Opciones opciones){
        opcionesPosibles.agregarOpciones(opciones);
    }

    public void asignarCalificador(Calificador calificador){
        this.calificador = calificador;
    }

    public void calificar(List<Respuesta> respuestas){

        for (Respuesta resp: respuestas){
            resp.agregarPuntajeObtenido(calificador.calificar(opcionesCorrectas, resp.obtenerOpciones()));
        }

        for (Comodin exclusividad : exclusividades){
            exclusividad.aplicar(respuestas);
        }

        for (Respuesta resp: respuestas){
            resp.aplicarPuntaje();
        }
    }

    public boolean sonCorrectas(Opciones opciones){
        return calificador.sonCorrectas(opcionesCorrectas, opciones);
    }

    public void agregarComodin(Multiplicador multiplicador, Respuesta respuesta){
        penalidad.validar(multiplicador);
        respuesta.agregarComodin(multiplicador);
    }

    public void agregarComodin(Comodin comodin) {
        penalidad.validar(comodin);
        exclusividades.add(comodin);
    }

    public void setPenalidad(Penalidad penalidad) {
        this.penalidad = penalidad;
    }

}
