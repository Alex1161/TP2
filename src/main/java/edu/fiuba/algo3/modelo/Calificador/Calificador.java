package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.IPunteable;

public abstract class Calificador {

    Calificador siguienteCalificador;

    public Calificador(){
        setearSiguiente(null);
    }

    public void setearSiguiente(Calificador siguienteCalificador){
        this.siguienteCalificador = siguienteCalificador;
    }

    public abstract IPunteable calificar(Opciones correctas, Opciones elegidas);
}
