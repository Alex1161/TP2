package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.AsignadorClasico;
import edu.fiuba.algo3.modelo.Calificador.Calificador;
import edu.fiuba.algo3.modelo.Calificador.ComparadorConOrden;
import edu.fiuba.algo3.modelo.Calificador.ComparadorSinOrden;
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

    public static Pregunta preguntaOrderecChoice(String enunciado, Opciones opcionesPosibles) {
        Pregunta pregunta =  new Pregunta(enunciado);

        for(String opcion: opcionesPosibles.obtenerOpciones()){
            pregunta.asignarOpcionPosible(opcion);
            pregunta.asignarOpcionCorrecta(opcion);
        }

        Calificador calificador = new ComparadorConOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }
}
