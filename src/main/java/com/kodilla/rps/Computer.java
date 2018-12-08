package com.kodilla.rps;

import java.util.Random;

public class Computer implements Player {

    private final Random random = new Random();
    private final String name = "Komputer";
    private int score;


    @Override
    public int getMove() {
        return random.nextInt(2) + 1;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void addScore() {
        this.score++;
    }

    @Override
    public String getName() {
        return name;
    }
}
