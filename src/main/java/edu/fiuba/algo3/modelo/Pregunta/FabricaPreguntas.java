package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Calificador.*;
import edu.fiuba.algo3.modelo.Opciones.Opciones;
import edu.fiuba.algo3.modelo.Penalidad.ConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.SinPenalidad;

public class FabricaPreguntas {

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
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);

        Calificador calificador = new ComparadorSinOrden((new CalificadorNoPenalizado()));
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }
    public static Pregunta preguntaOrderedChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);

        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);

        Calificador calificador = new ComparadorConOrden(new CalificadorNoPenalizado());
        pregunta.asignarCalificador(calificador);

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoicePenalizado(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        Calificador calificador = (new CalificadorPenalizado());
        pregunta.asignarCalificador(calificador);
        pregunta.conPenalidad();

        return pregunta;
    }

    public static Pregunta preguntaMultipleChoiceParcial(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {

        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        Calificador calificador =new ComparadorParcial (new CalificadorNoPenalizado());

        pregunta.asignarCalificador(calificador);

        return pregunta;
    }

    public static Pregunta preguntaGroupChoice(String enunciado, Opciones opcionesCorrectas, Opciones opcionesPosibles) {
        Pregunta pregunta = new Pregunta(enunciado);
        pregunta.asignarOpcionesPosibles(opcionesPosibles);
        pregunta.asignarOpcionesCorrectas(opcionesCorrectas);
        Calificador calificador = new ComparadorSinOrden(new CalificadorNoPenalizado());
        pregunta.asignarCalificador(calificador);
        return pregunta;
    }
}
