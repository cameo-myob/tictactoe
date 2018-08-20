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

public class Game {
    private String currentPlayerToken = "X";
    private GameBoard gameBoard;
    private Prompt prompt;

    public Game(GameBoard board, Prompt prompt){
        this.gameBoard = board;
        this.prompt = prompt;
    }

    public void run() {
        prompt.gameWelcome();
        prompt.printBoard(gameBoard.returnBoard());

        while(!gameBoard.isWon() && !gameBoard.isDraw()){
            String userMove = prompt.getUserMove(currentPlayerToken);
            if(userMove.equals("q")){
                break;
            } else if (gameBoard.isValidMove(userMove)){
                gameBoard.addMove(userMove, currentPlayerToken);
                prompt.printConfirmedMove();
                prompt.printBoard(gameBoard.returnBoard());
                if(gameBoard.isWon()){
                    prompt.printWin(currentPlayerToken);
                } else if (gameBoard.isDraw()){
                    prompt.printDraw();
                }

                this.swapPlayerToken();
            } else {
                prompt.printInvalidMove();
            }
        }
    }

    private void swapPlayerToken() {
        if(currentPlayerToken.equals("X")){
            currentPlayerToken = "O";
        } else currentPlayerToken = "X";
    }
}
