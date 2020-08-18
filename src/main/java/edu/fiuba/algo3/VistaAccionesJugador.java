package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Comodin.Comodin;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vista.eventos.HandlerBotonAccionarExclusividad;
import edu.fiuba.algo3.vista.eventos.HandlerBotonAccionarMultiplicadorX2;
import edu.fiuba.algo3.vista.eventos.HandlerBotonAccionarMultiplicadorX3;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class VistaAccionesJugador {
    private static String ENCABEZADO_NOMBRE = "Turno";

    VBox panelAccionesDiponiblesJugador;
    /*
    BotonExclusividad botonExclusividad;
    BotonMultiplicadorX2 botonMultiplicadorX2;
    BotonMultiplicadorX3 botonMultiplicadorX3;
    */
    Text encabezadoNombre;
    Text nombreJugadorActual;

    Button botonExclusividad;
    Button botonMultiplicadorX2;
    Button botonMultiplicadorX3;

    Jugador jugadorActual;
    Panel panelJuego = Panel.getInstancia();


    public VistaAccionesJugador() {
        this.jugadorActual = panelJuego.jugadorActual();



        this.encabezadoNombre = new Text(ENCABEZADO_NOMBRE);
        this.encabezadoNombre.setFont(new Font(25));

        this.nombreJugadorActual = new Text(jugadorActual.getNombre());
        this.nombreJugadorActual.setFont(new Font(45));

        /*for( Comodin comodinDisponible: jugadorActual.obtenerComodines()){
            Button botonActual = new Button("Activar" + comodinDisponible.getNombre());

        }

         */


        this.botonMultiplicadorX2 = new Button("Activar MultiplicadorX2");

        this.botonMultiplicadorX2.setOnAction(new HandlerBotonAccionarMultiplicadorX2(jugadorActual, botonMultiplicadorX2));

        this.botonMultiplicadorX3 = new Button("Activar MultiplicadorX3");
        this.botonMultiplicadorX3.setOnAction(new HandlerBotonAccionarMultiplicadorX3(jugadorActual, botonMultiplicadorX3));


        this.botonExclusividad = new Button("Activar Exclusividad");
        this.botonExclusividad.setOnAction(new HandlerBotonAccionarExclusividad(jugadorActual, botonExclusividad));


        this.panelAccionesDiponiblesJugador = new VBox();
        this.panelAccionesDiponiblesJugador.setAlignment(Pos.CENTER);
        this.panelAccionesDiponiblesJugador.setSpacing(10);


        dibujar();
    }

    public void dibujar(){

        this.panelAccionesDiponiblesJugador.getChildren().removeAll();
        this.panelAccionesDiponiblesJugador.getChildren().addAll(encabezadoNombre, nombreJugadorActual, botonMultiplicadorX2, botonMultiplicadorX3, botonExclusividad);
    }

    public VBox obtenerPanelInfoJugadores() {
        return this.panelAccionesDiponiblesJugador;
    }

}



