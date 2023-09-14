package io.skaihen.proyecto.classes;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Types {

    private Types() {
    };

    public static HashMap<String, Integer> getTypeChart(String type) {
        HashMap<String, Integer> typeChart = new HashMap<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(
                System.getProperty("user.dir") + "/src/main/resources/typeChart.json")) {

            JSONArray typeChartArray = (JSONArray) jsonParser.parse(fileReader);

            typeChartArray

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return typeChart;
    }
}
