package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.eventos.HandlerBotonAccionarComodin;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class VistaAccionesJugador {
    private static String ENCABEZADO_NOMBRE = "Turno";

    VBox panelAccionesDiponiblesJugador;
    Text encabezadoNombre;
    Text nombreJugadorActual;

    Jugador jugadorActual;
    Pregunta preguntaActual;
    Panel panelJuego = Panel.getInstancia();


    public VistaAccionesJugador() {
        this.jugadorActual = panelJuego.jugadorActual();
        //preguntaActual = this.panelJuego.preguntaActual();


        this.encabezadoNombre = new Text(ENCABEZADO_NOMBRE);
        this.encabezadoNombre.setFont(new Font(25));

        this.nombreJugadorActual = new Text(jugadorActual.getNombre());
        this.nombreJugadorActual.setFont(new Font(45));

        this.panelAccionesDiponiblesJugador = new VBox();
        this.panelAccionesDiponiblesJugador.setAlignment(Pos.CENTER);
        this.panelAccionesDiponiblesJugador.setSpacing(10);

        this.panelAccionesDiponiblesJugador.getChildren().addAll(encabezadoNombre, nombreJugadorActual);

        for( Comodin comodinDisponible: jugadorActual.obtenerComodines()){
            Button botonActual = new Button("Activar" + comodinDisponible.obtenerNombre());
            botonActual.getStyleClass().add("botonPrimario");
            HandlerBotonAccionarComodin manejadorAccionComodin = new HandlerBotonAccionarComodin(jugadorActual, botonActual, comodinDisponible);
            botonActual.setOnAction(manejadorAccionComodin);
            this.panelAccionesDiponiblesJugador.getChildren().add(botonActual);
        }

        //dibujar();
    }

    public void dibujar(){

        //this.panelAccionesDiponiblesJugador.getChildren().removeAll();
        //this.panelAccionesDiponiblesJugador.getChildren().addAll(encabezadoNombre, nombreJugadorActual, botonMultiplicadorX2, botonMultiplicadorX3, botonExclusividad);
    }

    public VBox obtenerPanelInfoJugadores() {
        return this.panelAccionesDiponiblesJugador;
    }

}



