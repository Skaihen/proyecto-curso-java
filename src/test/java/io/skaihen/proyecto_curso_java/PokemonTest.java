package io.skaihen.proyecto_curso_java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.skaihen.proyecto_curso_java.classes.Move;
import io.skaihen.proyecto_curso_java.classes.Pokemon;

@SpringBootTest
public class PokemonTest {

    @Test
    public void pokemonReciveAttackTest() {
        Pokemon geodude = new Pokemon("Geodude", "rock", "ground", 8, 40, 80, 100, 30, 30, 20);

        Pokemon caterpie = new Pokemon("Caterpie", "bug", null, 8, 45, 30, 35, 20, 20, 45);

        geodude.recieveAttack(Move.getMovesCSV().get(0), caterpie);

        assertEquals(geodude.getHp(), 39);
    }
}
