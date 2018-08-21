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
//

import java.util.ArrayList;

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
        prompt.gameWelcome();
        prompt.printBoard(gameBoard.returnBoard());
        currentPlayer = player1;

        while(!gameBoard.isWon() && !gameBoard.isDraw()){
            String userMove = prompt.getUserMove(currentPlayer.getPlayerName(),currentPlayer.getPlayerToken());
            if(userMove.equals("q")){
                break;
            } else if (gameBoard.isEmptySpace(userMove)){
                gameBoard.addMove(userMove, currentPlayer.getPlayerToken());
                prompt.printConfirmedMove();
                prompt.printBoard(gameBoard.returnBoard());
                if(gameBoard.isWon()){
                    prompt.printWin(currentPlayer.getPlayerName());
                } else if (gameBoard.isDraw()){
                    prompt.printDraw();
                }

                this.swapPlayer();
            } else {
                prompt.printInvalidMove();
            }
        }
    }

    private void swapPlayer() {
        if(currentPlayer == player1){
            currentPlayer = player2;
        } else currentPlayer = player1;
    }
}
