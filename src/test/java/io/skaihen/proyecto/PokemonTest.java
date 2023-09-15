package io.skaihen.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import io.skaihen.proyecto.classes.Move;
import io.skaihen.proyecto.classes.Pokemon;

public class PokemonTest {

    @Test
    public void pokemonReciveAttackTest() {
        Pokemon geodude = new Pokemon("Geodude", "rock", "ground", 8, 40, 80, 100, 30, 30, 20);

        Pokemon caterpie = new Pokemon("Caterpie", "bug", null, 8, 45, 30, 35, 20, 20, 45);

        geodude.recieveAttack(Move.getMovesCSV().get(0), caterpie);

        assertEquals(geodude.getHp(), 39);
    }
}
