package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.BotonParaJugar;
import edu.fiuba.algo3.vista.BotonProbarCambio;
import edu.fiuba.algo3.vista.HandlerCronometro;
import edu.fiuba.algo3.vista.VistaTemporizador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class VistaGrillaRespuestas{

    GridPane grillaRespuestas;
    VistaTemporizador vistaT;

    public VistaGrillaRespuestas(VistaTemporizador vistaT){
        Button respuesta1 = new BotonProbarCambio();
        respuesta1.setOnAction(new HandlerCronometro(vistaT));
        respuesta1.getStyleClass().add(".button");
        Button respuesta2 = new Button("Respuesta 2");
        respuesta2.getStyleClass().add("button2");
        Button respuesta3 = new Button("Respuesta 3");
        respuesta3.getStyleClass().add("button3");
        Button respuesta4 = new Button("Respuesta 4");
        respuesta4.getStyleClass().add("my-button4");

        grillaRespuestas = new GridPane();
        grillaRespuestas.setPadding(new Insets(5, 5, 5, 5));
        grillaRespuestas.setVgap(5);
        grillaRespuestas.setHgap(5);
        grillaRespuestas.setAlignment(Pos.CENTER);
        grillaRespuestas.add(respuesta1, 0, 0);
        grillaRespuestas.add(respuesta2, 0, 1);
        grillaRespuestas.add(respuesta3, 1, 0);
        grillaRespuestas.add(respuesta4, 1, 1);

        respuesta1.setPrefSize(400, 60);
        respuesta2.setPrefSize(400, 60);
        respuesta3.setPrefSize(400, 60);
        respuesta4.setPrefSize(400, 60);

    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }
}
