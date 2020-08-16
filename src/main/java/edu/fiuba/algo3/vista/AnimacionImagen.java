package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;


public class AnimacionImagen{
    AnimacionImagen next;
    Image image;

    public AnimacionImagen(String file){
        image = new Image(file);
    }

    public Image getImage() {
        return image;
    }

    public void setNext(AnimacionImagen next){
        this.next = next;
    }

    public AnimacionImagen obtenerSiguiente(){
        return next;
    }
}
