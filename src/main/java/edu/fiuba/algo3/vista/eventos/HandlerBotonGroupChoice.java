package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.Panel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class HandlerBotonGroupChoice implements EventHandler<MouseEvent> {

    private Panel panelJuego = Panel.getInstancia();
    Button btn;
    //String opcion;
    public HandlerBotonGroupChoice(Button btn) {
        this.btn = btn;
    }

    @Override
    public void handle(MouseEvent event) {
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");

        /* allow any transfer mode */
        Dragboard db = btn.startDragAndDrop(TransferMode.ANY);

        /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(btn.getText());
        db.setContent(content);
        event.consume();
    }
}
