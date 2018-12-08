package com.kodilla.rps;

public class User implements Player {

    private final String name;
    private int score;

    public User(String name) {
        this.name = name;
    }

    @Override
    public int getMove() {
        return Commander.getMove();
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
        return this.name;
    }
}
