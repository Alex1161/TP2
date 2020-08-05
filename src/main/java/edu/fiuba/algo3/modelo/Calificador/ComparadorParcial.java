package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

public class ComparadorParcial extends Calificador {
    public ComparadorParcial(Calificador unCalificador) {
        siguienteCalificador = unCalificador;

    }

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {
        Puntaje puntosActuales= new Puntos();
        for (String opcionElegida : elegidas.obtenerOpciones()) {
            if (correctas.esta(opcionElegida)) {
                puntosActuales = puntosActuales.agregar(new PuntoPositivo());
            } else {
                return siguienteCalificador.calificar(correctas, elegidas);
            }

        }
        return puntosActuales;
    }
}
