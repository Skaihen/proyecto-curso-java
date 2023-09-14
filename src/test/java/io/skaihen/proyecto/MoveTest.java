package io.skaihen.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Test;

import io.skaihen.proyecto.classes.Move;

public class MoveTest {

    @Test
    public void getMovesCSVTest() {
        List<Move> moves = Move.getMovesCSV();

        String[] expected1 = { "001", "Placaje", "normal", "physical", "35", "40", "100", "+0" };
        String[] expected2 = { "002", "Ataque Rapido", "normal", "physical", "30", "40", "100", "+1" };

        assertEquals(Integer.parseInt(expected1[0]), moves.get(0).getId());
        assertEquals(expected1[1], moves.get(0).getName());
        assertEquals(expected1[2], moves.get(0).getType());
        assertEquals(expected1[3], moves.get(0).getCategory());

        assertEquals(Integer.parseInt(expected2[4]), moves.get(1).getPp());
        assertEquals(Integer.parseInt(expected2[5]), moves.get(1).getPower());
        assertEquals(Integer.parseInt(expected2[6]), moves.get(1).getAccuracy());
        assertEquals(Integer.parseInt(expected2[7]), moves.get(1).getPriority());

    }
}
