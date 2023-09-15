package io.skaihen.proyecto.classes;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

final public class Types {

    private Types() {
    };

    public static HashMap<String, Integer> getTypeChart(String type) {
        HashMap<String, Integer> typeChart = new HashMap<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(
                System.getProperty("user.dir") + "/src/main/resources/typeChart.json")) {

            JSONObject jsonObj = (JSONObject) jsonParser.parse(fileReader);

            typeChart.putAll(new ObjectMapper().readValue(jsonObj.get(type).toString(), HashMap.class));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return typeChart;
    }
}
