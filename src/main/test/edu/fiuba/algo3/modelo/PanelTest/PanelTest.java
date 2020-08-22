package edu.fiuba.algo3.modelo.PanelTest;

import edu.fiuba.algo3.Panel;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PanelTest {
    @Test
    public void test01CreoPanelYVerificoSuContenido(){
        Panel panelJuego = Panel.getInstancia();
        panelJuego.limpiar();
        try{
            panelJuego.cargarPreguntas();
        }catch (IOException e){
            e.getMessage();
        }
        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");
        panelJuego.agregarJugador(jugador1);
        panelJuego.agregarJugador(jugador2);
        assertTrue(panelJuego.obtenerJugadores().contains(jugador1));
        assertTrue(panelJuego.obtenerJugadores().contains(jugador2));
        assertTrue(panelJuego.preguntaActual().getTipo()=="VoFClasico");
        assertTrue(panelJuego.tieneSiguientePregunta()==true);
        panelJuego.cambiarPregunta();
        assertTrue(panelJuego.preguntaActual().getTipo()=="VoFPenalizado");
        assertTrue(panelJuego.tieneSiguientePregunta()==true);
        panelJuego.cambiarPregunta();
        assertTrue(panelJuego.preguntaActual().getTipo()=="MultipleChoiceClasico");
        assertTrue(panelJuego.tieneSiguientePregunta()==true);
        panelJuego.cambiarPregunta();
        assertTrue(panelJuego.preguntaActual().getTipo()=="MultipleChoicePenalizado");
        assertTrue(panelJuego.tieneSiguientePregunta()==true);
        panelJuego.cambiarPregunta();
        assertTrue(panelJuego.preguntaActual().getTipo()=="MultipleChoiceParcial");
        assertTrue(panelJuego.tieneSiguientePregunta()==true);
        panelJuego.cambiarPregunta();
        assertTrue(panelJuego.preguntaActual().getTipo()=="GroupChoice");

        assertTrue(panelJuego.ganadorAlgohoot().getNombre()=="Empate");
    }
    @Test
    public void test02PrueboDosPreguntasConPanel() {
        //Primer Pregunta es VoF
        String Falso="Falso";
        String Verdadero="Verdadero";
        Panel panelJuego = Panel.getInstancia();
        panelJuego.limpiar();
        try {
            panelJuego.cargarPreguntas();
        } catch (IOException e) {
            e.getMessage();
        }
        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Luis");
        panelJuego.agregarJugador(jugador1);
        panelJuego.agregarJugador(jugador2);
        panelJuego.cambiarJugador();
        assertTrue(panelJuego.jugadorActual()==jugador1);
        panelJuego.agregarOpcion(Verdadero);
        panelJuego.cambiarJugador();
        panelJuego.agregarOpcion(Falso);
        panelJuego.calificar();
        assertTrue(jugador1.puntajeValorNumerico()==0);
        assertTrue(jugador2.puntajeValorNumerico()==1);
        assertTrue(panelJuego.ganadorAlgohoot()==jugador2);

    }
}
