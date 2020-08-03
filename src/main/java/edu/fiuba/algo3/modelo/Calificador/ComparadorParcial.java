package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.puntaje.PuntoNulo;
import edu.fiuba.algo3.modelo.puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.puntaje.Puntos;

public class ComparadorParcial extends Calificador {
    public ComparadorParcial(Calificador unCalificador) {
        siguienteCalificador = unCalificador;

    }

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {
        Puntos puntosActuales= new Puntos();
        for (String opcionElegida : elegidas.obtenerOpciones()) {
            if (correctas.esta(opcionElegida)) {
                puntosActuales.aniadir(new PuntoPositivo());
            } else {
                return siguienteCalificador.calificar(correctas, elegidas);
            }

        }
        return puntosActuales;
    }
}
