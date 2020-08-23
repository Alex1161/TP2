package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;

import java.util.LinkedList;
import java.util.List;

public class Pregunta {
    private String tipo;

    private String enunciado;
    private Opciones opcionesCorrectas, opcionesPosibles;
    private Calificador calificador;
    private Penalidad penalidad;
    private List<Comodin> comodines = new LinkedList<Comodin>();

    //Constructor
    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opcionesCorrectas = new Opciones();
        opcionesPosibles = new Opciones();
    }

    //Setter y Getters
    public void asignarTipo(String tipo){
        this.tipo=tipo;
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

    public void setPenalidad(Penalidad penalidad) {
        this.penalidad = penalidad;
    }

    public Opciones obtenerOpciones(){
        return opcionesPosibles;
    }

    public String getEnunciado(){
        return enunciado;
    }

    public String getTipo(){
        return tipo;
    }

    //Acciones
    public void agregarComodin(Comodin comodin, Respuesta respuesta){
        penalidad.validar(comodin);
        respuesta.setComodin(comodin);
        this.agregarComodin(comodin);
    }
    private void agregarComodin(Comodin comodin){
        comodines.add(comodin);

    }

    public void calificar(List<Respuesta> respuestas){

        for (Respuesta resp: respuestas){
            resp.setPuntajeObtenido(calificador.calificar(opcionesCorrectas, resp.obtenerOpciones()));
        }

        for (Comodin comodin : comodines){
            comodin.aplicar(respuestas);
        }

        for (Respuesta resp: respuestas){
            resp.aplicarPuntaje();
        }
    }

    public boolean sonCorrectas(Opciones opciones){
        return calificador.sonCorrectas(opcionesCorrectas, opciones);
    }

}
