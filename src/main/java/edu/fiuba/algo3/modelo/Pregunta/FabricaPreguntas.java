package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.*;
import edu.fiuba.algo3.modelo.Opciones.Opciones;

public class FabricaPreguntas {

    public static Pregunta preguntaVoFVerdadera(String enunciado){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta("V");
        pregunta.asignarOpcionPosible("F");
        Calificador calificador = new ComparadorConOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }

    public static Pregunta preguntaVoFFalsa(String enunciado){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta("F");
        pregunta.asignarOpcionPosible("V");
        Calificador calificador = new ComparadorConOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }
    public static Pregunta preguntaVoFVerdaderaPenalizado(String enunciado){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta("V");
        pregunta.asignarOpcionPosible("F");
        Calificador calificador = new ComparadorConOrden(new AsignadorPenalizado());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }

    public static Pregunta preguntaVoFFalsaPenalizado(String enunciado){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta("F");
        pregunta.asignarOpcionPosible("V");
        Calificador calificador = new ComparadorConOrden(new AsignadorPenalizado());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceClasico(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);

        for(String opcion: opcionesCorrectas.obtenerOpciones()){
            pregunta.asignarOpcionCorrecta(opcion);
        }
        for(String opcion: opcionesPosibles.obtenerOpciones()){
            pregunta.asignarOpcionPosible(opcion);
        }

        Calificador calificador = new ComparadorSinOrden((new AsignadorClasico()));
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }
}
