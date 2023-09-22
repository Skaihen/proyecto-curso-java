package io.skaihen.proyecto_curso_java.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Move {
    private final String name;
    private final String type;
    private final String category;
    private final int pp;
    private final int power;
    private final int accuracy;
    private final int priority;
}
