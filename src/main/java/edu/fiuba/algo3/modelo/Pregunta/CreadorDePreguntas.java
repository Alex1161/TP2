package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;


import edu.fiuba.algo3.modelo.Calificador.*;
import edu.fiuba.algo3.modelo.Opciones.Opciones;

public class CreadorDePreguntas {
        public Pregunta crearPregunta(String tipo, String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles){
        switch (tipo){
            case "VoFPenalizado":
                return CreadorDePreguntas.preguntaVoFPenalizado(enunciado,opcionesCorrectas);
            case "VoFClasico":
                return CreadorDePreguntas.preguntaVoFClasico(enunciado,opcionesCorrectas);
            case "MultipleChoiceClasico":
                return  CreadorDePreguntas.preguntaMultipleChoiceClasico(enunciado, opcionesCorrectas, opcionesPosibles);
            case "MultipleChoicePenalizado":
                return CreadorDePreguntas.preguntaMultipleChoicePenalizado(enunciado,opcionesCorrectas,opcionesPosibles);
            case "MultipleChoiceParcial":
                return  CreadorDePreguntas.preguntaMultipleChoiceParcial(enunciado,opcionesCorrectas,opcionesPosibles);
            case "GroupChoice":
                return CreadorDePreguntas.preguntaGroupChoice(enunciado,opcionesCorrectas,opcionesPosibles);
            case "OrderChoice":
                return CreadorDePreguntas.preguntaOrderedChoice(enunciado,opcionesCorrectas,opcionesCorrectas);
            default:
                throw new IllegalStateException("Unexpected value: " + tipo);
        }
    }
  public static Pregunta preguntaVoFClasico(String enunciado,Opciones opcionCorrecta){
        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("Verdadero");
        opcionesPosibles.agregarOpcion("Falso");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpciones(opcionCorrecta);

        Calificador calificadorSinOrdenNoPenalizado = new ComparadorSinOrden(new CalificadorNoPenalizado());

        Pregunta preguntaVoFClasico = new Pregunta(enunciado);
        preguntaVoFClasico.asignarOpcionesPosibles(opcionesPosibles);
        preguntaVoFClasico.asignarOpcionesCorrectas(opcionesCorrectas);
        preguntaVoFClasico.asignarCalificador(calificadorSinOrdenNoPenalizado);
        preguntaVoFClasico.setPenalidad(new SinPenalidad());

        return preguntaVoFClasico;

    }

    public static Pregunta preguntaVoFPenalizado(String enunciado, Opciones opcionCorrecta){
        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("Verdadero");
        opcionesPosibles.agregarOpcion("Falso");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpciones(opcionCorrecta);

        Calificador calificadorSinOrdenPenalizado = new ComparadorSinOrden(new CalificadorPenalizado());

        Pregunta preguntaVoFPenalizado = new Pregunta(enunciado);
        preguntaVoFPenalizado.asignarOpcionesPosibles(opcionesPosibles);
        preguntaVoFPenalizado.asignarOpcionesCorrectas(opcionesCorrectas);
        preguntaVoFPenalizado.asignarCalificador(calificadorSinOrdenPenalizado);
        preguntaVoFPenalizado.setPenalidad(new ConPenalidad());

        return preguntaVoFPenalizado;
    }

    public static Pregunta preguntaVoFClasico(String enunciado, String opcionCorrecta){
        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("Verdadero");
        opcionesPosibles.agregarOpcion("Falso");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion(opcionCorrecta);

        Calificador calificadorSinOrdenNoPenalizado = new ComparadorSinOrden(new CalificadorNoPenalizado());

        Pregunta preguntaVoFClasico = new Pregunta(enunciado);
        preguntaVoFClasico.asignarOpcionesPosibles(opcionesPosibles);
        preguntaVoFClasico.asignarOpcionesCorrectas(opcionesCorrectas);
        preguntaVoFClasico.asignarCalificador(calificadorSinOrdenNoPenalizado);
        preguntaVoFClasico.setPenalidad(new SinPenalidad());

        return preguntaVoFClasico;

    }

    public static Pregunta preguntaVoFPenalizado(String enunciado, String opcionCorrecta){
        Opciones opcionesPosibles = new Opciones();
        opcionesPosibles.agregarOpcion("Verdadero");
        opcionesPosibles.agregarOpcion("Falso");

        Opciones opcionesCorrectas = new Opciones();
        opcionesCorrectas.agregarOpcion(opcionCorrecta);

        Calificador calificadorSinOrdenPenalizado = new ComparadorSinOrden(new CalificadorPenalizado());

        Pregunta preguntaVoFPenalizado = new Pregunta(enunciado);
        preguntaVoFPenalizado.asignarOpcionesPosibles(opcionesPosibles);
        preguntaVoFPenalizado.asignarOpcionesCorrectas(opcionesCorrectas);
        preguntaVoFPenalizado.asignarCalificador(calificadorSinOrdenPenalizado);
        preguntaVoFPenalizado.setPenalidad(new ConPenalidad());

        return preguntaVoFPenalizado;
    }

    public static Pregunta preguntaMultipleChoiceClasico(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Calificador calificador = new ComparadorSinOrden((new CalificadorNoPenalizado()));

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarCalificador(calificador);
        pregunta.setPenalidad(new SinPenalidad());

        return pregunta;
    }

    public static Pregunta preguntaOrderedChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Calificador calificador = new ComparadorConOrden(new CalificadorNoPenalizado());

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarCalificador(calificador);
        pregunta.setPenalidad(new SinPenalidad());

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoicePenalizado(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Calificador calificador = (new CalificadorPenalizado());

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarCalificador(calificador);
        pregunta.setPenalidad(new ConPenalidad());

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceParcial(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Calificador calificador =new ComparadorParcial (new CalificadorNoPenalizado());

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarCalificador(calificador);
        pregunta.setPenalidad(new SinPenalidad());

        return pregunta;
    }

    public static Pregunta preguntaGroupChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Calificador calificador = new ComparadorSinOrden(new CalificadorNoPenalizado());

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarCalificador(calificador);
        pregunta.setPenalidad(new SinPenalidad());

        return pregunta;
    }
}
