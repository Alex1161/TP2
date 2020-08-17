package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
//import edu.fiuba.algo3.vista.BotonProbarCambio;
import edu.fiuba.algo3.vista.eventos.HandlerBotonVerdaderoFalso;
import edu.fiuba.algo3.vista.eventos.HandlerCronometro;
import edu.fiuba.algo3.vista.VistaTemporizador;
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

    public VistaVoF(Stage stage, VistaTemporizador vistaT, Pregunta preguntaActual, VistaInfoJugadores unaVistaInfoJugadores,Panel unPanelDeJuego, Jugador jugador){
        //Button respuesta1 = new BotonProbarCambio();
        //respuesta1.setOnAction(new HandlerCronometro(vistaT));
        //respuesta1.getStyleClass().add(".button");
        Button botonVerdadero = new Button(VERDADERO);
        botonVerdadero.getStyleClass().add("button2");
        Button botonFalso = new Button(FALSO);
        botonFalso.getStyleClass().add("button3");

        HandlerBotonVerdaderoFalso handlerBotonVerdadero = new HandlerBotonVerdaderoFalso(botonVerdadero, stage, unaVistaInfoJugadores, unPanelDeJuego, jugador, preguntaActual);
        botonVerdadero.setOnAction(handlerBotonVerdadero);

        HandlerBotonVerdaderoFalso handlerBotonFalso = new HandlerBotonVerdaderoFalso(botonFalso, stage, unaVistaInfoJugadores, unPanelDeJuego, jugador, preguntaActual);
        botonFalso.setOnAction(handlerBotonFalso);


        grillaRespuestas = new GridPane();
        grillaRespuestas.setPadding(new Insets(5, 5, 5, 5));
        grillaRespuestas.setVgap(5);
        grillaRespuestas.setHgap(5);
        grillaRespuestas.setAlignment(Pos.CENTER);
        grillaRespuestas.add(botonVerdadero, 0, 1);
        grillaRespuestas.add(botonFalso, 0, 0);

        botonVerdadero.setPrefSize(400, 60);
        botonFalso.setPrefSize(400, 60);

    }

    public GridPane obtenerGrilla(){
        return grillaRespuestas;
    }
}
