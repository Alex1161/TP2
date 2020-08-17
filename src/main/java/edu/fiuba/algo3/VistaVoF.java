package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
//import edu.fiuba.algo3.vista.BotonProbarCambio;
import edu.fiuba.algo3.vista.eventos.HandlerBotonVerdaderoFalso;
import edu.fiuba.algo3.vista.eventos.HandlerCronometro;
import edu.fiuba.algo3.vista.VistaTemporizador;
import edu.fiuba.algo3.VistaPuntajeJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaVoF {

    GridPane grillaRespuestas;
    VistaTemporizador vistaT;
    private static String VERDADERO = "Verdadero";
    private static String FALSO = "Falso";

    public VistaVoF(Stage stage, VistaTemporizador vistaT, VistaPuntajeJugador unaVistaPuntajeParcial){
        //Button respuesta1 = new BotonProbarCambio();
        //respuesta1.setOnAction(new HandlerCronometro(vistaT));
        //respuesta1.getStyleClass().add(".button");
        Button boton1 = new Button(VERDADERO);
        boton1.getStyleClass().add("button2");
        Button boton2 = new Button(FALSO);
        boton2.getStyleClass().add("button3");

        HandlerBotonVerdaderoFalso botonVoF = new HandlerBotonVerdaderoFalso(boton1,stage,unaVistaPuntajeParcial);
        boton1.setOnAction(botonVoF);

        HandlerBotonVerdaderoFalso botonVoF2 = new HandlerBotonVerdaderoFalso(boton2,stage, unaVistaPuntajeParcial);
        boton2.setOnAction(botonVoF2);


        grillaRespuestas = new GridPane();
        grillaRespuestas.setPadding(new Insets(5, 5, 5, 5));
        grillaRespuestas.setVgap(5);
        grillaRespuestas.setHgap(5);
        grillaRespuestas.setAlignment(Pos.CENTER);
        grillaRespuestas.add(boton1, 0, 1);
        grillaRespuestas.add(boton2, 0, 0);

        boton1.setPrefSize(400, 60);
        boton2.setPrefSize(400, 60);

    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }
}
