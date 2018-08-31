package com.company;

public class Main {

    public static void main(String[] args) {
        ConsolePrompt userPrompt = new ConsolePrompt();
        TicTacToeBoard board = new TicTacToeBoard();
        Player player1 = getPlayerInfo(userPompt);

        Game ticTacToe = new Game(board, userPrompt, player1, player2);
        ticTacToe.run();
    }

    private static Player getPlayerInfo(ConsolePrompt prompt){
        prompt.print("Please enter Player name:");
        String playerName = prompt.getInput();
        prompt.print("Please enter Player token:");
        String playerToken = prompt.getInput();
        return new Player(playerName, playerToken);
    }

}
