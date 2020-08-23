package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public abstract class Calificador {

    Calificador siguienteCalificador;

    //Constructor
    public Calificador(){
        setearSiguiente(null);
    }

    //Setters y Getters
    public void setearSiguiente(Calificador siguienteCalificador){
        this.siguienteCalificador = siguienteCalificador;
    }

    //Acciones
    public abstract Puntaje calificar(Opciones correctas, Opciones elegidas);

    public abstract boolean sonCorrectas(Opciones correctas, Opciones elegidas);
}
