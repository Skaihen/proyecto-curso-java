package io.skaihen.proyecto.classes;

import java.util.HashMap;
import java.util.Map;

public class Pokemon { // No usar final en id y type1-2 para al implementar evolución poder cambiar el
                       // numero de pokemon al siguiente
    private int id;
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public Pokemon(int id, String name, String type1, String type2, int hp, int attack, int defense, int specialAttack,
            int specialDefense, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public void recieveAttack(Move move) {
        HashMap<String, Integer> typeChart = Types.getTypeChart(move.getTYPE());

        typeChart.forEach(null);

        for (Map.Entry<String, Integer> entry : typeChart.entrySet()) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }
}
