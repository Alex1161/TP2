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
        /*
            Panel izquierdo, nombres y puntos
         */
        VBox panelIzquierdo = construirPanelIzquierdo();
        /*
            Panel central "ENUNCIADO"
         */
        VBox panelCentral = construirPanelCentral();
        /*
            Panel derecho "Tiempo"
         */
        VBox panelDerecho = contruirPanelDerecho();

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
        panelSuperior.setAlignment(Pos.CENTER);
        panelSuperior.setMinHeight(500);

        VBox principal = new VBox();

        principal.getChildren().addAll(panelSuperior, grillaDeBotones);
        respuesta1.setPrefSize(400, 60);
        respuesta2.setPrefSize(400, 60);
        respuesta3.setPrefSize(400, 60);
        respuesta4.setPrefSize(400, 60);

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


    private VBox construirPanelIzquierdo(){

        GridPane tablaDeInfo = new GridPane();
        tablaDeInfo.setPadding(new Insets(10, 10, 10, 10));
        tablaDeInfo.setVgap(10);
        tablaDeInfo.setHgap(10);
        tablaDeInfo.setAlignment(Pos.CENTER);

        Text nombre = new Text("Nombre");
        nombre.getStyleClass().add("otros-text");
        Text puntos = new Text("Puntos");
        puntos.getStyleClass().add("otros-text");
        Text j1Txt = new Text("Pepito");
        j1Txt.getStyleClass().add("otros-text");
        Text puntosJ1txt = new Text("1000");
        puntosJ1txt.getStyleClass().add("otros-text");
        Text j2Txt = new Text("Jose");
        j2Txt.getStyleClass().add("otros-text");
        Text puntosJ2txt = new Text("1000");
        puntosJ2txt.getStyleClass().add("otros-text");

        tablaDeInfo.add(nombre, 0, 0);
        tablaDeInfo.add(puntos, 1, 0);
        tablaDeInfo.add(j1Txt, 0, 1);
        tablaDeInfo.add(puntosJ1txt, 1, 1);
        tablaDeInfo.add(j2Txt, 0,2);
        tablaDeInfo.add(puntosJ2txt, 1, 2);

        VBox panelIzquierdo = new VBox();
        panelIzquierdo.getChildren().addAll(tablaDeInfo);
        panelIzquierdo.setSpacing(30);
        panelIzquierdo.setAlignment(Pos.CENTER);


        return panelIzquierdo;
    }

    public VBox construirPanelCentral(){
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
        return  panelCentral;
    }

    private VBox contruirPanelDerecho(){
        VBox panelDerecho = new VBox();
        panelDerecho.setSpacing(20);
        Label tiempoLbl = new Label("Tiempo");
        tiempoLbl.getStyleClass().add("otros-text");
        panelDerecho.getChildren().addAll(tiempoLbl);
        panelDerecho.setAlignment(Pos.CENTER);
        return panelDerecho;
    }
}
