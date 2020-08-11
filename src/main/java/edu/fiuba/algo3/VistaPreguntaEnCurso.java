package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;




public class VistaPreguntaEnCurso extends BorderPane{
    private static String URL_FONDO_PREGUNTA = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoDegradadoNaranjaPrueba.png";

    public VistaPreguntaEnCurso(/*Pregunta pregunta*/){
        super();
        Button titulo = new Button("Titulo");
        /*
            Panel izquierdo, nombres y puntos
         */
        Text j1Txt = new Text("Pepito");
        Text puntosJ1txt = new Text("1000");
        Text j2Txt = new Text("Jose");
        Text puntosJ2txt = new Text("1000");

        VBox panelIzquierdo = new VBox();
        panelIzquierdo.getChildren().addAll(j1Txt, puntosJ1txt,
                j2Txt, puntosJ2txt);
        panelIzquierdo.setSpacing(30);
        panelIzquierdo.setMargin(j1Txt, new Insets(20, 20, 20, 20));
        panelIzquierdo.setMargin(puntosJ1txt, new Insets(20, 20, 20, 20));
        panelIzquierdo.setMargin(j2Txt, new Insets(20, 20, 20, 20));
        panelIzquierdo.setMargin(puntosJ2txt, new Insets(20, 20, 20, 20));

        this.setLeft(panelIzquierdo);
        /*
            Panel central "ENUNCIADO"
         */
        VBox panelCentral = new VBox();

        //panelCentral.setPrefSize(400,100);
        Label enunciadoTxt = new Label("Quien fue el primer hombre que se comio una hamburguesa con queso?");
        enunciadoTxt.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        enunciadoTxt.setMaxWidth(600);
        enunciadoTxt.setWrapText(true);
        panelCentral.getChildren().addAll(enunciadoTxt);
        panelCentral.setAlignment(Pos.CENTER);

        this.setCenter(panelCentral);
        /*
            Panel derecho "Tiempo"
         */
        VBox panelDerecho = new VBox();
        panelDerecho.setSpacing(20);
        Label tiempoLbl = new Label("Tiempo");
        panelDerecho.getChildren().addAll(tiempoLbl);
        panelDerecho.setAlignment(Pos.TOP_RIGHT);

        this.setRight(panelDerecho);
        /*
            Panel inferior
         */
        Button respuesta1 = new Button("Respuesta 1");
        respuesta1.setStyle(".button");
        Button respuesta2 = new Button("Respuesta 2");
        respuesta1.setStyle(".button2");
        Button respuesta3 = new Button("Respuesta 3");
        respuesta1.setStyle(".button3");
        Button respuesta4 = new Button("Respuesta 4");
        respuesta1.setStyle(".button4");
        GridPane grillaDeBotones = new GridPane();
        grillaDeBotones.setPadding(new Insets(5, 5, 5, 5));
        grillaDeBotones.setVgap(5);
        grillaDeBotones.setHgap(5);
        grillaDeBotones.setAlignment(Pos.CENTER);
        grillaDeBotones.add(respuesta1, 0, 0);
        grillaDeBotones.add(respuesta2, 0, 1);
        grillaDeBotones.add(respuesta3, 1, 0);
        grillaDeBotones.add(respuesta4, 1, 1);

        TextField opciones = new TextField("opciones");
        HBox panelSuperior = new HBox();
        panelSuperior.getChildren().addAll(panelIzquierdo, panelCentral, panelDerecho);
        panelSuperior.setSpacing(20);

        VBox principal = new VBox();

        principal.getChildren().addAll(panelSuperior, grillaDeBotones);

        this.setBottom(principal);

        /*Habbría que ver la forma de tener una única función que pueda servir para cambiar el fondo de pantalla a medida que cambian las preguntas, como el hkahoot(?)*/
        Image fondoPantallaInicial = new Image(URL_FONDO_PREGUNTA);
        BackgroundSize bSize =
                new BackgroundSize(600,
                        800,
                        false,
                        false,
                        true, false);
        this.setBackground(new Background(new BackgroundImage(fondoPantallaInicial,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

    }
}
