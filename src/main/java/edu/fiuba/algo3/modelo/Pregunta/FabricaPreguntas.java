package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.*;
import edu.fiuba.algo3.modelo.Opciones.Opciones;

public class FabricaPreguntas {

    public static Pregunta preguntaVoFClasico(String enunciado, String opcionCorrecta){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionCorrecta);
        pregunta.asignarOpcionPosible("Verdadero");
        pregunta.asignarOpcionPosible("Falso");
        Calificador calificador = new ComparadorConOrden(new CalificadorNoPenalizado());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }

    public static Pregunta preguntaVoFPenalizado(String enunciado, String opcionCorrecta){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionCorrecta);
        pregunta.asignarOpcionPosible("Verdadero");
        pregunta.asignarOpcionPosible("Falso");
        Calificador calificador = new ComparadorConOrden(new CalificadorPenalizado());
        pregunta.asignarCalificador(calificador);
        pregunta.conPenalidad();
        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceClasico(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        pregunta.asignarOpcionPosible(opcionesPosibles);

        Calificador calificador = new ComparadorSinOrden((new CalificadorNoPenalizado()));
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }
    public static Pregunta preguntaOrderedChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);

        pregunta.asignarOpcionPosible(opcionesPosibles);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);

        Calificador calificador = new ComparadorConOrden(new CalificadorNoPenalizado());
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoicePenalizado(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        pregunta.asignarOpcionPosible(opcionesPosibles);
        Calificador calificador = (new CalificadorPenalizado());
        pregunta.asignarCalificador(calificador);
        pregunta.conPenalidad();

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceParcial(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        pregunta.asignarOpcionPosible(opcionesPosibles);
        Calificador calificador =new ComparadorParcial (new CalificadorNoPenalizado());

        pregunta.asignarCalificador(calificador);

        return pregunta;
    }

    public static Pregunta preguntaGroupChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionPosible(opcionesPosibles);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        Calificador calificador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }
}
