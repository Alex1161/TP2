package edu.fiuba.algo3.vista;

//import edu.fiuba.algo3.Controlador;
import edu.fiuba.algo3.vista.botones.BotonParaJugar;
import edu.fiuba.algo3.vista.eventos.HandlerBotonParaJugar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaIngresoDeJugadores{

    private static final String URL_FONDO = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/kahootEditar.png";
    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    BorderPane layoutInicial;
    BotonParaJugar unBoton;
    HandlerBotonParaJugar handlerBotonParaJugar;
    Scene proximaVistaEscena;
    Stage ventana;

    public VistaIngresoDeJugadores(Stage stage){
        this.ventana = stage;
        //this.proximaVistaEscena = unaProximaVistaEscena;

        this.layoutInicial = new BorderPane();


        Label textoInfo = new Label("Ingrese el nombre del primer jugador e ingrese 'ENTER' ");

        /* Deberia ser una clase VistaSolicitudNombre e instanciar al constructor 2 veces pasandole por parámetro El correspondiente Jugador */
        TextField solicitudNombre1 = new TextField();
        solicitudNombre1.setPromptText("Ingrese Nombre De Jugador1");
        solicitudNombre1.setPadding(new Insets(10));

        TextField solicitudNombre2 = new TextField();
        solicitudNombre2.setPromptText("Ingrese Nombre De Jugador2");
        solicitudNombre2.setPadding(new Insets(10));

        VBox cuadro = new VBox(solicitudNombre1, solicitudNombre2);

        this.unBoton = new BotonParaJugar(ventana, solicitudNombre1, solicitudNombre2,cuadro);
        cuadro.getChildren().addAll(unBoton);

        cuadro.setSpacing(20);
        cuadro.setAlignment(Pos.CENTER);
        cuadro.setMaxWidth(400);

        setFondoDePantalla(layoutInicial, URL_FONDO);

        layoutInicial.setCenter(cuadro);
    }

    private void setFondoDePantalla(BorderPane miPanel, String src){
        Image fondoPantallaInicial = new Image(src);
        BackgroundSize bSize =
                new BackgroundSize(ANCHO,
                        ALTO,
                        false,
                        false,
                        true, false);

        miPanel.setBackground(new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }


    public BorderPane getVista() {
        return layoutInicial;
    }
}
