package com.company;

// create gameboard
// create input/output

// input player details
// create players

// while board.win/board.draw false
// game get user move through input
// game send move to board

// board check if location is empty
// -- return to start of while loop if not empty
// board add move to board
// board check if win conditions (return true if won)
// board check if draw conditions (return true if draw)
// return to game


public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;


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

        while(gameBoard.running()){
            prompt.print(currentPlayer.getPlayerName() + ", enter a coordinate x,y to place your " + currentPlayer.getPlayerToken() + " or enter 'q' to quit: ");
            String nextMove = prompt.getInput();
            if(nextMove.equals("q")){ return; }
            else if(gameBoard.addMove(parseMove(nextMove), currentPlayer.getPlayerToken())) {
                prompt.print("Move confirmed, here is the current board:");
                prompt.print(gameBoard.printBoard());
                this.swapPlayer();
            } else { prompt.print("There is already a token in that space, please try again."); }
        }
        prompt.print("Congratulations, " + currentPlayer.getPlayerName() + " is the winner!");
    }

    private void swapPlayer() {
        if(currentPlayer == player1){
            currentPlayer = player2;
        } else currentPlayer = player1;
    }

    private UserMove parseMove(String input){
        String[] move = input.split(",");
        return new UserMove(Integer.parseInt(move[0]) - 1, Integer.parseInt(move[1]) - 1);
    }
}
