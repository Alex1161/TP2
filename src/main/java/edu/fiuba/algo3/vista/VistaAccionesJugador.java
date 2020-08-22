package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Comodin.Exclusividad;
import edu.fiuba.algo3.modelo.Comodin.Multiplicador;
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
    Panel panelJuego = Panel.getInstancia();


    public VistaAccionesJugador() {
        this.jugadorActual = panelJuego.jugadorActual();
        String tipoPregunta = panelJuego.tipoPreguntaActual();

        this.encabezadoNombre = new Text(ENCABEZADO_NOMBRE);
        this.encabezadoNombre.setFont(new Font(25));

        this.nombreJugadorActual = new Text(jugadorActual.getNombre());
        this.nombreJugadorActual.setFont(new Font(45));

        this.panelAccionesDiponiblesJugador = new VBox();
        this.panelAccionesDiponiblesJugador.setAlignment(Pos.CENTER);
        this.panelAccionesDiponiblesJugador.setSpacing(10);

        this.panelAccionesDiponiblesJugador.getChildren().addAll(encabezadoNombre, nombreJugadorActual);

        if ( tipoPregunta.contains("Penalizado") ) {
            for (Comodin comodinDisponible : jugadorActual.obtenerComodines()) {
                if (comodinDisponible instanceof Multiplicador) {
                    Button botonActual = new Button("Activar" + comodinDisponible.obtenerNombre());
                    botonActual.getStyleClass().add("botonPrimario");
                    HandlerBotonAccionarComodin manejadorAccionComodin = new HandlerBotonAccionarComodin(botonActual, comodinDisponible, panelAccionesDiponiblesJugador);
                    botonActual.setOnAction(manejadorAccionComodin);
                    this.panelAccionesDiponiblesJugador.getChildren().add(botonActual);
                }
            }
        }else{
            for (Comodin comodinDisponible : jugadorActual.obtenerComodines()) {
                if (comodinDisponible instanceof Exclusividad) {
                    Button botonActual = new Button("Activar" + comodinDisponible.obtenerNombre());
                    botonActual.getStyleClass().add("botonPrimario");
                    HandlerBotonAccionarComodin manejadorAccionComodin = new HandlerBotonAccionarComodin(botonActual, comodinDisponible, panelAccionesDiponiblesJugador);
                    botonActual.setOnAction(manejadorAccionComodin);
                    this.panelAccionesDiponiblesJugador.getChildren().add(botonActual);
                }
            }
        }
    }

    public VBox obtenerPanelInfoJugadores() {
        return this.panelAccionesDiponiblesJugador;
    }

}



