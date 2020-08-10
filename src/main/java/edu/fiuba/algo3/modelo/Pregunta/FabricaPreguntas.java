package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.*;
import edu.fiuba.algo3.modelo.Opciones.Opciones;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipo, String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles){
        FabricaPreguntas fabrica=new FabricaPreguntas();
        switch (tipo){
            case "VoFPenalizado":
                return fabrica.preguntaVoFPenalizado(enunciado,opcionesCorrectas);

            case "VoFClasico":
                return fabrica.preguntaVoFClasico(enunciado,opcionesCorrectas);
            case "MultipleChoiceClasico":
                return  fabrica.preguntaMultipleChoiceClasico(enunciado, opcionesCorrectas, opcionesPosibles);
            case "MultipleChoicePenalizado":
                return fabrica.preguntaMultipleChoicePenalizado(enunciado,opcionesCorrectas,opcionesPosibles);
            case "MultipleChoiceParcial":
                return  FabricaPreguntas.preguntaMultipleChoiceParcial(enunciado,opcionesCorrectas,opcionesPosibles);
            case "GroupChoice":
                return FabricaPreguntas.preguntaGroupChoice(enunciado,opcionesCorrectas,opcionesPosibles);
            case "OrderChoice":
                return FabricaPreguntas.preguntaOrderedChoice(enunciado,opcionesCorrectas);
            default:
                throw new IllegalStateException("Unexpected value: " + tipo);
        }
    }
    public static  Pregunta preguntaVoFClasico(String enunciado, String opcionCorrecta){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionCorrecta);
        pregunta.asignarOpcionPosible("Verdadero");
        pregunta.asignarOpcionPosible("Falso");
        Calificador calificador = new ComparadorConOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }
    public static Pregunta preguntaVoFClasico(String enunciado, Opciones opcionCorrecta){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionCorrecta);
        pregunta.asignarOpcionPosible("Verdadero");
        pregunta.asignarOpcionPosible("Falso");
        Calificador calificador = new ComparadorConOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }

    public static Pregunta preguntaVoFPenalizado(String enunciado, String opcionCorrecta){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionCorrecta);
        pregunta.asignarOpcionPosible("Verdadero");
        pregunta.asignarOpcionPosible("Falso");
        Calificador calificador = new ComparadorConOrden(new AsignadorPenalizado());
        pregunta.asignarCalificador(calificador);
        pregunta.conPenalidad();
        return pregunta;
    }
    public static Pregunta preguntaVoFPenalizado(String enunciado, Opciones opcionCorrecta){
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionCorrecta);
        pregunta.asignarOpcionPosible("Verdadero");
        pregunta.asignarOpcionPosible("Falso");
        Calificador calificador = new ComparadorConOrden(new AsignadorPenalizado());
        pregunta.asignarCalificador(calificador);
        pregunta.conPenalidad();
        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceClasico(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        pregunta.asignarOpcionPosible(opcionesPosibles);

        Calificador calificador = new ComparadorSinOrden((new AsignadorClasico()));
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }
    public static Pregunta preguntaOrderedChoice(String enunciado, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);

        for (String opcion : opcionesPosibles.obtenerOpciones()) {
            pregunta.asignarOpcionPosible(opcion);
            pregunta.asignarOpcionCorrecta(opcion);
        }

        Calificador calificador = new ComparadorConOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoicePenalizado(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        pregunta.asignarOpcionPosible(opcionesPosibles);
        Calificador calificador = (new AsignadorPenalizado());
        pregunta.asignarCalificador(calificador);
        pregunta.conPenalidad();

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceParcial(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        pregunta.asignarOpcionPosible(opcionesPosibles);
        Calificador calificador =new ComparadorParcial (new AsignadorClasico());

        pregunta.asignarCalificador(calificador);

        return pregunta;
    }

    public static Pregunta preguntaGroupChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionPosible(opcionesPosibles);
        pregunta.asignarOpcionCorrecta(opcionesCorrectas);
        Calificador calificador = new ComparadorSinOrden(new AsignadorClasico());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }
}
