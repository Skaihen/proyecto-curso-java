package io.skaihen.proyecto_curso_java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.skaihen.proyecto_curso_java.classes.Move;

@SpringBootTest
public class MoveTest {

    @Test
    public void getMovesCSVTest() {
        List<Move> moves = Move.getMovesCSV();

        String[] expected1 = { "001", "Placaje", "normal", "physical", "35", "40", "100", "+0" };
        String[] expected2 = { "002", "Ataque Rapido", "normal", "physical", "30", "40", "100", "+1" };

        assertEquals(Integer.parseInt(expected1[0]), moves.get(0).getID());
        assertEquals(expected1[1], moves.get(0).getNAME());
        assertEquals(expected1[2], moves.get(0).getTYPE());
        assertEquals(expected1[3], moves.get(0).getCATEGORY());

        assertEquals(Integer.parseInt(expected2[4]), moves.get(1).getPP());
        assertEquals(Integer.parseInt(expected2[5]), moves.get(1).getPOWER());
        assertEquals(Integer.parseInt(expected2[6]), moves.get(1).getACCURACY());
        assertEquals(Integer.parseInt(expected2[7]), moves.get(1).getPRIORITY());

    }
}
