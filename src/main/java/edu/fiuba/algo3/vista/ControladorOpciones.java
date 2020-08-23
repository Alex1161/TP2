package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Juego;

import java.util.ArrayList;
import java.util.List;

public class ControladorOpciones {
    List<String> opcionesElegidas = new ArrayList<String>();
    Juego juego = Juego.getInstancia();

    public void agregarOpcion(String opcion) {
        opcionesElegidas.add(opcion);
    }

    public void enviarRespuestas() {
        juego.responder(opcionesElegidas);
    }

    public void quitarOpcion(String opcion) {
        opcionesElegidas.remove(opcion);
    }

    public void pasarOpcionesElegidas() {
        juego.responder(opcionesElegidas);
    }
}
