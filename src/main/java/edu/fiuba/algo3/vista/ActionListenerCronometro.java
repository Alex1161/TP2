package edu.fiuba.algo3.vista;

import javafx.event.Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerCronometro implements ActionListener {

    VistaTemporizador vistaTemporizador;

    public ActionListenerCronometro(VistaTemporizador vista){
        vistaTemporizador = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vistaTemporizador.actualizar();
    }
}
