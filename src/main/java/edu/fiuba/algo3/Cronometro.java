package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ActionListenerCronometro;
import edu.fiuba.algo3.vista.HandlerCronometro;

import javax.swing.*;

public class Cronometro {

    Timer timer;

    ActionListenerCronometro handlerCronometro;

    public Cronometro(ActionListenerCronometro ALCronometro) {
        this.handlerCronometro = ALCronometro;
        timer = new Timer(5000,handlerCronometro);
    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }
}
