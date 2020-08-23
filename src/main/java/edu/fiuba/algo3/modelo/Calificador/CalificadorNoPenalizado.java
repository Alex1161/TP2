package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;

public class CalificadorNoPenalizado extends Calificador {

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {
        return new PuntoNulo();
    }

    @Override
    public boolean sonCorrectas(Opciones correctas, Opciones elegidas) {
        return false;
    }
}
