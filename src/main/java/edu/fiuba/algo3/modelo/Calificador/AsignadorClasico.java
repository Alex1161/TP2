package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.puntaje.PuntoNulo;

public class AsignadorClasico extends Calificador {

    public AsignadorClasico() {

    }

    @Override
    public Puntaje calificar(Opciones correctas, Opciones elegidas) {
        return new PuntoNulo();
    }
}
