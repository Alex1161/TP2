package edu.fiuba.algo3.modelo.Pregunta;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.Opciones.Opciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonFabrica {

    public Pregunta recuperar(JsonObject jsonObjectPregunta) {

        String tipo = jsonObjectPregunta.get("tipoDePregunta").getAsString();
        String enunciado = jsonObjectPregunta.get("enunciado").getAsString();

        Opciones opcionesCorrectas= new Opciones();
        JsonArray arrayOpciones = jsonObjectPregunta.getAsJsonArray("opcionesCorrectas");
        for (JsonElement jsonOpcion : arrayOpciones) {
            String opcion = jsonOpcion.getAsString();
            opcionesCorrectas.agregarOpcion(opcion);
        }

        Opciones opcionesPosibles=new Opciones();
        JsonArray arrayOpcionesOpcionales = jsonObjectPregunta.getAsJsonArray("opcionesPosibles");
        for (JsonElement jsonOpcion : arrayOpcionesOpcionales) {
            String opcion = jsonOpcion.getAsString();
            opcionesPosibles.agregarOpcion(opcion);
        }
        FabricaPreguntas fabricaPregunta=new FabricaPreguntas();

        Pregunta pregunta=fabricaPregunta.crearPregunta(tipo,enunciado,opcionesCorrectas,opcionesPosibles);

        return pregunta;
    }

    public Pregunta recuperar() throws IOException {
        String texto = Files.readString(Path.of("Pregunta.json"));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }


    public List<Pregunta> recuperarPreguntas(JsonObject jsonObjectPreguntas) {
        List<Pregunta> preguntas=new ArrayList<>();
        JsonArray arrayPreguntas = jsonObjectPreguntas.getAsJsonArray("Preguntas");
        for (JsonElement jsonPregunta : arrayPreguntas) {
            JsonFabrica fabrica=new JsonFabrica();
            Pregunta pregunta = fabrica.recuperar(jsonPregunta.getAsJsonObject());
            preguntas.add(pregunta);
        }

        return preguntas;
    }

    public List<Pregunta>  recuperarPreguntas() throws IOException {
        String texto = Files.readString(Path.of("Preguntas.json"));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperarPreguntas(jsonObject);
    }



}
