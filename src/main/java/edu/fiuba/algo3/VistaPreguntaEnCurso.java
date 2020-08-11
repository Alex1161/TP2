package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import javax.swing.JFrame;
import java.io.File;
import java.net.URL;


public class VistaPreguntaEnCurso extends JFrame{

    public VistaPreguntaEnCurso(Pregunta pregunta){
        setTitle("Vemos como funciona");
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

        /*
            Panel central "ENUNCIADO"
         */
        VBox panelCentral = new VBox();

        panelCentral.setPrefSize(400,100);
        Label enunciadoTxt = new Label("Quien fue el primer hombre que se comio una hamburguesa con queso?");
        enunciadoTxt.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        enunciadoTxt.setMaxWidth(800);
        enunciadoTxt.setWrapText(true);
        enunciadoTxt.setAlignment(Pos.CENTER);
        enunciadoTxt.getStyleClass().add("enunciado-text");
        panelCentral.getChildren().addAll(enunciadoTxt);
        panelCentral.setAlignment(Pos.CENTER);
        panelCentral.getStyleClass().add("enunciado-style");
        /*
            Panel derecho "Tiempo"
         */
        VBox panelDerecho = new VBox();
        panelDerecho.setSpacing(20);
        Label tiempoLbl = new Label("Tiempo");
        tiempoLbl.getStyleClass().add("otros-text");
        panelDerecho.getChildren().addAll(tiempoLbl);
        panelCentral.setAlignment(Pos.CENTER);

        /*
            Panel inferior
         */
        Button respuesta1 = new Button("Respuesta 1");
        respuesta1.getStyleClass().add(".button");
        Button respuesta2 = new Button("Respuesta 2");
        respuesta2.getStyleClass().add("button2");
        Button respuesta3 = new Button("Respuesta 3");
        respuesta3.getStyleClass().add("button3");
        Button respuesta4 = new Button("Respuesta 4");
        respuesta4.getStyleClass().add("my-button4");

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
        respuesta1.setPrefSize(300, 40);
        respuesta2.setPrefSize(300, 40);
        respuesta3.setPrefSize(300, 40);
        respuesta4.setPrefSize(300, 40);

        principal.getStyleClass().add("fondo-general");

        File f = new File("EstilosDeBotones.css");

        Scene escena = new Scene(principal);
        //escena.getStylesheets().clear();
        escena.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        Stage stage = new Stage();
        stage.setScene(escena);
        stage.setResizable(false);
        stage.show();
    }
}
