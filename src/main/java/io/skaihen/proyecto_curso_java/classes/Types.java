package io.skaihen.proyecto_curso_java.classes;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class Types {

    private Types() {
    };

    /**
     * Toma el tipo de un ataque y devuelve un mapa con los tipos contra los que
     * tiene ventaja y desventaja.
     *
     * @param type Tipo del ataque realizado.
     * @return Mapa con tipo del pokemon defensor y la ventaja o desventaja que
     *         posee.
     */
    public static Map<String, Double> getTypeChart(String type) {
        HashMap<String, Double> typeChart = new HashMap<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(
                System.getProperty("user.dir") + "/src/main/resources/typeChart.json")) {

            JSONObject jsonObj = (JSONObject) jsonParser.parse(fileReader);

            // TODO Arreglar tipo del HashMap
            typeChart.putAll(new ObjectMapper().readValue(jsonObj.get(type).toString(), HashMap.class));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return typeChart;
    }
}
