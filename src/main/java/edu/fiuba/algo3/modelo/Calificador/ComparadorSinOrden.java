package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;

public class ComparadorSinOrden extends Calificador{

    public ComparadorSinOrden(Calificador calificador){
        siguienteCalificador = calificador;
    }

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {
        if ( sonCorrectas( correctas, elegidas) ){
            return new PuntoPositivo();
        }else{
            return siguienteCalificador.calificar(correctas, elegidas);
        }
    }

    @Override
    public boolean sonCorrectas(Opciones correctas, Opciones elegidas) {
        return correctas.compararSinOrden(elegidas);
    }
}
