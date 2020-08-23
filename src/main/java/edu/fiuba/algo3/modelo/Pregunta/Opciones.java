package edu.fiuba.algo3.modelo.Pregunta;
import java.util.*;

public class Opciones {
    private Collection<String> elementos = new ArrayList<String>();

    //Constructores
    public Opciones(Collection<String> opcionesElegidas) {
        elementos = opcionesElegidas;
    }

    public Opciones() {

    }

    //Setters y Getters
    public Collection<String> obtenerOpciones(){
        return elementos;
    }

    public void agregarOpcion(String elemento) {
        elementos.add(elemento);
    }

    public int cantidadDeOpciones(){return this.elementos.size();}

    //Acciones
    public void agregarOpciones(Opciones opciones) {
        elementos.addAll(opciones.obtenerOpciones());
    }

    public boolean esta(String opcion) {
        return elementos.contains(opcion);
    }

    public boolean contiene(Opciones opciones) {
        Collection<String> misOpciones = new HashSet<String>(this.elementos);
        Collection<String> opcionesAComparar = new HashSet<String>(opciones.obtenerOpciones());

        return misOpciones.containsAll(opcionesAComparar);
    }

    public boolean compararSinOrden(Opciones opciones) {
        Collection<String> misOpciones = new HashSet<String>(this.elementos);
        Collection<String> opcionesAComparar = new HashSet<String>(opciones.obtenerOpciones());

        return misOpciones.equals(opcionesAComparar);
    }

    public boolean compararConOrden(Opciones opciones) {
        Collection<String> misOpciones = new LinkedList<String>(this.elementos);
        Collection<String> opcionesAComparar = new LinkedList<String>(opciones.obtenerOpciones());

        return misOpciones.equals(opcionesAComparar);
    }
}
