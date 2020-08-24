package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Comodin.Comodin;

public abstract class Penalidad {

    public void validar(Comodin comodin){
        comodin.validar(this);
    }

    public abstract void validarExclusividad();

    public abstract void validarMultiplicador();
}
