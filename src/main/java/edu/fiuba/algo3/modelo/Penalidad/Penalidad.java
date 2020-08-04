package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public interface Penalidad {
    void agregarComodin(Multiplicador multiplicador, Respuesta respuesta);
}
