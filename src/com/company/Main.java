package com.company;

public class Main {

    public static void main(String[] args) {
        ConsolePrompt userPrompt = new ConsolePrompt();
        TicTacToeBoard board = new TicTacToeBoard();
        Player player1 = new Player("Player 1", "X");
        Player player2 = new Player("Player 2", "O");
        Game ticTacToe = new Game(board, userPrompt, player1, player2);
        ticTacToe.run();
    }
}
