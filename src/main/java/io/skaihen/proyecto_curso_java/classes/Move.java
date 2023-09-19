package io.skaihen.proyecto_curso_java.classes;

public class Move {
    private final String name;
    private final String type;
    private final String category;
    private final int pp;
    private final int power;
    private final int accuracy;
    private final int priority;

    public Move(String name, String type, String category, int pp, int power, int accuracy, int priority) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.pp = pp;
        this.power = power;
        this.accuracy = accuracy;
        this.priority = priority;
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
