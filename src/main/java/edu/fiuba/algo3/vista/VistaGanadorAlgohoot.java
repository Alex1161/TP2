package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class VistaGanadorAlgohoot extends VBox{

    Panel panelJuego = Panel.getInstancia();
    Label labelGanador = new Label();

    private static final String URL_FONDO = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/ganador.jpg";
    private static final int ANCHO = 1024;
    private static final int ALTO = 768;
    Jugador jugadorGanador;

    public VistaGanadorAlgohoot(){
        jugadorGanador = panelJuego.ganadorAlgohoot();
        labelGanador.setText(jugadorGanador.getNombre());
        labelGanador.getStyleClass().add("ganadorAlgohoot");

        this.getChildren().add(labelGanador);
        this.setAlignment(Pos.BASELINE_CENTER);

        setFondoDePantalla(this, URL_FONDO);

    }


    private void setFondoDePantalla(VBox miPanel, String src){
        Image fondoPantallaInicial = new Image(src);
        BackgroundSize bSize =
                new BackgroundSize(0.95,
                        0.95,
                        true,
                        true,
                        false, false);

        miPanel.setBackground((new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize))));
    }
    public VBox obtenerVista() {
        return this;
    }
}
