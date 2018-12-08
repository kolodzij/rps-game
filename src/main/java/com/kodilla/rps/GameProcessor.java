package com.kodilla.rps;

public class GameProcessor {

    private final Player computer;
    private final Player user;
    private int roundNumber = 0;
    private String[][] rules = new String[][]{
        {"R", "L", "W"},
        {"W", "R" ,"L"},
        {"L", "W", "R"}
    };

    public GameProcessor(Player computer, Player user) {
        this.computer = computer;
        this.user = user;
    }

    public void play() {

        int roundCount = Commander.getRoundCount();
        while(roundNumber < roundCount) {
            Commander.getRoundInfo(roundNumber);
            int computerMove = computer.getMove();
            int userMove = user.getMove();
            compareMoveAndAddScore(computerMove, userMove);
            roundNumber++;
        }
        Commander.gameOver(user.getScore(),computer.getScore());
    }

    private void compareMoveAndAddScore(int computerMove, int userMove) {
        String result = rules[computerMove-1][userMove-1];
        switch (result) {
            case "R":
                Commander.showRemis();
                break;
            case "L":
                Commander.showUserLost();
                computer.addScore();
                break;
            case "W":
                Commander.showUserWin();
                user.addScore();
                break;
        }
    }
}
