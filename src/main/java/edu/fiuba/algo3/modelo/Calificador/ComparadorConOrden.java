package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;

public class ComparadorConOrden extends Calificador{

    public ComparadorConOrden(Calificador calificador) {

        siguienteCalificador = calificador;
    }

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {
        if( sonCorrectas( correctas, elegidas) ){
            return (new PuntoPositivo());
        }else{
            return siguienteCalificador.calificar(correctas, elegidas);
        }
    }

    @Override
    public boolean sonCorrectas(Opciones correctas, Opciones elegidas) {
        return correctas.compararConOrden(elegidas);
    }
}
