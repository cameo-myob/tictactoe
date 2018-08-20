package com.company;


public class Main {

    public static void main(String[] args) {
        ConsolePrompt userPrompt = new ConsolePrompt();
        TicTacToeBoard board = new TicTacToeBoard();
        Game newGame = new Game(board, userPrompt);
        newGame.run();
    }
}
