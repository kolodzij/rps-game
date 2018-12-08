package com.kodilla.rps;

public class GameController {

    public static void main(String[] args) {
        Commander.startInfo();
        Player computer = new Computer();
        String userName = Commander.getName();
        Player user = new User(userName);

        do {
            GameProcessor gameProcessor = new GameProcessor(computer, user);
            gameProcessor.play();
        } while (Commander.playAgain());
    }
}
