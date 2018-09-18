package com.company;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;

    public Game(GameBoard board, Prompt prompt, Player player1, Player player2) {
        this.gameBoard = board;
        this.prompt = prompt;
        this.player1 = player1;
        this.player2 = player2;
    }

    // TODO: return result instead of void
    public void run() {
        prompt.print("Welcome to Tic Tac Toe!");
        currentPlayer = player1;
        boolean gameRunning = true;

        while (gameRunning) {
            prompt.print(currentPlayer);
            String userInput = prompt.getInput();
            while(!InputValidator.validate(userInput)){
                prompt.print(currentPlayer);
                userInput = prompt.getInput();
            }
            UserMove currentMove = MoveParser.parse(userInput);

            Result result = gameBoard.addMoveToBoard(currentMove, currentPlayer);
            prompt.print(result);

            switch (result.getStatus()) {
                case WIN:
                case DRAW: {
                    gameRunning = false;
                }
                case CONTINUE: {
                    swapPlayer();
                }
            }
        }
    }

    private void swapPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
