package io.skaihen.proyecto_curso_java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.skaihen.proyecto_curso_java.classes.Move;

@SpringBootTest
class MoveTest {

    @Test
    void getMovesCSVTest() {

        Move placaje = new Move("Placaje", "normal", "physical", 35, 40, 100, 0);
        Move ataqueRapido = new Move("Ataque Rapido", "normal", "physical", 30, 40, 100, 1);

        String[] expected1 = { "Placaje", "normal", "physical", "35", "40", "100", "0" };
        String[] expected2 = { "Ataque Rapido", "normal", "physical", "30", "40", "100", "1" };

        assertEquals(expected1[0], placaje.getName());
        assertEquals(expected1[1], placaje.getType());
        assertEquals(expected1[2], placaje.getCategory());

        assertEquals(Integer.parseInt(expected2[3]), ataqueRapido.getPp());
        assertEquals(Integer.parseInt(expected2[4]), ataqueRapido.getPower());
        assertEquals(Integer.parseInt(expected2[5]), ataqueRapido.getAccuracy());
        assertEquals(Integer.parseInt(expected2[6]), ataqueRapido.getPriority());

    }
}
