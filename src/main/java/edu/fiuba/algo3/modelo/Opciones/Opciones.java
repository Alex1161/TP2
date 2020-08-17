package edu.fiuba.algo3.modelo.Opciones;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Opciones {
    private Collection<String> elementos = new ArrayList<String>();

    private Collection<String> elementos(){
        return elementos;
    }

    public void agregarOpcion(String elemento) {
        elementos.add(elemento);
    }

    public Collection<String> obtenerOpciones(){
        return elementos;
    }

    public int cantidadDeOpciones(){return this.elementos().size();}

    public boolean esta(String opcion) {
        return elementos.contains(opcion);
    }


    public boolean compararSinOrden(Opciones opciones) {
        Collection<String> misOpciones = new HashSet<String>(this.elementos);
        Collection<String> opcionesAComparar = new HashSet<String>(opciones.elementos());

        return misOpciones.equals(opcionesAComparar);
    }

    public boolean compararConOrden(Opciones opciones) {
        Collection<String> misOpciones = new LinkedList<String>(this.elementos);
        Collection<String> opcionesAComparar = new LinkedList<String>(opciones.elementos());

        return misOpciones.equals(opcionesAComparar);
    }

    public void agregarOpciones(Opciones opciones) {
        elementos.addAll(opciones.elementos());
    }

    public boolean contiene(Opciones opciones) {
        Collection<String> misOpciones = new HashSet<String>(this.elementos);
        Collection<String> opcionesAComparar = new HashSet<String>(opciones.elementos());

        return misOpciones.containsAll(opcionesAComparar);
    }
}
