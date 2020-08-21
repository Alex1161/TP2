package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HandlerBotonGroupChoiceDone implements EventHandler<DragEvent> {

    private Panel panelJuego = Panel.getInstancia();
    Button btn;
    GridPane grillaPanel;
    Pane elemento;

    public HandlerBotonGroupChoiceDone(Pane grillaPanel, Button unBoton) {
        this.btn = unBoton;
        //this.grillaPanel = grillaPanel;
        this.elemento = grillaPanel;
    }

    @Override
    public void handle(DragEvent event) {
        System.out.println("onDragDone");
        if (event.getTransferMode() == TransferMode.MOVE) {
            elemento.getChildren().remove(btn);
        }
        event.consume();
    }
}
