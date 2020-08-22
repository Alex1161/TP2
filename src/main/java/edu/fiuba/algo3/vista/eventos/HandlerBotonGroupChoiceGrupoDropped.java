package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HandlerBotonGroupChoiceGrupoDropped implements EventHandler<DragEvent> {

    private Panel panelJuego = Panel.getInstancia();
    //VBox grupo;
    FlowPane unGrupo;


    public HandlerBotonGroupChoiceGrupoDropped(Pane unGrupo) {

        this.unGrupo = (FlowPane) unGrupo;
    }

    @Override
    public void handle(DragEvent event) {
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        String nombreOpcion = "";
        boolean success = false;
        if (db.hasString()) {
            nombreOpcion = db.getString();
            //grupo.setText(db.getString());
            success = true;
        }
        /* let the source know whether the string was successfully
         * transferred and used */

        Button botonAgregado = new Button();
        botonAgregado.setOnDragDone(new HandlerBotonGroupChoiceDone(unGrupo, botonAgregado));
        botonAgregado.setOnDragDetected(new HandlerBotonGroupChoice(botonAgregado));
        botonAgregado.setText(nombreOpcion);

        unGrupo.getChildren().add(botonAgregado);

        event.setDropCompleted(success);

        event.consume();
    }
}
