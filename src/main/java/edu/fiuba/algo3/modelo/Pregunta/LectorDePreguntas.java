package edu.fiuba.algo3.modelo.Pregunta;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LectorDePreguntas {

    private Pregunta _recuperarPregunta(JsonObject jsonObjectPregunta) {

        String tipo = jsonObjectPregunta.get("tipoDePregunta").getAsString();
        String enunciado = jsonObjectPregunta.get("enunciado").getAsString();

        Opciones opcionesCorrectas = new Opciones();
        JsonArray arrayOpciones = jsonObjectPregunta.getAsJsonArray("opcionesCorrectas");
        for (JsonElement jsonOpcion : arrayOpciones) {
            String opcion = jsonOpcion.getAsString();
            opcionesCorrectas.agregarOpcion(opcion);
        }

        Opciones opcionesPosibles = new Opciones();
        JsonArray arrayOpcionesOpcionales = jsonObjectPregunta.getAsJsonArray("opcionesPosibles");
        for (JsonElement jsonOpcion : arrayOpcionesOpcionales) {
            String opcion = jsonOpcion.getAsString();
            opcionesPosibles.agregarOpcion(opcion);
        }
        CreadorDePreguntas fabricaPregunta = new CreadorDePreguntas();

        Pregunta pregunta = fabricaPregunta.crearPregunta(tipo, enunciado, opcionesCorrectas, opcionesPosibles);

        return pregunta;
    }

    private List<Pregunta> _recuperarPreguntas(JsonObject jsonObjectPreguntas) {
        List<Pregunta> preguntas = new ArrayList<>();
        JsonArray arrayPreguntas = jsonObjectPreguntas.getAsJsonArray("Preguntas");
        for (JsonElement jsonPregunta : arrayPreguntas) {
            LectorDePreguntas fabrica = new LectorDePreguntas();
            Pregunta pregunta = fabrica._recuperarPregunta(jsonPregunta.getAsJsonObject());
            preguntas.add(pregunta);
        }

        return preguntas;
    }

    public Pregunta recuperarPregunta(String src_Pregunta) throws IOException{
        String texto = Files.readString(Path.of(src_Pregunta));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return _recuperarPregunta(jsonObject);
    }

    public List<Pregunta> recuperarPreguntas(String src_Preguntas) throws IOException {
        String texto = Files.readString(Path.of(src_Preguntas));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return _recuperarPreguntas(jsonObject);
    }

}
