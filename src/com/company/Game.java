package com.company;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;
    private WinChecker winChecker = new WinChecker();
    private boolean gameRunning;

    public Game(GameBoard board, Prompt prompt, Player player1, Player player2) {
        this.gameBoard = board;
        this.prompt = prompt;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        printResult(new Result(gameBoard.printBoard(), "running", "Welcome to Tic Tac Toe!"));
        currentPlayer = player1;
        gameRunning = true;

        while(gameRunning){
            prompt.print(promptUserForMove(currentPlayer));
            UserMove currentMove = MoveParser.parse(prompt.getInput());
            Result moveResults = gameBoard.addMoveToBoard(currentMove, currentPlayer.getToken());
            printResult(moveResults);

            if(moveResults.status.equals("success")) { swapPlayer(); }
            if(moveResults.status.equals("end")) { gameRunning = false; }
        }
    }

    private void swapPlayer() {
        if(currentPlayer == player1){
            currentPlayer = player2;
        } else currentPlayer = player1;
    }

    private void printResult(Result result){
        prompt.print(result.message);
        prompt.print(result.board);
    }

    private String promptUserForMove(Player player) {
        String playerName = player.getName();
        String playerToken = player.getToken();

        return playerName + ", enter a coordinate x,y to place your " + playerToken + " or enter 'q' to quit: ";
    }
}
