package com.company;


public class Main {

    public static void main(String[] args) {
        ConsolePrompt userPrompt = new ConsolePrompt();
        GameBoard board = new GameBoard();
        Game newGame = new Game(board, userPrompt);
        newGame.run();
    }
}
