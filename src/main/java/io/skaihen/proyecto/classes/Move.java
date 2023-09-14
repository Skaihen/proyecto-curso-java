package io.skaihen.proyecto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Move {
    private final int id;
    private final String name;
    private final String type;
    private final String category;
    private final int pp;
    private final int power;
    private final int accuracy;
    private final int priority;

    public Move(int id, String name, String type, String category, int pp, int power, int accuracy, int priority) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.pp = pp;
        this.power = power;
        this.accuracy = accuracy;
        this.priority = priority;
    }

    public static List<Move> getMovesCSV() {
        List<Move> moves = new ArrayList<>();
        List<List<String>> movesList = new ArrayList<>();

        try (BufferedReader bfreader = new BufferedReader(
                new FileReader(System.getProperty("user.dir") + "/src/main/resources/movesList.csv"))) {

            String line;

            while ((line = bfreader.readLine()) != null) {
                String[] values = line.split(",");
                movesList.add(Arrays.asList(values));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (List<String> move : movesList) {
            moves.add(new Move(
                    Integer.parseInt(move.get(0)),
                    move.get(1),
                    move.get(2),
                    move.get(3),
                    Integer.parseInt(move.get(4)),
                    Integer.parseInt(move.get(5)),
                    Integer.parseInt(move.get(6)),
                    Integer.parseInt(move.get(7))));
        }

        return moves;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public int getPp() {
        return pp;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPriority() {
        return priority;
    }
}
