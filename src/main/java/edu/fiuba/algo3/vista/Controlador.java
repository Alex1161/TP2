package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Juego;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    List<String> opcionesElegidas = new ArrayList<String>();
    Juego juego = Juego.getInstancia();

    public void agregarOpcion(String opcion) {
        opcionesElegidas.add(opcion);
    }

    public void enviarRespuestas() {
        juego.responder(opcionesElegidas);
    }
}
