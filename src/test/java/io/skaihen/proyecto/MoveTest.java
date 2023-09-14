package io.skaihen.proyecto;

import java.util.List;

import org.junit.Test;

import io.skaihen.proyecto.classes.Move;

public class MoveTest {

    @Test
    public void testGetMovesCSV() {
        List<Move> moves = Move.getMovesCSV();

        for (Move move : moves) {
            System.out.println(move.getName());
        }
    }
}
