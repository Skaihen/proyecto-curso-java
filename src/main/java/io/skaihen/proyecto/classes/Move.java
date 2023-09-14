package io.skaihen.proyecto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Move {
    private final int ID;
    private final String NAME;
    private final String TYPE;
    private final String CATEGORY;
    private final int PP;
    private final int POWER;
    private final int ACCURACY;
    private final int PRIORITY;

    public Move(int id, String name, String type, String category, int pp, int power, int accuracy, int priority) {
        this.ID = id;
        this.NAME = name;
        this.TYPE = type;
        this.CATEGORY = category;
        this.PP = pp;
        this.POWER = power;
        this.ACCURACY = accuracy;
        this.PRIORITY = priority;
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

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public int getPP() {
        return PP;
    }

    public int getPOWER() {
        return POWER;
    }

    public int getACCURACY() {
        return ACCURACY;
    }

    public int getPRIORITY() {
        return PRIORITY;
    }

}
