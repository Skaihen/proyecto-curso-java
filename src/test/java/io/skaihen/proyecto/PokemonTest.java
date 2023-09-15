package io.skaihen.proyecto;

import org.junit.Test;

import io.skaihen.proyecto.classes.Move;
import io.skaihen.proyecto.classes.Pokemon;

public class PokemonTest {

    @Test
    public void pokemonReciveAttackTest() {
        Pokemon pikachu = new Pokemon(1, "Geodude", "rock", "ground", 8, 40, 80, 100, 30, 30, 20);

        pikachu.recieveAttack(Move.getMovesCSV().get(0),
                new Pokemon(1, "Geodude", "rock", "ground", 8, 40, 80, 100, 30, 30, 20));

        System.out.println(pikachu.getHp());
    }
}
