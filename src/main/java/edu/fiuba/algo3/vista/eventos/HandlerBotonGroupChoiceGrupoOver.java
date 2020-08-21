package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HandlerBotonGroupChoiceGrupoOver implements EventHandler<DragEvent> {

    private Panel panelJuego = Panel.getInstancia();
    FlowPane grupo1;

    public HandlerBotonGroupChoiceGrupoOver(Pane unGrupo1) {
        this.grupo1 = (FlowPane) unGrupo1;
    }

    @Override
    public void handle(DragEvent event) {
        /* accept it only if it is  not dragged from the same node
         * and if it has a string data */
        if (event.getGestureSource() != grupo1 &&
                event.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
}
