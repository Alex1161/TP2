package edu.fiuba.algo3.modelo.Calificador;

import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Puntaje.*;


public class AsignadorPenalizado extends Calificador {

    @Override
    public IPunteable calificar(Opciones correctas, Opciones elegidas) {

        IPunteable puntajeParcial = new Puntos();
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
}
