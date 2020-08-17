package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

public class Ronda {

    private Pregunta pregunta;

    public void preguntaAsociada(Pregunta preguntaRonda){
        pregunta = preguntaRonda;
    }

    public Pregunta pregunta() {
        return pregunta;
    }
}
