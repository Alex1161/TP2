package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public abstract class Penalidad {
    //penalizable
    public abstract void agregarComodin(Multiplicador multiplicador, Respuesta respuesta);

    public void validar(Comodin comodin){
        comodin.validar(this);
    }

    public abstract void validarExclusividad();

    public abstract void validarMultiplicador();
}
