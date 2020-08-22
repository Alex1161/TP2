package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.ControladorPrincipal;
import edu.fiuba.algo3.Panel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTemporizador {

    private static final String IMGFOLDER = "file:src/main/java/edu/fiuba/algo3/Recursos/TemporizadorImg/";
    Label tiempoLbl;
    VBox contenedorTemporizador;
    int tiempoRestante;
    Text tiempoRestanteTxt;
    Timer timer;
    AnimacionImagen animacionImagen;
    Image imagenBack;
    ImageView imageView;
    int contador = 0;
    public VistaTemporizador(){
        contenedorTemporizador = new VBox();
        tiempoLbl = new Label("Tiempo");
        tiempoRestante =ControladorPrincipal.getInstancia().obtenerTiempoEnMilisegundos()/1000;
        contenedorTemporizador.setSpacing(20);
        tiempoRestanteTxt = new Text(String.valueOf(tiempoRestante));

        tiempoLbl.getStyleClass().add("tiempo-text");
        tiempoRestanteTxt.getStyleClass().add("tiempo-text");

        timer = new Timer(125, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
                //animar();
            }
        });

        setearImagenes();
        StackPane panel = new StackPane();
        panel.getChildren().addAll(imageView, tiempoRestanteTxt);

        contenedorTemporizador.getStyleClass().add("otros-text");
        contenedorTemporizador.getChildren().addAll(tiempoLbl, panel);
        contenedorTemporizador.setAlignment(Pos.CENTER);
        iniciarTempo();
    }

    public VBox obtenerPanelTemporizador(){
        return contenedorTemporizador;
    }

    public void dibujar(){
        //contenedorTemporizador.getChildren().add(tiempoRestanteTxt);
    }

    public void iniciarTempo(){
        timer.start();
    }

    public void actualizar(){
        animacionImagen = animacionImagen.obtenerSiguiente();
        imagenBack = animacionImagen.getImage();

        imageView.setImage(imagenBack);
        if(contador == 7){
            tiempoRestante--;
            tiempoRestanteTxt.setText(String.valueOf(tiempoRestante));
            contador = 0;
        }else{
            contador ++;
        }
        this.dibujar();
    }

    public void animar(){

    }

    public void setearImagenes(){
        AnimacionImagen imagen1 = new AnimacionImagen(IMGFOLDER + "Timmer1.png");
        AnimacionImagen imagen2 = new AnimacionImagen(IMGFOLDER + "Timmer2.png");
        AnimacionImagen imagen3 = new AnimacionImagen(IMGFOLDER + "Timmer3.png");
        AnimacionImagen imagen4 = new AnimacionImagen(IMGFOLDER + "Timmer4.png");
        AnimacionImagen imagen5 = new AnimacionImagen(IMGFOLDER + "Timmer5.png");
        AnimacionImagen imagen6 = new AnimacionImagen(IMGFOLDER + "Timmer6.png");
        AnimacionImagen imagen7 = new AnimacionImagen(IMGFOLDER + "Timmer7.png");
        animacionImagen = new AnimacionImagen(IMGFOLDER + "Timmer0.png");
        imagen1.setNext(imagen2);
        imagen2.setNext(imagen3);
        imagen3.setNext(imagen4);
        imagen4.setNext(imagen5);
        imagen5.setNext(imagen6);
        imagen6.setNext(imagen7);
        imagen7.setNext(animacionImagen);
        animacionImagen.setNext(imagen1);
        imagenBack = animacionImagen.getImage();
        imageView = new ImageView(imagenBack);
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
    }
}
