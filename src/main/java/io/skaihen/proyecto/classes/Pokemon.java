package io.skaihen.proyecto.classes;

public class Pokemon {
    protected int id;
    protected String name;
    protected String type1;
    protected String type2;
    protected int hp;
    protected int attack;
    protected int defense;
    protected int specialAttack;
    protected int specialDefense;
    protected int speed;

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

    public void takeDamage(Move move) {

    };
}
