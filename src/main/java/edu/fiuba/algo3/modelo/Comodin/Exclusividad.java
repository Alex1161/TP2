package edu.fiuba.algo3.modelo.Comodin;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Pregunta.Respuesta;

import java.util.List;

public class Exclusividad extends Comodin {
    public static String NOMBRE_EXCLUSIVIDAD = "Exclusividad";

    public String obtenerNombre(){
        return NOMBRE_EXCLUSIVIDAD;
    }

    @Override
    public void validar(Penalidad penalidad) {
        penalidad.validarExclusividad();
    }

    @Override
    public void aplicar(List<Respuesta> respuestas) {
        Respuesta respuesta1 = respuestas.get(0);
        Respuesta respuesta2 = respuestas.get(1);

        respuesta1.vs(respuesta2);

        respuesta1.aplicarComodin(new MultiplicadorX2());
        respuesta2.aplicarComodin(new MultiplicadorX2());
    }

    @Override
    public Puntaje aplicar(Puntaje puntaje) {
        return puntaje;
    }
}
