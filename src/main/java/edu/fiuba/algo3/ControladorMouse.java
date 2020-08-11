package edu.fiuba.algo3;

import javafx.scene.input.MouseEvent;

import java.awt.event.MouseAdapter;
import java.util.Observable;

public class ControladorMouse extends MouseAdapter {
    VistaPreguntaEnCurso vistaVentana;

    ControladorMouse(VistaPreguntaEnCurso vista){
        this.vistaVentana = vista;
    }

    public void mousePressed(MouseEvent event){
        vistaVentana.update(new Observable(), "");
    }
}
