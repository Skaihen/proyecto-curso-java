package io.skaihen.proyecto_curso_java.entities;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

import io.skaihen.proyecto_curso_java.classes.Move;
import io.skaihen.proyecto_curso_java.classes.Types;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Pokemon {
    @Transient
    private final Move[] hasMoves = new Move[4];

    private final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type1;
    private String type2;
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    protected Pokemon() {
    }

    public Pokemon(Long id, String name, String type1, String type2, int level, int hp, int attack, int defense,
            int specialAttack, int specialDefense, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    /**
     * Calcula el daño recibido por un ataque enemigo y lo resta a la vida del
     * pokemon.
     *
     * @param move         Movimiento realizado por el enemigo.
     * @param enemyPokemon Pokemon enemigo.
     */
    public void receiveAttack(Move move, Pokemon enemyPokemon) {

        // Cambiar ecuación de daño a [0.5 * power * attack/defense * type * stab *
        // random(0.75,1)] + 1

        Map<String, Double> typeChart = Types.getTypeChart(move.getType());

        int totalDamage = "physical".equals(move.getCategory())
                ? ((((((2 * enemyPokemon.getLevel()) / 5) + 2) * move.getPower() * enemyPokemon.getAttack()
                        / getDefense()) / 50) + 2)
                : ((((((2 * enemyPokemon.getLevel()) / 5) + 2) * move.getPower() * enemyPokemon.getSpecialAttack()
                        / getSpecialDefense()) / 50) + 2);

        if (Objects.equals(enemyPokemon.getType1(), move.getType())
                || Objects.equals(enemyPokemon.getType2(), move.getType())) {
            totalDamage *= 1.5;
        }

        for (Map.Entry<String, Double> entry : typeChart.entrySet()) {
            if (Objects.equals(entry.getKey(), this.getType1()) || Objects.equals(entry.getKey(), this.getType2())) {
                totalDamage = (int) Math.round(totalDamage * entry.getValue());
            }
        }

        if (totalDamage >= 1) {
            totalDamage = totalDamage * (this.getRandom().nextInt(39) + 217) / 255;
        }

        this.hp -= totalDamage;
    }

    public Move[] getHasMoves() {
        return this.hasMoves;
    }

    public Random getRandom() {
        return this.random;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return this.type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return this.type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return this.specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return this.specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Pokemon id(Long id) {
        setId(id);
        return this;
    }

    public Pokemon name(String name) {
        setName(name);
        return this;
    }

    public Pokemon type1(String type1) {
        setType1(type1);
        return this;
    }

    public Pokemon type2(String type2) {
        setType2(type2);
        return this;
    }

    public Pokemon level(int level) {
        setLevel(level);
        return this;
    }

    public Pokemon hp(int hp) {
        setHp(hp);
        return this;
    }

    public Pokemon attack(int attack) {
        setAttack(attack);
        return this;
    }

    public Pokemon defense(int defense) {
        setDefense(defense);
        return this;
    }

    public Pokemon specialAttack(int specialAttack) {
        setSpecialAttack(specialAttack);
        return this;
    }

    public Pokemon specialDefense(int specialDefense) {
        setSpecialDefense(specialDefense);
        return this;
    }

    public Pokemon speed(int speed) {
        setSpeed(speed);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(hasMoves, pokemon.hasMoves) && Objects.equals(random, pokemon.random)
                && Objects.equals(id, pokemon.id) && Objects.equals(name, pokemon.name)
                && Objects.equals(type1, pokemon.type1) && Objects.equals(type2, pokemon.type2)
                && level == pokemon.level && hp == pokemon.hp && attack == pokemon.attack && defense == pokemon.defense
                && specialAttack == pokemon.specialAttack && specialDefense == pokemon.specialDefense
                && speed == pokemon.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasMoves, random, id, name, type1, type2, level, hp, attack, defense, specialAttack,
                specialDefense, speed);
    }

    @Override
    public String toString() {
        return "{" +
                " hasMoves='" + getHasMoves() + "'" +
                ", random='" + getRandom() + "'" +
                ", id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", type1='" + getType1() + "'" +
                ", type2='" + getType2() + "'" +
                ", level='" + getLevel() + "'" +
                ", hp='" + getHp() + "'" +
                ", attack='" + getAttack() + "'" +
                ", defense='" + getDefense() + "'" +
                ", specialAttack='" + getSpecialAttack() + "'" +
                ", specialDefense='" + getSpecialDefense() + "'" +
                ", speed='" + getSpeed() + "'" +
                "}";
    }
}
