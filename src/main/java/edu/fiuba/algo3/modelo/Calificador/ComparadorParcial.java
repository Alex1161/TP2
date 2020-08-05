package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.IPunteable;
import edu.fiuba.algo3.modelo.Puntaje.PuntoPositivo;
import edu.fiuba.algo3.modelo.Puntaje.Puntos;

public class ComparadorParcial extends Calificador {
    public ComparadorParcial(Calificador unCalificador) {
        siguienteCalificador = unCalificador;

    }

    @Override
    public IPunteable calificar(Opciones correctas, Opciones elegidas) {
        IPunteable puntosActuales= new Puntos();
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
