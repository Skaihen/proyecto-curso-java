package io.skaihen.proyecto;

import io.skaihen.proyecto.classes.Move;
import io.skaihen.proyecto.classes.Pokemon;

public class App {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon(1, "Pikachu", "electric", "rock", 200, 20, 20, 20, 20, 20);

        pikachu.recieveAttack(Move.getMovesCSV().get(0));

        System.out.println(pikachu.getHp());
    }
}
