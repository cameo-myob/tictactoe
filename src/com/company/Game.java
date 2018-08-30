package com.company;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;
    private int remainingMoves = 9;
    private WinChecker winChecker = new WinChecker();
    private boolean gameRunning = true;

    public Game(GameBoard board, Prompt prompt, Player player1, Player player2){
        this.gameBoard = board;
        this.prompt = prompt;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        prompt.print("Welcome to Tic Tac Toe!");
        prompt.print(gameBoard.printBoard());
        currentPlayer = player1;

        while(gameRunning){
            prompt.print(currentPlayer.getPlayerName() + ", enter a coordinate x,y to place your " + currentPlayer.getPlayerToken() + " or enter 'q' to quit: ");
            String currentMove = prompt.getInput();
            if(currentMove.equals("q")){ return; }
            else if(gameBoard.addMoveToBoard(MoveParser.parse(currentMove), currentPlayer.getPlayerToken())) {
                prompt.print("Move confirmed, here is the current board:");
                prompt.print(gameBoard.printBoard());
                if(winChecker.isWinningMove(gameBoard, currentPlayer.getPlayerToken()) || this.remainingMoves == 0){
                    gameRunning = false;
                    break;
                }
                swapPlayer();
                remainingMoves--;
            } else { prompt.print("There is already a token in that space, please try again."); }
        }
        prompt.print("Congratulations, " + currentPlayer.getPlayerName() + " is the winner!");
    }

    private void swapPlayer() {
        if(currentPlayer == player1){
            currentPlayer = player2;
        } else currentPlayer = player1;
    }
}
