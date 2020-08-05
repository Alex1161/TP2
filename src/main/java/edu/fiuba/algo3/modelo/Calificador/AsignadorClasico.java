package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.IPunteable;
import edu.fiuba.algo3.modelo.Puntaje.PuntoNulo;

public class AsignadorClasico extends Calificador {

    public AsignadorClasico() {

    }

    @Override
    public IPunteable calificar(Opciones correctas, Opciones elegidas) {
        return new PuntoNulo();
    }
}
