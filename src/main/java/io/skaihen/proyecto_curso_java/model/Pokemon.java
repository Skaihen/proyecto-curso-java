package io.skaihen.proyecto_curso_java.model;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    /**
     * Calcula el daño recibido por un ataque enemigo y lo resta a la vida del
     * pokemon.
     *
     * @param move         Movimiento realizado por el enemigo.
     * @param enemyPokemon Pokemon enemigo.
     */
    public void receiveAttack(Move move, Pokemon enemyPokemon) {
        Map<String, Double> typeChart = Types.getTypeChart(move.getType());

        int totalDamage = (int) 0.5 * move.getPower()
                * ("physical".equals(move.getCategory()) ? enemyPokemon.getAttack() / this.getDefense()
                        : enemyPokemon.getSpecialAttack() / this.getSpecialDefense());

        for (Map.Entry<String, Double> entry : typeChart.entrySet()) {
            if (Objects.equals(entry.getKey(), this.getType1()) || Objects.equals(entry.getKey(), this.getType2())) {
                totalDamage = (int) Math.round(totalDamage * entry.getValue());
            }
        }

        if (Objects.equals(enemyPokemon.getType1(), move.getType())
                || Objects.equals(enemyPokemon.getType2(), move.getType())) {
            totalDamage *= 1.5;
        }

        this.hp -= (totalDamage * (random.nextDouble(0.25) + 0.5)) + 1;
    }
}
