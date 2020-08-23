package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Pregunta.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.*;


public class CalificadorPenalizado extends Calificador {

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {

        Puntaje puntajeParcial = new Puntos();
        for (String opcionElegida: elegidas.obtenerOpciones()) {
            if(correctas.esta(opcionElegida)){
                puntajeParcial = puntajeParcial.agregar(new PuntoPositivo());
            }
            else {
                puntajeParcial = puntajeParcial.agregar(new PuntoNegativo());
            }
        }
        return puntajeParcial;

    }

    @Override
    public boolean sonCorrectas(Opciones correctas, Opciones elegidas) {
        return false;
    }
}
